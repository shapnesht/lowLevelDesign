package observerPattern.observer;

import observerPattern.observable.StockObservable;

public class MobileNotificationAlertObserver implements NotificationAlertObserver{
    String userName;
    String phoneNumber;
    StockObservable observable;

    public MobileNotificationAlertObserver(String userName, String phoneNumber, StockObservable observable) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendSMS(userName, phoneNumber);
    }

    private void sendSMS(String userName, String phoneNumber) {
        System.out.println("The item is back in Stock");
    }
}
