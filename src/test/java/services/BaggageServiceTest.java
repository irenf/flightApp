package services;

import data.DataSampleCreator;
import org.junit.Assert;
import org.junit.Test;

public class BaggageServiceTest {

    @Test
    public void testCheckInBaggage() {
        BaggageService baggageService = new BaggageService(DataSampleCreator.createBaggageDAO(1000));
        Assert.assertTrue("Expecting to check in successfully baggae ID 5 with destination ID 5", baggageService.checkInBaggage(5, "5"));
        Assert.assertFalse("Expected to fail because baggage ID should be 5", baggageService.checkInBaggage(5, "6"));
        Assert.assertFalse("Expected to fail because baggage ID 5000 does not exist", baggageService.checkInBaggage(5000, "5000"));
    }
}
