package database;

import datalayer.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketDAO {

    private final Map<Long, Ticket> tickets = new HashMap<>();

    public void addTicket(final Ticket ticket) {
        tickets.put(ticket.getId(), ticket);
    }

    public Ticket findTicketById(final long ticketId) {
        return tickets.get(ticketId);
    }


}
