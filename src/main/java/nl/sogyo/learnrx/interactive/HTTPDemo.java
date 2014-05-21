package nl.sogyo.learnrx.interactive;

import nl.sogyo.learnrx.data.schiphol.Departure;
import nl.sogyo.learnrx.data.schiphol.DepartureState;
import nl.sogyo.learnrx.data.schiphol.DeparturesFactory;
import rx.Observable;

import java.util.Date;

public class HTTPDemo {

    public static void main(String[] args) {
        HTTPDemo demo = new HTTPDemo();
        //demo.start();
        //demo.filterBoardingKLM();
        demo.boardingWindow();
    }

    public void start() {
        Observable<Departure> departures = DeparturesFactory.simpleDepartures();
        departures.map((d) -> new Date() + ": " + d.toString()).subscribe(System.out::println);
    }

    public void filterBoardingKLM() {
        Observable<Departure> departures = DeparturesFactory.simpleDepartures();
        departures
                .filter((d) -> d.status.equalsIgnoreCase("boarding"))
                .filter((d) -> d.carrier.contains("KLM"))
                .subscribe(System.out::println, System.err::println);
    }

    public void boardingWindow() {
        //BoardingWindow bw = new BoardingWindow()
        DeparturesFactory.statusChangedDepartures()
                .filter((de) -> de.state.equals(DepartureState.CHANGED))
                .subscribe(System.out::println);
    }
}
