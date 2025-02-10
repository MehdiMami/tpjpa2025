package Entity;

import jakarta.persistence.*;
import Entity.Ticket;

import java.util.Date;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private Date date;
    private String genre;

    @OneToMany(mappedBy = "event")
    private List<Ticket> tickets;

    public Event(String name, String location, Date date, String genre) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.genre = genre;
    }

    public Event() {
        this.name = "";
        this.location = "";
        this.date = new Date();
        this.genre = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    // Constructors, getters, and setters
}