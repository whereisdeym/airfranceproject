package com.example.airfrense.services;

import com.example.airfrense.models.TicketType;
import com.example.airfrense.repositories.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TicketTypeService {

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    public Iterable<TicketType> findAll() {
        return ticketTypeRepository.findAll();
    }

    public Optional<TicketType> findById(UUID id) {
        return ticketTypeRepository.findById(id);
    }

    public TicketType save(TicketType ticketType) {
        return ticketTypeRepository.save(ticketType);
    }

    public void deleteById(UUID id) {
        ticketTypeRepository.deleteById(id);
    }
}
