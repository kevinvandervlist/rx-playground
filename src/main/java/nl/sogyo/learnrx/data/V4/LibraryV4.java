package nl.sogyo.learnrx.data.V4;

import nl.sogyo.learnrx.data.V2.Boxart;

import java.util.ArrayList;
import java.util.List;

public class LibraryV4 {

    public static final ReleaseV4 DieHard = new ReleaseV4(
            70111470,
            "Die Hard",
            Boxart.boxartFactory(
                    new Boxart(150, 200, "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"),
                    new Boxart(200, 200, "http://cdn-0.nflximg.com/images/2891/DieHard200.jpg")),
            "http://api.netflix.com/catalog/titles/movies/70111470",
            4.0,
            InterestingMoment.interestingMomentFactory(
                    new InterestingMoment("End", 213432),
                    new InterestingMoment("Start", 64534),
                    new InterestingMoment("Middle", 323133)
            ));

    public static final ReleaseV4 BadBoys = new ReleaseV4(
            654356453,
            "Bad Boys",
            Boxart.boxartFactory(
                    new Boxart(200, 200, "http://cdn-0.nflximg.com/images/2891/BadBoys200.jpg"),
                    new Boxart(150, 200, "http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg")),
            "http://api.netflix.com/catalog/titles/movies/70111470",
            5.0,
            InterestingMoment.interestingMomentFactory(
                    new InterestingMoment("End", 54654754),
                    new InterestingMoment("Start", 43524243),
                    new InterestingMoment("Middle", 6575665)
            ));

    public static final ReleaseV4 TheChamber = new ReleaseV4(
            65432445,
            "The Chamber",
            Boxart.boxartFactory(
                    new Boxart(150, 200, "http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg"),
                    new Boxart(200, 200, "http://cdn-0.nflximg.com/images/2891/TheChamber200.jpg")),
            "http://api.netflix.com/catalog/titles/movies/70111470",
            4.0,
            InterestingMoment.interestingMomentFactory(
                    new InterestingMoment("End", 132423),
                    new InterestingMoment("Start", 54637425),
                    new InterestingMoment("Middle", 3452343)
            ));

    public static final ReleaseV4 Fracture = new ReleaseV4(
            675465,
            "The Fracture",
            Boxart.boxartFactory(
                    new Boxart(200, 200, "http://cdn-0.nflximg.com/images/2891/Fracture200.jpg"),
                    new Boxart(150, 200, "http://cdn-0.nflximg.com/images/2891/Fracture150.jpg"),
                    new Boxart(300, 200, "http://cdn-0.nflximg.com/images/2891/Fracture300.jpg")),
            "http://api.netflix.com/catalog/titles/movies/70111470",
            5.0,
            InterestingMoment.interestingMomentFactory(
                    new InterestingMoment("End", 45632456),
                    new InterestingMoment("Start", 234534),
                    new InterestingMoment("Middle", 3453434)
            ));

    public static List<ReleaseV4> getReleases() {
        List<ReleaseV4> releases = new ArrayList<>();

        releases.add(BadBoys);
        releases.add(DieHard);
        releases.add(TheChamber);
        releases.add(Fracture);

        return releases;
    }

    public static List<MovieListV4> getMovieListReleases() {
        List<MovieListV4> ml = new ArrayList<>(2);

        MovieListV4 _new = new MovieListV4("New releases");
        _new.releases.add(LibraryV4.BadBoys);
        _new.releases.add(LibraryV4.DieHard);

        MovieListV4 _drama = new MovieListV4("Dramas");
        _drama.releases.add(LibraryV4.TheChamber);
        _drama.releases.add(LibraryV4.Fracture);

        ml.add(_new);
        ml.add(_drama);
        return ml;
    }
}
