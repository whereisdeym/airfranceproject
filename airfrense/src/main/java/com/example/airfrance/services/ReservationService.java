package com.example.airfrense.services;

import com.example.airfrense.models.Reservation;
import com.example.airfrense.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Iterable<Reservation> listAll() {
        return reservationRepository.findAll();
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation createReservation(String passengerName, LocalDateTime departureDateTime,
                                         String departureCity, String arrivalCity) {
        Reservation reservation = new Reservation();
        reservation.setReference(UUID.randomUUID().toString()); // Auto-generate reference
        reservation.setPassengerName(passengerName);
        reservation.setDepartureDateTime(departureDateTime);
        reservation.setDepartureCity(departureCity);
        reservation.setArrivalCity(arrivalCity);
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> getDetails(UUID id) {
        return reservationRepository.findById(id);
    }

    public Reservation updateReservation(UUID id, String passengerName, LocalDateTime departureDateTime,
                                         String departureCity, String arrivalCity) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setPassengerName(passengerName);
        reservation.setDepartureDateTime(departureDateTime);
        reservation.setDepartureCity(departureCity);
        reservation.setArrivalCity(arrivalCity);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(UUID id) {
        reservationRepository.deleteById(id);
    }
}
