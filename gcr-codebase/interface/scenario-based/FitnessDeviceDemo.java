interface Trackable {
    void logActivity();

    default void resetData() {
        System.out.println("Activity data reset.");
    }
}

interface Reportable {
    void generateReport();
}

interface Notifiable {
    void sendAlert();
}

class FitnessDevice implements Trackable, Reportable, Notifiable {

    public void logActivity() {
        System.out.println("Activity Logged");
    }

    public void generateReport() {
        System.out.println("Fitness Report Generated");
    }

    public void sendAlert() {
        System.out.println("Workout Reminder Sent");
    }
}

public class FitnessDeviceDemo {
    public static void main(String[] args) {

        FitnessDevice fd = new FitnessDevice();

        fd.logActivity();
        fd.generateReport();
        fd.sendAlert();
        fd.resetData();
    }
}