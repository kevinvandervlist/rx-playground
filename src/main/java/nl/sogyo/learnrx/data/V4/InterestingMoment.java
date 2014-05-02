package nl.sogyo.learnrx.data.V4;

import java.util.ArrayList;
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
        for(int i = 0; i < moments.length; i++) {
            bms.add(moments[i]);
        }
        return bms;
    }
}
