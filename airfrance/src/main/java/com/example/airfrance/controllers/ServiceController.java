package com.example.airfrense.controllers;

import com.example.airfrense.models.ServiceModel;
import com.example.airfrense.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private final ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping
    public List<ServiceModel> listAllServices() {
        return (List<ServiceModel>) serviceRepository.findAll();
    }

    @PostMapping
    public ServiceModel createService(@RequestBody ServiceModel serviceModel) {
        return serviceRepository.save(serviceModel);
    }

    @GetMapping("/{id}")
    public ServiceModel getServiceDetails(@PathVariable UUID id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));
    }

    @PutMapping("/{id}")
    public ServiceModel updateService(@PathVariable UUID id, @RequestBody ServiceModel updatedService) {
        ServiceModel service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));

        service.setName(updatedService.getName());
        service.setDescription(updatedService.getDescription());
        return serviceRepository.save(service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable UUID id) {
        if (!serviceRepository.existsById(id)) {
            throw new RuntimeException("Service not found with id: " + id);
        }
        serviceRepository.deleteById(id);
    }
}
