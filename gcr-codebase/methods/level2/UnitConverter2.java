import java.util.Scanner;

public class UnitConverter2 {

    static double convertYardsToFeet(double yards) {
        return yards * 3;
    }

    static double convertFeetToYards(double feet) {
        return feet * 0.333333;
    }

    static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }

    static double convertInchesToMeters(double inches) {
        return inches * 0.0254;
    }

    static double convertInchesToCm(double inches) {
        return inches * 2.54;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Yards: ");
        double yards = sc.nextDouble();

        System.out.print("Enter Feet: ");
        double feet = sc.nextDouble();

        System.out.print("Enter Meters: ");
        double meters = sc.nextDouble();

        System.out.print("Enter Inches: ");
        double inches = sc.nextDouble();

        System.out.println("Yards to Feet = " + convertYardsToFeet(yards));
        System.out.println("Feet to Yards = " + convertFeetToYards(feet));
        System.out.println("Meters to Inches = " + convertMetersToInches(meters));
        System.out.println("Inches to Meters = " + convertInchesToMeters(inches));
        System.out.println("Inches to CM = " + convertInchesToCm(inches));
    }
}