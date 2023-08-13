package observerPattern.observable;

import observerPattern.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservable implements StockObservable{
    public List<NotificationAlertObserver> subscribers = new ArrayList<>();
    public int stockCount = 0;
    @Override
    public void addObserver(NotificationAlertObserver notificationAlertObserver) {
        subscribers.add(notificationAlertObserver);
    }

    @Override
    public void removeObserver(NotificationAlertObserver notificationAlertObserver) {
        subscribers.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer: subscribers) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int quantity) {
        if(stockCount == 0) notifySubscribers();
        this.stockCount += quantity;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
