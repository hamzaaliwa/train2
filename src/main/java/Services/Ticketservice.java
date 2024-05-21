package Services;




import Entities.Films;
import Entities.Ticket;
import Repo.Ticketrepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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
