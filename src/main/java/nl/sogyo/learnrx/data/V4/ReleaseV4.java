package nl.sogyo.learnrx.data.V4;

import nl.sogyo.learnrx.data.V2.Boxart;

import java.util.List;

public class ReleaseV4 {

    public final Integer id;
    public final String title;
    public final List<Boxart> boxart;
    public final String uri;
    public final Double rating;
    public final List<InterestingMoment> interestingMoments;

    public ReleaseV4(int id, String title, List<Boxart> boxart, String uri, Double rating, List<InterestingMoment> interestingMoments) {
        this.id = id;
        this.title = title;
        this.boxart = boxart;
        this.uri = uri;
        this.rating = rating;
        this.interestingMoments = interestingMoments;
    }
}
