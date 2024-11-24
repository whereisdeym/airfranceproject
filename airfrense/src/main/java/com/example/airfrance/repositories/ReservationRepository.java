package com.example.airfrense.repositories;

import com.example.airfrense.models.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, UUID> {
}
