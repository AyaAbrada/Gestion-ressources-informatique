package com.example.gestionressourcesinformatiques.Controller;
import com.example.gestionressourcesinformatiques.Entities.StatutTicket;
import com.example.gestionressourcesinformatiques.Entities.Ticket;
import com.example.gestionressourcesinformatiques.Services.TicketService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        ticket.setStatut(StatutTicket.NOUVEAU);
        ticket.setDateCreation(LocalDate.now());
        return ticketService.save(ticket);
    }

    @PutMapping("/{id}/assign/{technicienId}")
    public Ticket assigner(@PathVariable Long id, @PathVariable Long technicienId) {
        return ticketService.assignerTechnicien(id, technicienId);
    }

    @GetMapping("/technicien/{id}")
    public List<Ticket> ticketsTechnicien(@PathVariable Long id) {
        return ticketService.getTicketsParTechnicien(id);
    }

    @PutMapping("/{id}/statut")
    public Ticket updateStatut(@PathVariable Long id, @RequestParam StatutTicket statut) {
        return ticketService.mettreAJourStatut(id, statut);
    }
}

