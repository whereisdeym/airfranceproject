package com.example.airfrense.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    private String name;

    @Column(length = 255)
    private String description;

    @OneToMany(mappedBy = "ticketType", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    @JsonIgnore
    private Set<Reservation> reservations = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "ticket_type_service",
            joinColumns = @JoinColumn(name = "ticket_type_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<ServiceModel> services = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<ServiceModel> getServices() {
        return services;
    }

    public void setServices(Set<ServiceModel> services) {
        this.services = services;
    }
}
