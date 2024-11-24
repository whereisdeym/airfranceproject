package com.example.airfrense.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class ServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 255)
    private String name;

    @Column(length = 255)
    private String description;

    @ManyToMany(mappedBy = "services")
    private Set<TicketType> ticketTypes = new HashSet<>();

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

    public Set<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(Set<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }
}
