package Service;

import DAO.TicketDAO;
import Entity.Event;
import Entity.Ticket;

import java.util.List;

public class TicketService {
    private TicketDAO ticketDAO;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public void createTicket(String type, double price, Event event) {
        Ticket ticket = new Ticket(type, price, event);
        ticketDAO.save(ticket);
    }

    public Ticket getTicketById(Long id) {
        return ticketDAO.findById(id);
    }

    public List<Ticket> getAllTickets() {
        return ticketDAO.findAll();
    }

    public void deleteTicket(Ticket ticket) {
        ticketDAO.delete(ticket);
    }
}