package com.example.gestionressourcesinformatiques.Repositories;
import com.example.gestionressourcesinformatiques.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {}

