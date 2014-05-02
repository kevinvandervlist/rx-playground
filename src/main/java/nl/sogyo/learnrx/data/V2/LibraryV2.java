package nl.sogyo.learnrx.data.V2;

import nl.sogyo.learnrx.data.V1.BookmarkV1;

import java.util.ArrayList;
import java.util.List;

public class LibraryV2 {

    public static final ReleaseV2 DieHard = new ReleaseV2(
            70111470,
            "Die Hard",
            Boxart.boxartFactory(
                    new Boxart(150, 200, "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"),
                    new Boxart(200, 200, "http://cdn-0.nflximg.com/images/2891/DieHard200.jpg")),
            "http://api.netflix.com/catalog/titles/movies/70111470",
            4.0,
            BookmarkV1.bookmarkFactory(new BookmarkV1(432534, 65876586)));

    public static final ReleaseV2 BadBoys = new ReleaseV2(
            654356453,
            "Bad Boys",
            Boxart.boxartFactory(
                    new Boxart(200, 200, "http://cdn-0.nflximg.com/images/2891/BadBoys200.jpg"),
                    new Boxart(150, 200, "http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg")),
            "http://api.netflix.com/catalog/titles/movies/70111470",
            5.0,
            BookmarkV1.bookmarkFactory(new BookmarkV1(432534, 65876586)));

    public static final ReleaseV2 TheChamber = new ReleaseV2(
            65432445,
            "The Chamber",
            Boxart.boxartFactory(
                    new Boxart(150, 200, "http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg"),
                    new Boxart(200, 200, "http://cdn-0.nflximg.com/images/2891/TheChamber200.jpg")),
            "http://api.netflix.com/catalog/titles/movies/70111470",
            4.0,
            BookmarkV1.bookmarkFactory());

    public static final ReleaseV2 Fracture = new ReleaseV2(
            675465,
            "The Fracture",
            Boxart.boxartFactory(
                    new Boxart(200, 200, "http://cdn-0.nflximg.com/images/2891/Fracture200.jpg"),
                    new Boxart(150, 200, "http://cdn-0.nflximg.com/images/2891/Fracture150.jpg"),
                    new Boxart(300, 200, "http://cdn-0.nflximg.com/images/2891/Fracture300.jpg")),
            "http://api.netflix.com/catalog/titles/movies/70111470",
            5.0,
            BookmarkV1.bookmarkFactory(new BookmarkV1(432534, 65876586)));

    public static List<ReleaseV2> getReleases() {
        List<ReleaseV2> releases = new ArrayList<>();

        releases.add(BadBoys);
        releases.add(DieHard);
        releases.add(TheChamber);
        releases.add(Fracture);

        return releases;
    }

    public static List<MovieListV2> getMovieListReleases() {
        List<MovieListV2> ml = new ArrayList<>(2);

        MovieListV2 _new = new MovieListV2("New releases");
        _new.releases.add(LibraryV2.BadBoys);
        _new.releases.add(LibraryV2.DieHard);

        MovieListV2 _drama = new MovieListV2("Dramas");
        _drama.releases.add(LibraryV2.TheChamber);
        _drama.releases.add(LibraryV2.Fracture);

        ml.add(_new);
        ml.add(_drama);
        return ml;
    }

    public static List<Boxart> getFractureBoxart() {
        List<Boxart> boxarts = new ArrayList<>(4);
        boxarts.add(new Boxart(200, 200, "http://cdn-0.nflximg.com/images/2891/Fracture200.jpg"));
        boxarts.add(new Boxart(150, 200, "http://cdn-0.nflximg.com/images/2891/Fracture150.jpg"));
        boxarts.add(new Boxart(300, 200, "http://cdn-0.nflximg.com/images/2891/Fracture300.jpg"));
        boxarts.add(new Boxart(425, 150, "http://cdn-0.nflximg.com/images/2891/Fracture425.jpg"));
        return boxarts;
    }
}
