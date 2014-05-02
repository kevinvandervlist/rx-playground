package nl.sogyo.learnrx.data.V1;

import java.util.ArrayList;
import java.util.List;

public class BookmarkV1 {

    public final int id;
    public final long time;

    public BookmarkV1(int id, long timestamp) {
        this.id = id;
        this.time = timestamp;
    }

    public static List<BookmarkV1> bookmarkFactory(BookmarkV1... bookmarks) {
        List<BookmarkV1> bms = new ArrayList<>(bookmarks.length);
        for(int i = 0; i < bookmarks.length; i++) {
            bms.add(bookmarks[i]);
        }
        return bms;
    }
}
