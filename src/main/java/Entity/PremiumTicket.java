package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "PremiumTicket.findAll", query = "SELECT p.price FROM PremiumTicket p")
public class PremiumTicket extends Ticket {
    private String seatNumber;

    public PremiumTicket() {}

    public PremiumTicket(String type, double price, Event event, String seatNumber) {
        super(type, price, event);
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}