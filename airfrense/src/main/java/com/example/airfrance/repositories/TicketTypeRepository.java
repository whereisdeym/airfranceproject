package com.example.airfrense.repositories;

import com.example.airfrense.models.TicketType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TicketTypeRepository extends CrudRepository<TicketType, UUID> {
}
