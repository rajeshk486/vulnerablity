package Tamola;
import java.util.UUID;

public class Player {
    private String id;
    private String name;
    private Ticket ticket;

    public Player(String name, Ticket ticket) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.ticket = ticket;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
