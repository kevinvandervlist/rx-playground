package nl.sogyo.learnrx.data.schiphol;

public class DepartureEvent {

    public final DepartureState state;
    public final Departure departure;

    public DepartureEvent(DepartureState state, Departure departure) {
        this.state = state;
        this.departure = departure;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Departure)) {
            return false;
        }
        DepartureEvent o = (DepartureEvent) other;
        return this.state.equals(o.state) && this.departure.equals(o.departure);
    }

    @Override
    public String toString() {
        return state + ":" + this.departure;
    }
}
