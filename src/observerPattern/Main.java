package observerPattern;

import observerPattern.observable.IphoneStockObservable;
import observerPattern.observable.StockObservable;
import observerPattern.observer.EmailNotificationAlertObserver;
import observerPattern.observer.MobileNotificationAlertObserver;
import observerPattern.observer.NotificationAlertObserver;

public class Main {
    public static void main(String[] args) {
        StockObservable iphoneStock = new IphoneStockObservable();

        NotificationAlertObserver emailNotifier1 = new EmailNotificationAlertObserver("1@gmail.com", iphoneStock);
        NotificationAlertObserver emailNotifier2 = new EmailNotificationAlertObserver("2@gmail.com", iphoneStock);
        NotificationAlertObserver mobileNotifier1 = new MobileNotificationAlertObserver("1", "9685", iphoneStock);

        iphoneStock.addObserver(emailNotifier1);
        iphoneStock.addObserver(emailNotifier2);
        iphoneStock.addObserver(mobileNotifier1);

        iphoneStock.setStockCount(5);
    }
}