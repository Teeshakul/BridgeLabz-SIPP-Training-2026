interface HeartRateMonitor {

    void checkHeartRate();

    default void displayHealthTips() {
        System.out.println("Exercise regularly.");
    }

    static boolean isPatientIdValid(String id) {
        return id.length() == 5;
    }
}

interface TemperatureMonitor {

    void checkTemperature();

    default void displayHealthTips() {
        System.out.println("Drink enough water.");
    }
}

class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {

    public void checkHeartRate() {
        System.out.println("Heart Rate: 72 BPM");
    }

    public void checkTemperature() {
        System.out.println("Temperature: 98.6 F");
    }

    @Override
    public void displayHealthTips() {
        System.out.println("Eat Healthy and Stay Active.");
    }
}

public class HealthMonitoringSystemDemo {
    public static void main(String[] args) {

        String[] names = {"Riya", "Amit", "Neha"};
        String[] ids = {"P1001", "12", "P1003"};

        HealthMonitoringSystem h = new HealthMonitoringSystem();

        h.displayHealthTips();

        for (int i = 0; i < names.length; i++) {

            System.out.println("\nPatient: " + names[i]);

            if (HeartRateMonitor.isPatientIdValid(ids[i])) {
                h.checkHeartRate();
                h.checkTemperature();
                System.out.println("Health Report Generated");
            } else {
                System.out.println("Invalid Patient ID");
            }
        }
    }
}