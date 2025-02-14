package Entity;

import jakarta.persistence.Entity;

@Entity
public class LastMinuteTicket extends Ticket {

    public LastMinuteTicket() {}

    public LastMinuteTicket(String type, double price, Event event) {
        super(type, price, event);
    }
}