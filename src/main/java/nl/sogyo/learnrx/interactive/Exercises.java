package nl.sogyo.learnrx.interactive;

import rx.Observable;

import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

public class Exercises {
    public static void main(String[] args) {
        Exercises e = new Exercises();
        //e.hugeNumberOfMouseEvents();
        e.throttledMouseEvents();
    }

    public void hugeNumberOfMouseEvents() {
        EventWindow ew = new EventWindow();
        Observable<MouseEvent> motienEvents = ew.getMouseMotionObservable();
        motienEvents
                .map(MouseEvent::getPoint)
                .subscribe(System.out::println);
    }

    public void throttledMouseEvents() {
        EventWindow ew = new EventWindow();
        Observable<MouseEvent> motienEvents = ew.getMouseMotionObservable();
        motienEvents
                .map(MouseEvent::getPoint)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);
    }
}
