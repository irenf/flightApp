package data;

import database.BaggageDAO;
import database.CouponDAO;
import database.TicketDAO;
import datalayer.Baggage;
import datalayer.Coupon;
import datalayer.Destination;
import datalayer.Ticket;

public class DataSampleCreator {

    public static TicketDAO createTicketDAO(final long maxTicketId) {
        TicketDAO ticketDAO = new TicketDAO();
        for (int i = 0; i < maxTicketId; i++) {
            ticketDAO.addTicket(new Ticket(i));
        }
        return ticketDAO;
    }

    public static BaggageDAO createBaggageDAO(final long maxBaggageId) {
        BaggageDAO baggageDAO = new BaggageDAO();
        for (int i = 0; i < maxBaggageId; i++) {
            baggageDAO.addBaggage(new Baggage(String.valueOf(i), new Destination(i, String.valueOf(i))));
        }
        return baggageDAO;
    }

    public static CouponDAO createCouponDAO(final long maxCouponId) {
        CouponDAO couponDAO = new CouponDAO();
        for (int i = 0; i < maxCouponId; i++) {
            couponDAO.addCoupon(new Coupon(i, Coupon.ECouponDiscount.values()[(int)(Math.random() * Coupon.ECouponDiscount.values().length)]));
        }
        return couponDAO;
    }
}
