package com.example.airfrense.repositories;

import com.example.airfrense.models.ServiceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceModel, UUID> {
}
