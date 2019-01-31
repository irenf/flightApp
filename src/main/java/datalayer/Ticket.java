package datalayer;

import java.util.Objects;

public class Ticket {

    private final long id;

    public Ticket(final long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
