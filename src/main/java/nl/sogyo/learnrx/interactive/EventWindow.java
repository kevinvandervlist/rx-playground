package nl.sogyo.learnrx.interactive;

import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class EventWindow extends JFrame {
    public EventWindow() {
        this.setTitle("Event window");
        this.setSize(new Dimension(640, 480));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public rx.Observable<MouseEvent> getMouseMotionObservable() {
        final EventWindow ew = this;

        return Observable.create((Subscriber<? super MouseEvent> subscriber) -> {
            MouseMotionListener mml = new MouseMotionListener() {
                @Override
                public void mouseDragged(final MouseEvent e) {
                    subscriber.onNext(e);
                }

                @Override
                public void mouseMoved(final MouseEvent e) {
                    subscriber.onNext(e);
                }
            };
            ew.addMouseMotionListener(mml);
            subscriber.add(Subscriptions.create(() -> ew.removeMouseMotionListener(mml)));
        });
    }

    public rx.Observable<MouseEvent> getMouseMotionObservableWithoutLambda() {
        final EventWindow ew = this;

        return Observable.create(new Observable.OnSubscribe<MouseEvent>() {
            @Override
            public void call(final Subscriber<? super MouseEvent> subscriber) {
                MouseMotionListener mml = new MouseMotionListener() {
                    @Override
                    public void mouseDragged(final MouseEvent e) {
                        subscriber.onNext(e);
                    }

                    @Override
                    public void mouseMoved(final MouseEvent e) {
                        subscriber.onNext(e);
                    }
                };
                ew.addMouseMotionListener(mml);
                subscriber.add(Subscriptions.create(() -> ew.removeMouseMotionListener(mml)));
            }
        });
    }
}
