package com.example.airfrense.controllers;

import com.example.airfrense.models.Reservation;
import com.example.airfrense.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public Iterable<Reservation> listAllReservations() {
        return reservationService.listAll();
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        // Id and Reference are auto-generated
        reservation.setId(null);
        reservation.setReference(null);
        return reservationService.save(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable UUID id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        return reservationService.save(reservation);

    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable UUID id) {
        reservationService.deleteReservation(id);
    }

    @GetMapping("/{id}")
    public Reservation getReservationDetails(@PathVariable UUID id) {
        return reservationService.getDetails(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }
}
