package DAO;

import Entity.Event;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EventDAO {
    private EntityManager entityManager;

    public EventDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event event) {
        entityManager.persist(event);
    }

    public Event findById(Long id) {
        return entityManager.find(Event.class, id);
    }

    public List<Event> findAll() {
        return entityManager.createQuery("from Event", Event.class).getResultList();
    }

    public void delete(Event event) {
        entityManager.remove(event);
    }
}