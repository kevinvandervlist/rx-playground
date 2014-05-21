package nl.sogyo.learnrx.data.schiphol;

import java.util.Objects;

public class Departure {
    public final String flightNumber; // just take pFlightNumber
    public final String flightPrefix;
    public final String flightSuffix;
    public final String destinationAirport;
    public final String scheduled;
    public final String status;
    public final String hall;
    public final String carrier;

    private final int hashcode;

    public Departure(String flightNumber, String flightPrefix, String flightSuffix, String destinationAirport,
                     String scheduled, String status, String hall, String carrier) {
        this.flightNumber = flightNumber;
        this.flightPrefix = flightPrefix;
        this.flightSuffix = flightSuffix;
        this.destinationAirport = destinationAirport;
        this.scheduled = scheduled;
        this.status = status;
        this.hall = hall;
        this.carrier = carrier;

        this.hashcode = Objects.hash(flightNumber, flightPrefix, flightSuffix, destinationAirport,
                scheduled, status, hall, carrier);
    }

    public String toString() {
        return "Flight " + flightNumber + " (Scheduled: " + scheduled +
                ") to " + destinationAirport + " is status " + status;
    }

    @Override
    public boolean equals(Object other) {
        if(this == other) {
            return true;
        }
        if(! (other instanceof Departure)) {
            return false;
        }
        Departure o = (Departure) other;
        return equalsExceptStatus(other) && this.status.equals(o.status);

    }

    public boolean equalsExceptStatus(Object other) {
        if(this == other) {
            return true;
        }
        if(! (other instanceof Departure)) {
            return false;
        }
        Departure o = (Departure) other;
        return this.flightNumber.equals(o.flightNumber) &&
                this.flightPrefix.equals(o.flightPrefix) &&
                this.flightSuffix.equals(o.flightSuffix) &&
                this.destinationAirport.equals(o.destinationAirport) &&
                this.scheduled.equals(o.scheduled) &&
                this.hall.equals(o.hall) &&
                this.carrier.equals(o.carrier);
    }

    @Override
    public int hashCode() {
        return hashcode;
    }
}
