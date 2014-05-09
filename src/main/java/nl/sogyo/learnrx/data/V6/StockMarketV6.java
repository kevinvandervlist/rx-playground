package nl.sogyo.learnrx.data.V6;

import rx.Observable;
import rx.Subscriber;

import java.util.*;

public class StockMarketV6 {

    public static Date getNumDaysAgo(int days) {
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_MONTH, -days);
        return c.getTime();
    }

    public static Observable<StockV6> getRandomNASDAQ(long sleepInMillis) {
        return Observable.create(new Observable.OnSubscribe<StockV6>() {
            List<String> stocks = Arrays.asList("MSFT", "GOOG", "NFLX", "OSTK");
            Random random = new Random();
            @Override
            public void call(final Subscriber<? super StockV6> subscriber) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true) {
                            if(subscriber.isUnsubscribed()) {
                                return;
                            }

                            int index = random.nextInt(stocks.size());
                            String randomStockName = stocks.get(index);
                            double value = random.nextDouble() + 30;

                            subscriber.onNext(new StockV6(randomStockName, value, new Date()));

                            try {
                                Thread.sleep(sleepInMillis);
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
}
