package services;

import api.ITicketsService;
import cache.InMemoryCache;
import database.TicketDAO;
import datalayer.Ticket;

public class TicketService implements ITicketsService {

    private final TicketDAO ticketDAO;

    private final InMemoryCache<Long, Ticket> ticketsCache;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
        ticketsCache = new InMemoryCache<>(15);
    }

    public boolean isTicketAvailable(long ticketId) {
        Ticket ticket = ticketsCache.get(ticketId);
        if (ticket != null) {
            return true;
        }
        ticket = ticketDAO.findTicketById(ticketId);
        if (ticket != null) {
            ticketsCache.set(ticketId, ticket);
        }
        return ticket != null;
    }
}
