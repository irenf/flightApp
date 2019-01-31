package services;

import api.IBaggageService;
import cache.InMemoryCache;
import database.BaggageDAO;
import datalayer.Baggage;

public class BaggageService implements IBaggageService {

    private final BaggageDAO baggageDAO;

    private final InMemoryCache<String, Baggage> baggagesCache;

    public BaggageService(BaggageDAO baggageDAO) {
        this.baggageDAO = baggageDAO;
        baggagesCache = new InMemoryCache<>(15);
    }

    public boolean checkInBaggage(final long destinationId, final String baggageId) {
        Baggage baggage = baggagesCache.get(baggageId);
        if (baggage == null) {
            baggage = baggageDAO.findBaggageById(baggageId);
            if (baggage != null) {
                baggagesCache.set(baggageId, baggage);
            }
        }
        if (baggage == null) {
            return false;
        }

        if (baggage.getDestination().getId() != destinationId) {
            return false;
        }
        baggage.setCheckedIn(true);
        return true;
    }
}
