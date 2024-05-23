package com.example.gestion_tickets.Services;





import com.example.gestion_tickets.Entities.Ticket;
import com.example.gestion_tickets.Repo.Ticketrepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class Ticketservice {

    private final Ticketrepo ticketrepo;

    public Ticket creer_ticket(Ticket e){
        return ticketrepo.save(e);
    }
    public void supprimer_ticket(long id){
        Ticket e =trouver_ticket(id);
        ticketrepo.delete(e);
    }
    public Ticket trouver_ticket(long id){
        Optional<Ticket> et = ticketrepo.findById(id);
        return et.get();
    }
    public List<Ticket> listes_films(){
        return ticketrepo.findAll();
    }
    public void supprime_tout(){
        ticketrepo.findAll().forEach(e->ticketrepo.delete(e));
    }
}
