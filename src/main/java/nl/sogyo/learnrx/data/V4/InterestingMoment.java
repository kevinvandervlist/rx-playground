package nl.sogyo.learnrx.data.V4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterestingMoment {

    public final String type;
    public final Integer time;

    public InterestingMoment(String type, Integer time) {
        this.type = type;
        this.time = time;
    }

    public static List<InterestingMoment> interestingMomentFactory(InterestingMoment... moments) {
        List<InterestingMoment> bms = new ArrayList<>(moments.length);
        Collections.addAll(bms, moments);
        return bms;
    }
}
