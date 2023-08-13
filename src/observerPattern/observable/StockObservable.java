package observerPattern.observable;

import observerPattern.observer.NotificationAlertObserver;

public interface StockObservable {
    public void addObserver(NotificationAlertObserver notificationAlertObserver);
    public void removeObserver(NotificationAlertObserver notificationAlertObserver);
    public void notifySubscribers();
    public void setStockCount(int quantity);
    public int getStockCount();
}
