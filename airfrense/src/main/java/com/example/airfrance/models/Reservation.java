package com.example.airfrense.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 255, unique = true)
    private String reference;

    @Column(nullable = false, length = 255)
    private String passengerName;

    @Column(nullable = false)
    private LocalDateTime departureDateTime;

    @Column(nullable = false, length = 255)
    private String departureCity;

    @Column(nullable = false, length = 255)
    private String arrivalCity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ticket_type_id", nullable = false)
    @JsonBackReference
    private TicketType ticketType;

    // Generate a unique reference
    @PrePersist
    private void generateReference() {
        if (reference == null || reference.isEmpty()) {
            reference = generateUniqueReference();
        }
    }

    private String generateUniqueReference() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int index = ThreadLocalRandom.current().nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
}
