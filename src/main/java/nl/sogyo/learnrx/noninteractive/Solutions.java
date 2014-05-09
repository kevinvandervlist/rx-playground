package nl.sogyo.learnrx.noninteractive;

import nl.sogyo.learnrx.containers.Quadruple;
import nl.sogyo.learnrx.containers.Triple;
import nl.sogyo.learnrx.containers.Pair;
import nl.sogyo.learnrx.data.V5.MovieListV5;
import nl.sogyo.learnrx.data.V5.ReleaseV5;
import nl.sogyo.learnrx.data.V6.StockMarketV6;
import nl.sogyo.learnrx.data.V6.StockV6;
import rx.Observable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Solutions extends Exercises {

    public Observable<Pair<Integer, String>> exercise5() {
        return releasesV1.map((x) -> new Pair<>(x.id, x.title));
    }

    public Observable<Integer> exercise8() {
        return releasesV1
            .filter((x) -> x.rating == 5.0)
            .map((x) -> x.id);
    }

    public Observable<Integer> exercise11() {
        return movielistsV1.flatMap((x) -> Observable.from(x.releases).map((y) -> y.id));
    }

    public Observable<Triple<Integer, String, String>> exercise14() {
        return movielistsV2.flatMap((mlist) ->
            Observable.from(mlist.releases).flatMap((release) ->
                Observable.from(release.boxart)
                    .filter((boxart) -> boxart.width == 150)
                    .map((boxart) ->
                    new Triple<>(release.id, release.title, boxart.url)
                )
            )
        );
    }

    public Observable<Integer> exercise17() {
        return ratings.reduce(Integer::max);
    }

    public Observable<String> exercise18() {
        return boxarts.reduce((accumulator, current) -> {
            if(accumulator.height * accumulator.width > current.width * current.height) {
                return accumulator;
            } else {
                return current;
            }
        }).map((boxart) -> boxart.url);
    }

    public Observable<Map<Integer, String>> exercise19() {
        Map<Integer, String> mymap = new HashMap<>();
        return releasesV3.reduce(mymap, (accumulator, current) -> {
            accumulator.put(current.id, current.title);
            return accumulator;
        });
    }

    public Observable<Triple<Integer, String, String>> exercise20() {
        return movielistsV2.flatMap((mlist) ->
            Observable.from(mlist.releases).flatMap((release) ->
                Observable.from(release.boxart).reduce((accumulator, current) -> {
                    if (accumulator.height * accumulator.width < current.width * current.height) {
                        return accumulator;
                    } else {
                        return current;
                    }
                }).map((boxart) -> new Triple<>(release.id, release.title, boxart.url))
            )
        );
    }

    public Observable<Pair<Integer, Integer>> exercise23() {
        return releasesV1.zip(bookmarks, (r, b) -> new Pair<>(r.id, b.id));
    }

    public Observable<Quadruple<Integer, String, Integer, String>> exercise24() {
        return movielistsV4.
            flatMap((movieList) -> Observable.from(movieList.releases).
                flatMap((release) -> Observable.zip(
                    Observable.from(release.boxart).reduce((acc, cur) -> {
                        if (acc.height * acc.width < cur.width * cur.height) {
                            return acc;
                        } else {
                            return cur;
                        }
                    }),
                    Observable.from(release.interestingMoments).filter((m) -> m.type.equals("Middle")),
                    (b, i) -> new Quadruple<Integer, String, Integer, String>(release.id, release.title, i.time, b.url)
                    ))
        );
    }

    public Observable<MovieListV5<ReleaseV5>> exercise25() {
        return listsV5.map((list) -> new MovieListV5<>(
                list.name,
                videosV5
                    .filter((video) -> video.listId == list.id)
                    .map((video) -> new ReleaseV5(video.id, video.title))
        ));
    }

    public Observable<MovieListV5<Quadruple<Integer, String, Integer, String>>> exercise26() {
        return listsV5.map((list) ->
            new MovieListV5<>(
                list.name,
                videosV5.filter((video) -> video.listId == list.id).flatMap((video) ->
                    Observable.zip(
                        bookmarksV5.filter((bookmark) -> bookmark.videoId == video.id),
                        boxartsV5.filter(
                            (boxart) -> boxart.videoId == video.id)
                            .reduce((acc, cur) -> {
                                if (acc.width * acc.height < cur.width * cur.height) {
                                    return acc;
                                } else {
                                    return cur;
                                }
                            }),
                        (bm, bx) -> new Quadruple<>(video.id, video.title, bm.time, bx.url)
                    )
            ))
        );
    }

    @Override
    public Observable<StockV6> exercise28() {
        final Date tenDaysAgo = StockMarketV6.getNumDaysAgo(10);
        return StockMarketV6.getRandomNASDAQ(25)
                .filter((stock) -> stock.name.equals("MSFT") && stock.timestamp.compareTo(tenDaysAgo) > 0);
    }
}
