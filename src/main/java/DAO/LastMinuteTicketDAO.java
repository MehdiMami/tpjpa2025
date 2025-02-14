package DAO;

import Entity.LastMinuteTicket;
import jakarta.persistence.EntityManager;
import java.util.List;

public class LastMinuteTicketDAO {
    private EntityManager entityManager;

    public LastMinuteTicketDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(LastMinuteTicket lastMinuteTicket) {
        entityManager.persist(lastMinuteTicket);
    }

    public LastMinuteTicket findById(Long id) {
        return entityManager.find(LastMinuteTicket.class, id);
    }

    public List<LastMinuteTicket> findAll() {
        return entityManager.createQuery("from LastMinuteTicket", LastMinuteTicket.class).getResultList();
    }

    public void delete(LastMinuteTicket lastMinuteTicket) {
        entityManager.remove(lastMinuteTicket);
    }
}