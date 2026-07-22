class Vehicle {

    String vehicleNumber;

    Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    double fuelCost(double km) {
        return 0;
    }
}

class Car extends Vehicle {

    Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(double km) {
        return km * 8;
    }
}

class Bus extends Vehicle {

    Bus(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(double km) {
        return km * 15;
    }
}

class Bike extends Vehicle {

    Bike(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(double km) {
        return km * 3;
    }
}

class ElectricCar extends Vehicle {

    ElectricCar(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    double fuelCost(double km) {
        return km * 2;
    }
}

public class TransportCompany {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("CAR101"),
                new Bus("BUS201"),
                new Bike("BIKE301"),
                new ElectricCar("EV401")
        };

        double distance = 100;

        for (Vehicle vehicle : vehicles) {

            System.out.println(vehicle.vehicleNumber +
                    " Fuel Cost = " + vehicle.fuelCost(distance));

            if (vehicle instanceof Car)
                System.out.println("Type : Car");

            else if (vehicle instanceof Bus)
                System.out.println("Type : Bus");

            else if (vehicle instanceof Bike)
                System.out.println("Type : Bike");

            else if (vehicle instanceof ElectricCar)
                System.out.println("Type : Electric Car");
        }
    }
}