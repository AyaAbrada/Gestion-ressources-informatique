package com.example.gestionressourcesinformatiques.dto;

import com.example.gestionressourcesinformatiques.Entities.Equipement;
import com.example.gestionressourcesinformatiques.Entities.Utilisateur;

public class TicketRequest {
    private String titre;
    private Utilisateur utilisateur;
    private Utilisateur technicien;
    private Equipement equipement;

    // Getters & Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getTechnicien() {
        return technicien;
    }

    public void setTechnicien(Utilisateur technicien) {
        this.technicien = technicien;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }
}
