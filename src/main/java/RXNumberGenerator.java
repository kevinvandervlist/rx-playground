import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RXNumberGenerator {

    public static void main(String[] args) {
        System.out.println("RXNumberGenerator main.");

        Observable<Integer> stream;
        stream = RXNumberGenerator.autoUpdateObservable(TimeUnit.SECONDS, 2, RXNumberGenerator.randomNumberStream(10));

        //stream.map((x) -> x).subscribe((x) -> System.out.println(x));

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static <T> Observable<T> autoUpdateObservable(TimeUnit unit, long delay, Observable<T> src) {
        return Observable.timer(delay, unit).flatMap((x) -> src);
    }

    public static Observable<Integer> randomNumberStream(int upperbound) {
        return Observable.create(new OnSubscribe<Integer>() {
            Random random = new Random();
            @Override
            public void call(final Subscriber<? super Integer> subscriber) {
                while(true) {
                    subscriber.onNext(random.nextInt(upperbound));
                }
            }
        });
    }
}
