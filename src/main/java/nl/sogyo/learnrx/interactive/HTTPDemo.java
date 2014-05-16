package nl.sogyo.learnrx.interactive;

import nl.sogyo.learnrx.data.schiphol.Departure;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import rx.Observable;
import rx.Subscriber;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HTTPDemo {

    private String schipholURL = "http://www.schiphol.nl/nosj2va/departures_today_passenger.txt?_=";

    public static void main(String[] args) {
        HTTPDemo demo = new HTTPDemo();
        demo.start();
    }

    public void start() {
        Observable<Departure> departures = retrieveDepartures();
        departures.map((d) -> new Date() + ": " + d.toString()).subscribe(System.out::println);
    }

    /**
     * The observable returned here will retrieve flight information from Schiphol.
     * New flights will be published on the stream, old ones will be ignored. The returning
     * observable can be used like any other, without having any knowledge on the fact that this just
     * calls a remote webservice and is asynchronous. These details are all hidden behind the observable interface.
     */
    private Observable<Departure> retrieveDepartures() {
        return Observable.create(new Observable.OnSubscribe<Departure>() {
            private Set<Departure> cache = new HashSet<>();
            private long second = 1000;
            @Override
            public void call(final Subscriber<? super Departure> subscriber) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true) {
                            if(subscriber.isUnsubscribed()) {
                                return;
                            }

                            Set<Departure> departures = null;
                            try {
                                departures = retrieveDeparturesFromSchiphol(schipholURL);
                            } catch(Exception e) {
                                subscriber.onError(e);
                            }

                            // Remove items from the cache that don't exist in the new result
                            Set<Departure> removal = new HashSet<>();
                            for(Departure d : cache) {
                                if(! departures.contains(d)) {
                                    removal.add(d);
                                }
                            }
                            cache.removeAll(removal);

                            // Add new items to the cache and emit them.
                            for(Departure d : departures) {
                                if(! cache.contains(d)) {
                                    cache.add(d);
                                    subscriber.onNext(d);
                                }
                            }

                            // Sleep for a minute and try again.
                            try {
                                Thread.sleep(second * 60);
                            } catch(InterruptedException e) {
                                subscriber.onError(e);
                            }
                        }
                    }
                });
                t.start();
            }
        });
    }

    private static Set<Departure> retrieveDeparturesFromSchiphol(String baseURL) throws Exception {
        Set<Departure> departures = new HashSet<>();

        String actualURL = baseURL + new Date().getTime() / 1000;
        URLConnection request = new URL(actualURL).openConnection();

        InputStream in = request.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);

        JSONParser jsonparser = new JSONParser();
        JSONObject result = (JSONObject) jsonparser.parse(reader);

        JSONObject data = (JSONObject) result.get("data");
        JSONArray flights = (JSONArray) data.get("flights");

        for(Object flight : flights) {
            JSONObject f = (JSONObject) flight;
            Departure d = flightToDeparture(f);
            departures.add(d);
        }

        return departures;
    }

    private static Departure flightToDeparture(JSONObject flight) {
        String flightNumber = (String) flight.get("pFlightnumber");
        String flightPrefix = (String) flight.get("prefix");
        String flightSuffix = (String) flight.get("suffix");
        String destinationAirport = (String) flight.get("airport");
        String scheduled = (String) flight.get("scheduled");
        String status = (String) flight.get("status");
        int hall = Integer.parseInt((String) flight.get("hall"));
        String carrier = (String) flight.get("carrier");
        return new Departure(flightNumber, flightPrefix, flightSuffix, destinationAirport,
                scheduled, status, hall, carrier);
    }
}
