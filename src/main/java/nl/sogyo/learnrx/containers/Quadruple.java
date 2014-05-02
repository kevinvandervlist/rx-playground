package nl.sogyo.learnrx.containers;

public class Quadruple<A, B, C, D> {

    public final A first;
    public final B second;
    public final C third;
    public final D fourth;

    public Quadruple(A first, B second, C third, D fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public String toString() {
        return first + ":" + second + ":" + third + ":" + fourth;
    }

    public boolean equals(Object other) {
        if(other == null) {
            return false;
        }
        if(! (other instanceof Quadruple)) {
            return false;
        }
        Quadruple o = (Quadruple) other;
        return this.first.equals(o.first) &&
                this.second.equals(o.second) &&
                this.third.equals(o.third) &&
                this.fourth.equals(o.fourth);
    }
}
