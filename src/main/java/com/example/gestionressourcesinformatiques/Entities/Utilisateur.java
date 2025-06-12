package com.example.gestionressourcesinformatiques.Entities;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Utilisateur {
    private long id;
    private String fullName;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}
