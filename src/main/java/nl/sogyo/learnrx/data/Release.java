package nl.sogyo.learnrx.data;

import java.util.List;

public class Release {

    public final Integer id;
    public final String title;
    public final String boxart;
    public final String uri;
    public final List<Rating> rating;
    public final List<Bookmark> bookmark;

    public Release(int id, String title, String boxart, String uri, List<Rating> rating, List<Bookmark> bookmark) {
        this.id = id;
        this.title = title;
        this.boxart = boxart;
        this.uri = uri;
        this.rating = rating;
        this.bookmark = bookmark;
    }

}
