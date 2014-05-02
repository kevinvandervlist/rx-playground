package nl.sogyo.learnrx.data.V5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryV5 {

    public static List<VideoV5> getVideos25() {
        List<VideoV5> videos = new ArrayList<>(4);
        videos.add(new VideoV5(5434364, 65432445, "The Chamber"));
        videos.add(new VideoV5(5434364, 675465, "Fracture"));
        videos.add(new VideoV5(65456475, 70111470, "Die Hard"));
        videos.add(new VideoV5(65456475, 654356453, "Bad Boys"));
        return videos;
    }

    public static List<ListV5> getLists25() {
        List<ListV5> list = new ArrayList<>(2);
        list.add(new ListV5(5434364, "New Releases"));
        list.add(new ListV5(65456475, "Thrillers"));
        return list;
    }

    public static List<BoxartV5> getBoxart() {
        BoxartV5 tc130 = new BoxartV5(65432445, 130, 200, "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg");
        BoxartV5 tc200 = new BoxartV5(65432445, 200, 200, "http://cdn-0.nflximg.com/images/2891/TheChamber200.jpg");
        BoxartV5 f200 = new BoxartV5(675465, 200, 200, "http://cdn-0.nflximg.com/images/2891/Fracture200.jpg");
        BoxartV5 f120 = new BoxartV5(675465, 120, 200, "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg");
        BoxartV5 f300 = new BoxartV5(675465, 300, 200, "http://cdn-0.nflximg.com/images/2891/Fracture300.jpg");
        BoxartV5 dh150 = new BoxartV5(70111470, 150, 200, "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg");
        BoxartV5 dh200 = new BoxartV5(70111470, 200, 200, "http://cdn-0.nflximg.com/images/2891/DieHard200.jpg");
        BoxartV5 bb200 = new BoxartV5(654356453, 200, 200, "http://cdn-0.nflximg.com/images/2891/BadBoys200.jpg");
        BoxartV5 bb140 = new BoxartV5(654356453, 140, 200, "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg");
        return Arrays.asList(tc130, tc200, f200, f120, f300, dh150, dh200, bb200, bb140);
    }

    public static List<BookmarkV5> getBookmarks() {
        BookmarkV5 bm1 = new BookmarkV5(65432445, 32432);
        BookmarkV5 bm2 = new BookmarkV5(675465, 3534543);
        BookmarkV5 bm3 = new BookmarkV5(70111470, 645243);
        BookmarkV5 bm4 = new BookmarkV5(654356453, 984934);
        return Arrays.asList(bm1, bm2, bm3, bm4);
    }
}
