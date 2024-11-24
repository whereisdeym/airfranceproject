package com.example.airfrense.services;

import com.example.airfrense.models.ServiceModel;
import com.example.airfrense.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceModelService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Iterable<ServiceModel> findAll() {
        return serviceRepository.findAll();
    }

    public Optional<ServiceModel> findById(UUID id) {
        return serviceRepository.findById(id);
    }

    public ServiceModel save(ServiceModel service) {
        return serviceRepository.save(service);
    }

    public void deleteById(UUID id) {
        serviceRepository.deleteById(id);
    }
}
