package com.example.gestionressourcesinformatiques.Controller;

import com.example.gestionressourcesinformatiques.Entities.StatutTicket;
import com.example.gestionressourcesinformatiques.Entities.Ticket;
import com.example.gestionressourcesinformatiques.Services.TicketService;
import com.example.gestionressourcesinformatiques.dto.TicketRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/creer")
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketRequest request) {
        try {
            Ticket ticket = new Ticket();
            ticket.setTitre(request.getTitre());
            ticket.setDateCreation(LocalDate.now());
            ticket.setStatut(StatutTicket.NOUVEAU);

            // Juste besoin des IDs, le service charge les objets complets
            ticket.setUtilisateur(request.getUtilisateur());
            ticket.setTechnicien(request.getTechnicien());
            ticket.setEquipement(request.getEquipement());

            Ticket savedTicket = ticketService.save(ticket);
            return ResponseEntity.ok(savedTicket);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{ticketId}/assign/{technicianId}")
    public ResponseEntity<Ticket> assignTechnician(@PathVariable Long ticketId, @PathVariable Long technicianId) {
        try {
            Ticket ticket = ticketService.assignerTechnicien(ticketId, technicianId);
            return ResponseEntity.ok(ticket);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/technicien/{technicianId}")
    public ResponseEntity<List<Ticket>> getTicketsByTechnician(@PathVariable Long technicianId) {
        List<Ticket> tickets = ticketService.getTicketsParTechnicien(technicianId);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getTickets());
    }

    @PutMapping("/{ticketId}/statut")
    public ResponseEntity<Ticket> updateTicketStatus(@PathVariable Long ticketId, @RequestParam StatutTicket statut) {
        try {
            Ticket updatedTicket = ticketService.mettreAJourStatut(ticketId, statut);
            return ResponseEntity.ok(updatedTicket);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
