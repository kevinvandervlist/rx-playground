package nl.sogyo.learnrx.data.V5;

import rx.Observable;

public class MovieListV5<T> {

    public final String name;
    public final Observable<T> releases;

    public MovieListV5(String name, Observable<T> releases) {
        this.name = name;
        this.releases = releases;
    }
}
