package DAO;

import Entity.Ticket;
import jakarta.persistence.EntityManager;
import java.util.List;

public class TicketDAO {
    private EntityManager entityManager;

    public TicketDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Ticket ticket) {
        entityManager.persist(ticket);
    }

    public Ticket findById(Long id) {
        return entityManager.find(Ticket.class, id);
    }

    public List<Ticket> findAll() {
        return entityManager.createQuery("from Ticket", Ticket.class).getResultList();
    }

    public void delete(Ticket ticket) {
        entityManager.remove(ticket);
    }
}