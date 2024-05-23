package com.example.gestion_tickets.Controllers;


import com.example.gestion_tickets.Entities.Ticket;
import com.example.gestion_tickets.Repo.Ticketrepo;
import com.example.gestion_tickets.Services.Ticketservice;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/tickets"})
@CrossOrigin("*")
public class Ticketcontroller {
    private Ticket ticket;
    @Autowired
    private Ticketservice ticketservice;
    @Autowired
    private Ticketrepo ticketrepo;

    @GetMapping
    public List<Ticket> getetudiant(){
        return ticketservice.listes_films();
    }
    @GetMapping({"/{id}"})
    public Ticket chercheretudiant(@PathVariable long id ){
        return ticketservice.trouver_ticket(id);
    }
    @DeleteMapping({"/{id}"})
    public String supprimer_etudiant(@PathVariable long id){
        ticketservice.supprimer_ticket(id);
        return "etudiant de numero "+ id +"est supprimé";
    }
    @PostMapping
    public Ticket ajouter_etudiant(@RequestBody Ticket e){
        return ticketservice.creer_ticket(e);
    }
    @PutMapping
    public Ticket misajour_etudiant(@RequestBody Ticket e){
        return ticketservice.creer_ticket(e);
    }

    @DeleteMapping
    public String suprime(){
        ticketservice.supprime_tout();
        return "tout est supprimés";
    }



}
@Data
@ToString
class TicketsForm {
    private String nomClient;
    private Integer codePayment;
    private List<Long> tickets = new ArrayList<>();
}
