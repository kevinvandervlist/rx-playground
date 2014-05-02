package nl.sogyo.learnrx;

import nl.sogyo.learnrx.containers.Pair;
import nl.sogyo.learnrx.containers.Quadruple;
import nl.sogyo.learnrx.containers.Triple;
import nl.sogyo.learnrx.data.V1.LibraryV1;
import nl.sogyo.learnrx.data.V1.ReleaseV1;
import nl.sogyo.learnrx.data.V5.MovieListV5;
import nl.sogyo.learnrx.data.V5.ReleaseV5;
import org.junit.Test;
import rx.Observable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public abstract class Verify {

    public abstract Excercises getExcercise();

    @Test
    public void excercise5() {
        List<Pair<Integer, String>> expected = new ArrayList<>();

        for(ReleaseV1 release : LibraryV1.getReleases()) {
            expected.add(new Pair<>(release.id, release.title));
        }

        Observable<Pair<Integer, String>> resultObservable = getExcercise().excercise5();
        resultObservable.toList().subscribe((result) -> assertEquals(expected, result));
    }

    @Test
    public void excercise8() {
        List<Integer> expected = new ArrayList<>();
        expected.add(654356453);
        expected.add(675465);
        getExcercise().excercise8().toList().subscribe((actual) -> assertEquals(expected, actual));
    }

    @Test
    public void excercise11() {
        List<Integer> expected = new ArrayList<>();
        expected.add(654356453);
        expected.add(70111470);
        expected.add(65432445);
        expected.add(675465);
        getExcercise().excercise11().toList().subscribe((actual) -> assertEquals(expected, actual));
    }

    @Test
    public void excercise14() {
        List<Triple<Integer, String, String>> expected = new ArrayList<>();
        expected.add(new Triple<>(654356453, "Bad Boys", "http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg"));
        expected.add(new Triple<>(70111470, "Die Hard", "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"));
        expected.add(new Triple<>(65432445, "The Chamber", "http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg"));
        expected.add(new Triple<>(675465, "The Fracture", "http://cdn-0.nflximg.com/images/2891/Fracture150.jpg"));
        getExcercise().excercise14().toList().subscribe((actual) -> assertEquals(expected, actual));
    }

    @Test
    public void excercise17() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        getExcercise().excercise17().toList().subscribe((actual) -> assertEquals(expected, actual));
    }

    @Test
    public void excercise18() {
        List<String> expected = new ArrayList<>();
        expected.add("http://cdn-0.nflximg.com/images/2891/Fracture425.jpg");
        getExcercise().excercise18().toList().subscribe((actual) -> assertEquals(expected, actual));
    }

    @Test
    public void excercise19() {
        Map<Integer, String> expected = new HashMap<>();
        expected.put(654356453, "Bad Boys");
        expected.put(70111470, "Die Hard");
        expected.put(675465, "Fracture");
        expected.put(65432445, "The Chamber");
        getExcercise().excercise19().subscribe((actual) -> assertEquals(expected, actual));
    }

    @Test
    public void excercise20() {
        List<Triple<Integer, String, String>> expected = new ArrayList<>();
        expected.add(new Triple<>(654356453, "Bad Boys", "http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg"));
        expected.add(new Triple<>(70111470, "Die Hard", "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"));
        expected.add(new Triple<>(65432445, "The Chamber", "http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg"));
        expected.add(new Triple<>(675465, "The Fracture", "http://cdn-0.nflximg.com/images/2891/Fracture150.jpg"));
        getExcercise().excercise20().toList().subscribe((actual) -> assertEquals(expected, actual));
    }

    @Test
    public void excercise23() {
        List<Pair<Integer, Integer>> expected = new ArrayList<>();
        expected.add(new Pair<>(70111470, 470));
        expected.add(new Pair<>(654356453, 453));
        expected.add(new Pair<>(65432445, 445));
        getExcercise().excercise23().toList().subscribe((actual) -> assertEquals(expected, actual));
    }

    @Test
    public void excercise24() {
        List<Quadruple<Integer, String, Integer, String>> expected = new ArrayList<>();
        expected.add(new Quadruple<>(654356453, "Bad Boys", 6575665, "http://cdn-0.nflximg.com/images/2891/BadBoys150.jpg"));
        expected.add(new Quadruple<>(70111470, "Die Hard", 323133, "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"));
        expected.add(new Quadruple<>(65432445, "The Chamber", 3452343, "http://cdn-0.nflximg.com/images/2891/TheChamber150.jpg"));
        expected.add(new Quadruple<>(675465, "The Fracture", 3453434, "http://cdn-0.nflximg.com/images/2891/Fracture150.jpg"));
        getExcercise().excercise24().toList().subscribe((actual) -> assertEquals(expected, actual));
    }

    @Test
    public void excercise25() {
        List<MovieListV5<ReleaseV5>> result = getExcercise().excercise25().toList().toBlockingObservable().single();
        assertEquals(2, result.size());

        MovieListV5<ReleaseV5> first = result.get(0);
        MovieListV5<ReleaseV5> last = result.get(1);

        assertEquals("New Releases", first.name);
        assertEquals("Thrillers", last.name);

        List<ReleaseV5> expectedFirst = new ArrayList<>(2);
        expectedFirst.add(new ReleaseV5(65432445, "The Chamber"));
        expectedFirst.add(new ReleaseV5(675465, "Fracture"));

        List<ReleaseV5> expectedLast = new ArrayList<>(2);
        expectedLast.add(new ReleaseV5(70111470, "Die Hard"));
        expectedLast.add(new ReleaseV5(654356453, "Bad Boys"));

        first.releases.subscribe((actual) -> assertEquals(expectedFirst, actual));
        last.releases.subscribe((actual) -> assertEquals(expectedLast, actual));
    }

    @Test
    public void excercise26() {
        List<MovieListV5<Quadruple<Integer, String, Integer, String>>> result =
                getExcercise().excercise26().toList().toBlockingObservable().single();

        assertEquals(2, result.size());

        MovieListV5<Quadruple<Integer, String, Integer, String>> first = result.get(0);
        MovieListV5<Quadruple<Integer, String, Integer, String>> last = result.get(1);

        assertEquals("New Releases", first.name);
        assertEquals("Thrillers", last.name);

        List<Quadruple<Integer, String, Integer, String>> expectedFirst = new ArrayList<>(2);
        expectedFirst.add(new Quadruple<>(65432445, "The Chamber", 32432, "http://cdn-0.nflximg.com/images/2891/TheChamber130.jpg"));
        expectedFirst.add(new Quadruple<>(675465, "Fracture", 3534543, "http://cdn-0.nflximg.com/images/2891/Fracture120.jpg"));

        List<Quadruple<Integer, String, Integer, String>> expectedLast = new ArrayList<>(2);
        expectedLast.add(new Quadruple<>(70111470, "Die Hard", 645243, "http://cdn-0.nflximg.com/images/2891/DieHard150.jpg"));
        expectedLast.add(new Quadruple<>(654356453, "Bad Boys", 984934, "http://cdn-0.nflximg.com/images/2891/BadBoys140.jpg"));

        first.releases.subscribe((actual) -> assertEquals(expectedFirst, actual));
        last.releases.subscribe((actual) -> assertEquals(expectedLast, actual));
    }
}
