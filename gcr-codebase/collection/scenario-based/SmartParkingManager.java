import java.util.*;

public class SmartParkingManager {
    public static void main(String[] args) {

        ArrayList<String> vehicles = new ArrayList<>();

        vehicles.add("UP80AB1234");
        vehicles.add("DL10CD5678");
        vehicles.add("HR26EF1111");

        vehicles.remove("DL10CD5678");

        String search = "HR26EF1111";

        if (vehicles.contains(search))
            System.out.println(search + " Parked");
        else
            System.out.println("Not Found");

        System.out.println("\nParked Vehicles:");

        for (String v : vehicles)
            System.out.println(v);

        System.out.println("Occupied Slots = " + vehicles.size());
    }
}