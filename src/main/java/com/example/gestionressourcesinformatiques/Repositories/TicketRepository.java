package com.example.gestionressourcesinformatiques.Repositories;
import com.example.gestionressourcesinformatiques.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByTechnicienId(Long id);
    List<Ticket> findByCreateurId(Long id);
}

