package nl.sogyo.learnrx.data.V2;

import nl.sogyo.learnrx.data.V1.BookmarkV1;

import java.util.List;

public class ReleaseV2 {

    public final Integer id;
    public final String title;
    public final List<Boxart> boxart;
    public final String uri;
    public final Double rating;
    public final List<BookmarkV1> bookmark;

    public ReleaseV2(int id, String title, List<Boxart> boxart, String uri, Double rating, List<BookmarkV1> bookmark) {
        this.id = id;
        this.title = title;
        this.boxart = boxart;
        this.uri = uri;
        this.rating = rating;
        this.bookmark = bookmark;
    }
}
