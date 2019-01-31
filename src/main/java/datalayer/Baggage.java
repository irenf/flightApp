package datalayer;

import java.util.Objects;

public class Baggage {

    private final String id;

    private final Destination destination;

    private boolean checkedIn;

    public Baggage(String id, Destination destination) {
        this.id = id;
        this.destination = destination;
    }

    public String getId() {
        return id;
    }

    public Destination getDestination() {
        return destination;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baggage baggage = (Baggage) o;
        return checkedIn == baggage.checkedIn &&
                Objects.equals(id, baggage.id) &&
                Objects.equals(destination, baggage.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destination, checkedIn);
    }
}
