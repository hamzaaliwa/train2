package Repo;

import Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Ticketrepo extends JpaRepository<Ticket,Long> {
    Optional<Ticket> findById(Long id);
}
