abstract class Vehicle {

    private String vehicleNumber;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    abstract double calculateRentalCost(int days);

    public void displayVehicleInfo() {

        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type   : " + vehicleType);
    }
}

class Car extends Vehicle {

    private double dailyRate;

    public Car(String number, double dailyRate) {

        super(number, "Car");
        this.dailyRate = dailyRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Bike extends Vehicle {

    private double dailyRate;

    public Bike(String number, double dailyRate) {

        super(number, "Bike");
        this.dailyRate = dailyRate;
    }

    @Override
    double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

class Truck extends Vehicle {

    private double dailyRate;
    private double loadingCharge;

    public Truck(String number,
                 double dailyRate,
                 double loadingCharge) {

        super(number, "Truck");

        this.dailyRate = dailyRate;
        this.loadingCharge = loadingCharge;
    }

    @Override
    double calculateRentalCost(int days) {

        return (days * dailyRate) + loadingCharge;
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {

        Vehicle[] vehicles = {

                new Car("CAR101", 1200),
                new Bike("BIKE201", 500),
                new Truck("TRUCK301", 2500, 1000)
        };

        int days = 5;

        for (Vehicle vehicle : vehicles) {

            vehicle.displayVehicleInfo();

            System.out.println("Rental Cost : ₹" +
                    vehicle.calculateRentalCost(days));

            System.out.println();
        }
    }
}