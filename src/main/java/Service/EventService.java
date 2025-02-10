package Service;

import DAO.EventDAO;
import Entity.Event;

import java.sql.Date;
import java.util.List;

public class EventService {
    private EventDAO eventDAO;

    public EventService(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public void createEvent(String name, String location, Date date, String genre) {
        Event event = new Event(name, location, date, genre);
        eventDAO.save(event);
    }

    public Event getEventById(Long id) {
        return eventDAO.findById(id);
    }

    public List<Event> getAllEvents() {
        return eventDAO.findAll();
    }

    public void deleteEvent(Event event) {
        eventDAO.delete(event);
    }
}