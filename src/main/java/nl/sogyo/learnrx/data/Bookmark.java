package nl.sogyo.learnrx.data;

import java.util.ArrayList;
import java.util.List;

public class Bookmark {

    private final int id;
    private final long timestamp;

    public Bookmark(int id, long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public static List<Bookmark> bookmarkFactory(Bookmark... bookmarks) {
        List<Bookmark> bms = new ArrayList<>(bookmarks.length);
        for(int i = 0; i < bookmarks.length; i++) {
            bms.add(bookmarks[i]);
        }
        return bms;
    }
}
