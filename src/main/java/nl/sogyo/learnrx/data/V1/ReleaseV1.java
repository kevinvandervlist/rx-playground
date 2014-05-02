package nl.sogyo.learnrx.data.V1;

import java.util.List;

public class ReleaseV1 {

    public final Integer id;
    public final String title;
    public final String boxart;
    public final String uri;
    public final Double rating;
    public final List<BookmarkV1> bookmark;

    public ReleaseV1(int id, String title, String boxart, String uri, Double rating, List<BookmarkV1> bookmark) {
        this.id = id;
        this.title = title;
        this.boxart = boxart;
        this.uri = uri;
        this.rating = rating;
        this.bookmark = bookmark;
    }

}
