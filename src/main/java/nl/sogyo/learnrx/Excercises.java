package nl.sogyo.learnrx;

import nl.sogyo.learnrx.data.Library;
import nl.sogyo.learnrx.data.Release;
import nl.sogyo.learnrx.data.TwoTuple;
import rx.Observable;

import java.util.List;

/**
 * Excercises from http://reactive-extensions.github.io/learnrx/ in RXJava
 */

public class Excercises {
    List<Release> releases = Library.getReleases(4);

    public Observable<TwoTuple<Integer, String>> Excercise4() {
        return Observable.from(releases).map((x) -> new TwoTuple<>(x.id, x.title));
    }
}
