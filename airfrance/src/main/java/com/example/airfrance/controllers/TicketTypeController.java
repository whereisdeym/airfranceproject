package com.example.airfrense.controllers;

import com.example.airfrense.models.ServiceModel;
import com.example.airfrense.models.TicketType;
import com.example.airfrense.repositories.ServiceRepository;
import com.example.airfrense.repositories.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/ticket-types")
public class TicketTypeController {

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    public TicketTypeController(TicketTypeRepository ticketTypeRepository) {
        this.ticketTypeRepository = ticketTypeRepository;
    }

    @GetMapping
    public Iterable<TicketType> listAll() {
        return ticketTypeRepository.findAll();
    }

    @PostMapping
    public TicketType create(@RequestBody TicketType ticketType) {
        return ticketTypeRepository.save(ticketType);
    }

    // Add a service from the TicketType Endpoint
    @PatchMapping("/{id}/add-service/{serviceId}")
    public TicketType addServiceToTicketType(@PathVariable UUID id, @PathVariable UUID serviceId) {
        TicketType ticketType = ticketTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TicketType not found"));
        ServiceModel service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        ticketType.getServices().add(service);
        return ticketTypeRepository.save(ticketType);
    }

}
