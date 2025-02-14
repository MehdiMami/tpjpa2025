package DAO;

import Entity.PremiumTicket;
import jakarta.persistence.EntityManager;
import java.util.List;

public class PremiumTicketDAO {
    private EntityManager entityManager;

    public PremiumTicketDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(PremiumTicket premiumTicket) {
        entityManager.persist(premiumTicket);
    }

    public PremiumTicket findById(Long id) {
        return entityManager.find(PremiumTicket.class, id);
    }

    public List<PremiumTicket> findAll() {
        return entityManager.createQuery("from PremiumTicket", PremiumTicket.class).getResultList();
    }

    public void delete(PremiumTicket premiumTicket) {
        entityManager.remove(premiumTicket);
    }
}