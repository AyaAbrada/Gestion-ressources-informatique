package com.example.gestionressourcesinformatiques.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Panne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Panne(Long id, String description, LocalDateTime date, Equipement equipement) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.equipement = equipement;
    }
    public Panne() {}
}

