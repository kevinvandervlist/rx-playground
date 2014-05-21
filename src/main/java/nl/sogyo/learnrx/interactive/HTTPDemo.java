package nl.sogyo.learnrx.interactive;

import nl.sogyo.learnrx.data.schiphol.Departure;
import nl.sogyo.learnrx.data.schiphol.DepartureState;
import nl.sogyo.learnrx.data.schiphol.DeparturesFactory;
import rx.Observable;

import java.util.Date;

public class HTTPDemo {

    public static void main(String[] args) {
        HTTPDemo demo = new HTTPDemo();
        demo.start();
        demo.filterBoardingKLM();
        demo.KLMBoardingInformation();
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

    public void KLMBoardingInformation() {
        DeparturesFactory.statusChangedDepartures()
                .filter((de) -> de.state.equals(DepartureState.CHANGED) || de.state.equals(DepartureState.NEW))
                .map((de) -> de.departure)
                .filter((d) -> d.carrier.contains("KLM"))
                .filter((d) -> d.status.equalsIgnoreCase("Boarding"))
                .subscribe(System.out::println);
    }
}
