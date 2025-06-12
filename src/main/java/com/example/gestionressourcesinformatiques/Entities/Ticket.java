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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Utilisateur getTechnicien() {
        return technicien;
    }

    public void setTechnicien(Utilisateur technicien) {
        this.technicien = technicien;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public StatutTicket getStatut() {
        return statut;
    }

    public void setStatut(StatutTicket statut) {
        this.statut = statut;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Ticket(long id, Utilisateur utilisateur, Utilisateur technicien, Equipement equipement, StatutTicket statut, String titre, LocalDate dateCreation) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.technicien = technicien;
        this.equipement = equipement;
        this.statut = statut;
        this.titre = titre;
        this.dateCreation = dateCreation;
    }
    public Ticket() {}
}
