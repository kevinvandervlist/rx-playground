package nl.sogyo.learnrx;

import nl.sogyo.learnrx.containers.Pair;
import nl.sogyo.learnrx.containers.Quadruple;
import nl.sogyo.learnrx.containers.Triple;
import nl.sogyo.learnrx.data.V1.BookmarkV1;
import nl.sogyo.learnrx.data.V1.LibraryV1;
import nl.sogyo.learnrx.data.V1.MovieListV1;
import nl.sogyo.learnrx.data.V1.ReleaseV1;
import nl.sogyo.learnrx.data.V2.Boxart;
import nl.sogyo.learnrx.data.V2.LibraryV2;
import nl.sogyo.learnrx.data.V2.MovieListV2;
import nl.sogyo.learnrx.data.V2.ReleaseV2;
import nl.sogyo.learnrx.data.V3.LibraryV3;
import nl.sogyo.learnrx.data.V3.ReleaseV3;
import nl.sogyo.learnrx.data.V4.LibraryV4;
import nl.sogyo.learnrx.data.V4.MovieListV4;
import nl.sogyo.learnrx.data.V5.*;
import nl.sogyo.learnrx.data.V6.StockV6;
import rx.Observable;

import java.util.Arrays;
import java.util.Map;

/**
 * The excercises are taken from the following project:
 * https://github.com/Reactive-Extensions/learnrx
 */

public class Excercises {
    public final Observable<ReleaseV1> releasesV1;
    public final Observable<MovieListV1> movielistsV1;
    public final Observable<ReleaseV2> releasesV2;
    public final Observable<MovieListV2> movielistsV2;
    public final Observable<Integer> ratings;
    public final Observable<Boxart> boxarts;
    public final Observable<ReleaseV3> releasesV3;
    public final Observable<BookmarkV1> bookmarks;
    public final Observable<MovieListV4> movielistsV4;
    public final Observable<VideoV5> videosV5;
    public final Observable<ListV5> listsV5;
    public final Observable<BoxartV5> boxartsV5;
    public final Observable<BookmarkV5> bookmarksV5;

    public Excercises() {
        releasesV1 = Observable.from(LibraryV1.getReleases());
        movielistsV1 = Observable.from(LibraryV1.getMovieListReleases());
        releasesV2 = Observable.from(LibraryV2.getReleases());
        movielistsV2 = Observable.from(LibraryV2.getMovieListReleases());
        ratings = Observable.from(Arrays.asList(2, 3, 1, 4, 5));
        boxarts = Observable.from(LibraryV2.getFractureBoxart());
        releasesV3 = Observable.from(LibraryV3.getReleases());
        bookmarks = Observable.from(BookmarkV1.bookmarkFactory(
                new BookmarkV1(470, 23432),
                new BookmarkV1(453, 234324),
                new BookmarkV1(445, 987834)
        ));
        movielistsV4 = Observable.from(LibraryV4.getMovieListReleases());
        videosV5 = Observable.from(LibraryV5.getVideos25());
        listsV5 = Observable.from(LibraryV5.getLists25());
        boxartsV5 = Observable.from(LibraryV5.getBoxart());
        bookmarksV5 = Observable.from(LibraryV5.getBookmarks());
    }

    /**
     * Exercise 5: Use map() to project an array of videos into an array of {id,title} pairs
     * use: releasesV1
     */
    public Observable<Pair<Integer, String>> excercise5() {
        return null;
    }

    /**
     * Exercise 8: Chain filter and map to collect the ids of videos that have a rating of 5.0
     * use: releasesV1
     */
    public Observable<Integer> excercise8() {
        return null;
    }

    /**
     * Use map() and mergeAll() to project and flatten the movieLists into an array of video ids
     * i.e.: Use map and flatMap();
     * use: movielistsV1
     */
    public Observable<Integer> excercise11() {
        return null;
    }

    /**
     * Exercise 14 (+12): Use flatMap() to retrieve id, title, and 150x200 box art url for every video
     * There's just more one thing: you can't use indexers. In other words, this is illegal:
     *   var itemInArray = movieLists[0];
     * use: movielistsV2
     */
    public Observable<Triple<Integer, String, String>> excercise14() {
        return null;
    }

    /**
     * Exercise 17: Retrieve the largest rating.
     * use: ratings
     */
    public Observable<Integer> excercise17() {
        return null;
    }

    /**
     * Exercise 18: Retrieve url of the largest boxart
     * use: boxarts
     */
    public Observable<String> excercise18() {
        return null;
    }

    /**
     * Exercise 19: Reducing with an initial value
     * Sometimes when we reduce an array, we want the reduced value to be a different type than the items stored in the array.
     * Let's say we have an array of videos and we want to reduce them to a single map where the key is the video id and the value is the video's title.
     * Use: releasesV3
     */
    public Observable<Map<Integer, String>> excercise19() {
        return null;
    }

    /**
     * Exercise 20: Retrieve the id, title, and smallest box art url for every video.
     * This is a variation of the problem we solved earlier, where we retrieved the url of the boxart with a width of 150px.
     * This time we'll use reduce() instead of filter() to retrieve the smallest box art in the boxarts array.
     * use: movielistsV2
     */
    public Observable<Triple<Integer, String, String>> excercise20() {
        return null;
    }

    /**
     * Exercise 23: Combine videos and bookmarks by index
     * For each video and bookmark pair, create a {videoId, bookmarkId} pair.
     * use: releasesV1 and bookmarks
     */
    public Observable<Pair<Integer, Integer>> excercise23() {
        return null;
    }

    /**
     * Exercise 24: Retrieve each video's id, title, middle interesting moment time, and smallest box art url.
     * This is a variation of the problem we solved earlier. This time each video has an interesting moments collection,
     * each representing a time during which a screenshot is interesting or representative of the title as a whole.
     * Notice that both the boxarts and interestingMoments arrays are located at the same depth in the tree.
     * Retrieve the time of the middle interesting moment and the smallest box art url simultaneously with zip().
     * Return an {id, title, time, url} object for each video.
     * use: movielistsV4
     */
    public Observable<Quadruple<Integer, String, Integer, String>> excercise24() {
        return null;
    }

    /**
     * Exercise 25: Converting from Arrays to Trees
     * We have 2 arrays each containing lists, and videos respectively.
     * Each video has a listId field indicating its parent list.
     * We want to build an array of list objects, each with a name and a videos array.
     * The videos array will contain the video's id and title.
     * In other words we want to build the following structure:
     * use: listsV5, videosV5
     */
    public Observable<MovieListV5<ReleaseV5>> excercise25() {
        return null;
    }

    /**
     * Exercise 26: Converting from Arrays to Deeper Trees
     * Let's try creating a deeper tree structure.
     * This time we have 4 seperate arrays each containing lists, videos, boxarts, and bookmarks respectively.
     * Each object has a parent id, indicating its parent. We want to build an array of list objects,
     * each with a name and a videos array. The videos array will contain the video's id, title, bookmark time,
     * and smallest boxart url. In other words we want to build the following structure:
     * <pre>
     * [{
     *     "name": "New Releases",
     *     "videos": [{
     *             "id": 65432445,
     *             "title": "The Chamber",
     *             "time": 32432,
     *             "boxart": "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"
     *         }, {
     *             "id": 675465,
     *             "title": "Fracture",
     *             "time": 3534543,
     *             "boxart": "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"
     *         }]
     * }, {
     *     "name": "Thrillers",
     *     "videos": [{
     *             "id": 70111470,
     *             "title": "Die Hard",
     *             "time": 645243,
     *             "boxart": "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"
     *         }, {
     *             "id": 654356453,
     *             "title": "Bad Boys",
     *             "time": 984934,
     *             "boxart": "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"
     * }]}]
     * </pre>
     *
     * use: listsV5, videosV5, boxartsV5, bookmarksV5
     */
    public Observable<MovieListV5<Quadruple<Integer, String, Integer, String>>> excercise26() {
        return null;
    }

    /**
     * Exercise 28: Stock Ticker
     * Let's try an easier question. Let's say we have a collection of all of the prices for
     * NASDAQ stocks over time. Every time the price of a stock changes on the NASDAQ ticker
     * an entry is added to this collection. Let's say that ten days ago you bought shares in
     * Microsoft, and now you want to print all of the MSFT share prices since then.
     * Filter the collection for MSFT trades starting from ten days ago. Note: this is not a trick question.
     * It's as easy as it seems
     * use: StockMarketV6.getRandomNASDAQ(25), Date tenDaysAgo = StockMarketV6.getNumDaysAgo(10);
     */
    public Observable<StockV6> excercise28() {
        return null;
    }
}
