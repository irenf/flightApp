package services;

import data.DataSampleCreator;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        CouponService couponService = new CouponService(DataSampleCreator.createCouponDAO(5000));
        BaggageService baggageService = new BaggageService(DataSampleCreator.createBaggageDAO(5000));
        TicketService ticketService = new TicketService(DataSampleCreator.createTicketDAO(5000));
    }
}
