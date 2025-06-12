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


}

