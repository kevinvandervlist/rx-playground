package nl.sogyo.learnrx.containers;

public class Triple<A, B, C> {

    public final A first;
    public final B second;
    public final C third;

    public Triple(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public String toString() {
        return first + ":" + second + ":" + third;
    }

    public boolean equals(Object other) {
        if(other == null) {
            return false;
        }
        if(! (other instanceof Triple)) {
            return false;
        }
        Triple o = (Triple) other;
        return this.first.equals(o.first) &&
                this.second.equals(o.second) &&
                this.third.equals(o.third);
    }
}
