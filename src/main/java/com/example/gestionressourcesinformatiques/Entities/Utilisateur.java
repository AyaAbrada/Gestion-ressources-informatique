package com.example.gestionressourcesinformatiques.Entities;

import jakarta.persistence.*;


import java.util.List;

@Entity

public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Tickets créés par l'utilisateur (s'il est un utilisateur simple)
    @OneToMany(mappedBy = "utilisateur")
    private List<Ticket> ticketsCrees;

    // Tickets assignés au technicien
    @OneToMany(mappedBy = "technicien")
    private List<Ticket> ticketsAssignes;

    public Utilisateur() {}

    public Utilisateur(long id, String fullName, String username, String password, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
