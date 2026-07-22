import java.util.Scanner;

public class UnitConverter3 {

    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    static double poundsToKg(double pounds) {
        return pounds * 0.453592;
    }

    static double kgToPounds(double kg) {
        return kg * 2.20462;
    }

    static double gallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    static double litersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Fahrenheit: ");
        double f = sc.nextDouble();

        System.out.print("Enter Celsius: ");
        double c = sc.nextDouble();

        System.out.print("Enter Pounds: ");
        double pounds = sc.nextDouble();

        System.out.print("Enter Kilograms: ");
        double kg = sc.nextDouble();

        System.out.print("Enter Gallons: ");
        double gallons = sc.nextDouble();

        System.out.print("Enter Liters: ");
        double liters = sc.nextDouble();

        System.out.println("Fahrenheit to Celsius = " + fahrenheitToCelsius(f));
        System.out.println("Celsius to Fahrenheit = " + celsiusToFahrenheit(c));
        System.out.println("Pounds to KG = " + poundsToKg(pounds));
        System.out.println("KG to Pounds = " + kgToPounds(kg));
        System.out.println("Gallons to Liters = " + gallonsToLiters(gallons));
        System.out.println("Liters to Gallons = " + litersToGallons(liters));
    }
}