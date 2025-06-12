package com.example.gestionressourcesinformatiques.Entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Equipement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;
    private String etat;

    @OneToMany(mappedBy = "equipement")
    private List<Panne> pannes;


}

