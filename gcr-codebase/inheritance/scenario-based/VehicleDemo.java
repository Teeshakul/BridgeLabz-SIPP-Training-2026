class Vehicle{

    int maxSpeed;
    String model;

    Vehicle(String model,int maxSpeed){
        this.model=model;
        this.maxSpeed=maxSpeed;
    }
}

interface Refuelable{
    void refuel();
}

class ElectricVehicle extends Vehicle{

    ElectricVehicle(String model,int maxSpeed){
        super(model,maxSpeed);
    }

    void charge(){
        System.out.println("Charging...");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable{

    PetrolVehicle(String model,int maxSpeed){
        super(model,maxSpeed);
    }

    public void refuel(){
        System.out.println("Refueling...");
    }
}

public class VehicleDemo{

    public static void main(String[] args){

        ElectricVehicle ev=new ElectricVehicle("Tesla",250);
        ev.charge();

        PetrolVehicle pv=new PetrolVehicle("Honda",180);
        pv.refuel();
    }
}