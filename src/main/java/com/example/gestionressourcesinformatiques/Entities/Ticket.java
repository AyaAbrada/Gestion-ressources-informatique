package com.example.gestionressourcesinformatiques.Entities;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class Ticket {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur; // créateur du ticket

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private Utilisateur technicien; // technicien assigné

    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipement; // équipement concerné

    @Enumerated(EnumType.STRING)
    private StatutTicket statut; // NOUVEAU, EN_COURS, RESOLU

    private String titre;
    private LocalDate dateCreation;
    private String statut;
}
