class Notification {

    String recipientName;
    String message;

    Notification(String recipientName, String message) {

        this.recipientName = recipientName;
        this.message = message;
    }

    void sendNotification() {

        System.out.println("Sending Notification...");
    }
}

class EmailNotification extends Notification {

    EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {

        System.out.println("Email sent to " + recipientName +
                " : " + message);
    }
}

class SMSNotification extends Notification {

    SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {

        System.out.println("SMS sent to " + recipientName +
                " : " + message);
    }
}

class PushNotification extends Notification {

    PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {

        System.out.println("Push Notification sent to " +
                recipientName + " : " + message);
    }
}

public class SmartNotificationSystem {

    public static void main(String[] args) {

        Notification[] notifications = {

                new EmailNotification("Aman", "Meeting at 10 AM"),
                new SMSNotification("Priya", "OTP: 458963"),
                new PushNotification("Rahul", "New Offer Available")
        };

        System.out.println("Notifications Sent\n");

        for (Notification notification : notifications)
            notification.sendNotification();
    }
}