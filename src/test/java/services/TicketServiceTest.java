package services;

import data.DataSampleCreator;
import database.TicketDAO;
import org.junit.Assert;
import org.junit.Test;

public class TicketServiceTest {

    @Test
    public void testIsTicketAvailable() {
        TicketDAO ticketDAO = DataSampleCreator.createTicketDAO(1000);
        TicketService ticketService = new TicketService(ticketDAO);
        Assert.assertTrue("Expected to succeed with ticket ID 50", ticketService.isTicketAvailable(50));
        Assert.assertFalse("Expected to fail with ticket ID 5000", ticketService.isTicketAvailable(5000));
    }
}
