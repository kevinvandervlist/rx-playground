package nl.sogyo.learnrx.data.V1;

import java.util.ArrayList;
import java.util.List;

public class LibraryV1 {

    public static final ReleaseV1 DieHard = new ReleaseV1(
            70111470,
            "Die Hard",
            "http://cdn-0.nflximg.com/images/2891/DieHard.jpg",
            "http://api.netflix.com/catalog/titles/movies/70111470",
            4.0,
            BookmarkV1.bookmarkFactory(new BookmarkV1(432534, 65876586)));

    public static final ReleaseV1 BadBoys = new ReleaseV1(
            654356453,
            "Bad Boys",
            "http://cdn-0.nflximg.com/images/2891/BadBoys.jpg",
            "http://api.netflix.com/catalog/titles/movies/70111470",
            5.0,
            BookmarkV1.bookmarkFactory(new BookmarkV1(432534, 65876586)));

    public static final ReleaseV1 TheChamber = new ReleaseV1(
            65432445,
            "The Chamber",
            "http://cdn-0.nflximg.com/images/2891/TheChamber65876586.jpg",
            "http://api.netflix.com/catalog/titles/movies/70111470",
            4.0,
            BookmarkV1.bookmarkFactory());

    public static final ReleaseV1 Fracture = new ReleaseV1(
            675465,
            "Fracture",
            "http://cdn-0.nflximg.com/images/2891/Fracture.jpg",
            "http://api.netflix.com/catalog/titles/movies/70111470",
            5.0,
            BookmarkV1.bookmarkFactory(new BookmarkV1(432534, 65876586)));

    public static List<ReleaseV1> getReleases() {
        List<ReleaseV1> releases = new ArrayList<>();

        releases.add(DieHard);
        releases.add(BadBoys);
        releases.add(TheChamber);
        releases.add(Fracture);

        return releases;
    }

    public static List<MovieListV1> getMovieListReleases() {
        List<MovieListV1> ml = new ArrayList<>(2);

        MovieListV1 _new = new MovieListV1("New releases");
        _new.releases.add(LibraryV1.BadBoys);
        _new.releases.add(LibraryV1.DieHard);

        MovieListV1 _drama = new MovieListV1("Dramas");
        _drama.releases.add(LibraryV1.TheChamber);
        _drama.releases.add(LibraryV1.Fracture);

        ml.add(_new);
        ml.add(_drama);
        return ml;
    }
}
