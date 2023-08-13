package observerPattern.observer;

import observerPattern.observable.StockObservable;

public class EmailNotificationAlertObserver implements NotificationAlertObserver{
    String emailId;
    StockObservable observable;

    public EmailNotificationAlertObserver(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    public void sendEmail() {
        System.out.println("Email sent to" + emailId);
    }

    @Override
    public void update() {
        sendEmail();
    }
}
