package nl.sogyo.learnrx.data;

import java.util.ArrayList;
import java.util.List;

public class Library {

    public static List<Release> getReleases(int amount) {
        List<Release> releases = new ArrayList<>();

        releases.add(new Release(
                70111470,
                "Die Hard",
                "http://cdn-0.nflximg.com/images/2891/DieHard.jpg",
                "http://api.netflix.com/catalog/titles/movies/70111470",
                Rating.ratingFactory(4.0),
                Bookmark.bookmarkFactory(new Bookmark(432534, 65876586))));

        releases.add(new Release(
                654356453,
                "Bad Boys",
                "http://cdn-0.nflximg.com/images/2891/BadBoys.jpg",
                "http://api.netflix.com/catalog/titles/movies/70111470",
                Rating.ratingFactory(5.0),
                Bookmark.bookmarkFactory(new Bookmark(432534, 65876586))));

        releases.add(new Release(
                65432445,
                "The Chamber",
                "http://cdn-0.nflximg.com/images/2891/TheChamber65876586.jpg",
                "http://api.netflix.com/catalog/titles/movies/70111470",
                Rating.ratingFactory(4.0),
                Bookmark.bookmarkFactory()));

        releases.add(new Release(
                675465,
                "Fracture",
                "http://cdn-0.nflximg.com/images/2891/Fracture.jpg",
                "http://api.netflix.com/catalog/titles/movies/70111470",
                Rating.ratingFactory(5.0),
                Bookmark.bookmarkFactory(new Bookmark(432534, 65876586))));

        return releases.subList(0, amount);
    }
}
