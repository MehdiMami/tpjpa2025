package Service;

import DAO.LastMinuteTicketDAO;
import DAO.PremiumTicketDAO;
import Entity.PremiumTicket;
import Entity.LastMinuteTicket;
import jakarta.persistence.EntityManager;
import java.util.List;

public class TicketService {
    private PremiumTicketDAO premiumTicketDAO;
    private LastMinuteTicketDAO lastMinuteTicketDAO;

    public TicketService(EntityManager entityManager) {
        this.premiumTicketDAO = new PremiumTicketDAO(entityManager);
        this.lastMinuteTicketDAO = new LastMinuteTicketDAO(entityManager);
    }

    public void savePremiumTicket(PremiumTicket premiumTicket) {
        premiumTicketDAO.save(premiumTicket);
    }

    public PremiumTicket findPremiumTicketById(Long id) {
        return premiumTicketDAO.findById(id);
    }

    public List<PremiumTicket> findAllPremiumTickets() {
        return premiumTicketDAO.findAll();
    }

    public void deletePremiumTicket(PremiumTicket premiumTicket) {
        premiumTicketDAO.delete(premiumTicket);
    }

    public void saveLastMinuteTicket(LastMinuteTicket lastMinuteTicket) {
        lastMinuteTicketDAO.save(lastMinuteTicket);
    }

    public LastMinuteTicket findLastMinuteTicketById(Long id) {
        return lastMinuteTicketDAO.findById(id);
    }

    public List<LastMinuteTicket> findAllLastMinuteTickets() {
        return lastMinuteTicketDAO.findAll();
    }

    public void deleteLastMinuteTicket(LastMinuteTicket lastMinuteTicket) {
        lastMinuteTicketDAO.delete(lastMinuteTicket);
    }
}