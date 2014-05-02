package nl.sogyo.learnrx.containers;

public class Pair<A, B> {

    public final A first;
    public final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return first + ":" + second;
    }

    public boolean equals(Object other) {
        if(other == null) {
            return false;
        }
        if(! (other instanceof Pair)) {
            return false;
        }
        Pair o = (Pair) other;
        return this.first.equals(o.first) && this.second.equals(o.second);
    }
}
