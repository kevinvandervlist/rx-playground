package nl.sogyo.learnrx;

import nl.sogyo.learnrx.data.Library;
import nl.sogyo.learnrx.data.Release;
import nl.sogyo.learnrx.data.TwoTuple;
import org.junit.Test;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;

public class VerifyExcercises {

    private Excercises excercises = new Excercises();

    @Test
    public void excercise4() {
        List<TwoTuple<Integer, String>> expected = new ArrayList<>();
        for(Release release : Library.getReleases(4)) {
            expected.add(new TwoTuple<>(release.id, release.title));
        }

        Observable<TwoTuple<Integer, String>> result = excercises.Excercise4();
        result.all(expected::contains);
    }
}
