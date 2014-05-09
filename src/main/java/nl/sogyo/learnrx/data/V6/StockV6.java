package nl.sogyo.learnrx.data.V6;

import java.util.Date;

public class StockV6 {
    public final String name;
    public final Double value;
    public final Date timestamp;

    public StockV6(String name, Double value, Date timestamp) {
        this.name = name;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String toString() {
        return name + ": " + value + " at " + timestamp;
    }
}
