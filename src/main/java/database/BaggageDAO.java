package database;

import datalayer.Baggage;

import java.util.HashMap;
import java.util.Map;

public class BaggageDAO {

    private final Map<String, Baggage> baggages = new HashMap<>();

    public void addBaggage(final Baggage baggage) {
        baggages.put(baggage.getId(), baggage);
    }

    public Baggage findBaggageById(String baggageId) {
        return baggages.get(baggageId);
    }
}
