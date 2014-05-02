package nl.sogyo.learnrx;

import nl.sogyo.learnrx.containers.Quadruple;
import nl.sogyo.learnrx.containers.Triple;
import nl.sogyo.learnrx.containers.Pair;
import nl.sogyo.learnrx.data.V5.MovieListV5;
import nl.sogyo.learnrx.data.V5.ReleaseV5;
import rx.Observable;

import java.util.HashMap;
import java.util.Map;

public class Solutions extends Excercises {

    public Observable<Pair<Integer, String>> excercise5() {
        return releasesV1.map((x) -> new Pair<>(x.id, x.title));
    }

    public Observable<Integer> excercise8() {
        return releasesV1
            .filter((x) -> x.rating == 5.0)
            .map((x) -> x.id);
    }

    public Observable<Integer> excercise11() {
        return movielistsV1.flatMap((x) -> Observable.from(x.releases).map((y) -> y.id));
    }

    public Observable<Triple<Integer, String, String>> excercise14() {
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

    public Observable<Integer> excercise17() {
        return ratings.reduce((accumulator, current) -> Integer.max(accumulator, current));
    }

    public Observable<String> excercise18() {
        return boxarts.reduce((accumulator, current) -> {
            if(accumulator.height * accumulator.width > current.width * current.height) {
                return accumulator;
            } else {
                return current;
            }
        }).map((boxart) -> boxart.url);
    }

    public Observable<Map<Integer, String>> excercise19() {
        Map<Integer, String> mymap = new HashMap<>();
        return releasesV3.reduce(mymap, (accumulator, current) -> {
            accumulator.put(current.id, current.title);
            return accumulator;
        });
    }

    public Observable<Triple<Integer, String, String>> excercise20() {
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

    public Observable<Pair<Integer, Integer>> excercise23() {
        return releasesV1.zip(bookmarks, (r, b) -> new Pair<>(r.id, b.id));
    }

    public Observable<Quadruple<Integer, String, Integer, String>> excercise24() {
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

    public Observable<MovieListV5<ReleaseV5>> excercise25() {
        return listsV5.map((list) -> {
            return new MovieListV5<ReleaseV5>(list.name, videosV5.filter((video) -> {
                return video.listId == list.id;
            }).map((video) -> {
                return new ReleaseV5(video.id, video.title);
            }));
        });
    }

    public Observable<MovieListV5<Quadruple<Integer, String, Integer, String>>> excercise26() {
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
}
