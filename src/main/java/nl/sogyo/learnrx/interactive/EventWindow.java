package nl.sogyo.learnrx.interactive;

import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class EventWindow extends JFrame {

    private final JPanel background;
    private final JPanel square;

    public EventWindow(String title, int width, int height) {
        this.setTitle(title);

        background = new JPanel();
        background.setBackground(Color.black);
        this.add(background);

        square = new JPanel();
        square.setBackground(Color.green);

        Insets insets = this.getInsets();
        square.setBounds(insets.left + 20, insets.top, width / 6, height / 6);
        background.add(square);

        this.setSize(new Dimension(width, height));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public Observable<MouseEvent> getGreenSquareMouseEvents() {
        return getMouseMotionEvents(square);
    }

    public Observable<MouseEvent> getMouseMotionObservable() {
        return getMouseMotionEvents(this);
    }

    private Observable<MouseEvent> getMouseMotionEvents(final Component component) {
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
            component.addMouseMotionListener(mml);
            subscriber.add(Subscriptions.create(() -> component.removeMouseMotionListener(mml)));
        });
    }

    public Observable<MouseEvent> getMouseMotionObservableWithoutLambda() {
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
