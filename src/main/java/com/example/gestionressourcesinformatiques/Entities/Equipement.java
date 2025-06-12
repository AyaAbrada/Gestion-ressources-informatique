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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public List<Panne> getPannes() {
        return pannes;
    }

    public void setPannes(List<Panne> pannes) {
        this.pannes = pannes;
    }

    public Equipement(Long id, String nom, String type, String etat, List<Panne> pannes) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.etat = etat;
        this.pannes = pannes;
    }
    public Equipement() {}
}

