package com.example.gestionressourcesinformatiques.Services;
import com.example.gestionressourcesinformatiques.Entities.Role;
import com.example.gestionressourcesinformatiques.Entities.StatutTicket;
import com.example.gestionressourcesinformatiques.Entities.Ticket;
import com.example.gestionressourcesinformatiques.Entities.Utilisateur;
import com.example.gestionressourcesinformatiques.Repositories.TicketRepository;
import com.example.gestionressourcesinformatiques.Repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UtilisateurRepository utilisateurRepository;

    public TicketService(TicketRepository ticketRepository, UtilisateurRepository utilisateurRepository) {
        this.ticketRepository = ticketRepository;
        this.utilisateurRepository = utilisateurRepository;
    }
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket assignerTechnicien(Long ticketId, Long technicienId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket non trouvé"));

        Utilisateur technicien = utilisateurRepository.findById(technicienId)
                .orElseThrow(() -> new RuntimeException("Technicien non trouvé"));

        if (technicien.getRole() != Role.TECHNICIEN) {
            throw new RuntimeException("Cet utilisateur n'est pas un technicien");
        }

        ticket.setTechnicien(technicien);
        ticket.setStatut(StatutTicket.EN_COURS);
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getTicketsParTechnicien(Long technicienId) {
        return ticketRepository.findByTechnicienId(technicienId);
    }

    public Ticket mettreAJourStatut(Long id, StatutTicket statut) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket non trouvé"));
        ticket.setStatut(statut);
        return ticketRepository.save(ticket);
    }
}
