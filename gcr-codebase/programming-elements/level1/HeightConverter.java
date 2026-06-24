import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double cm = sc.nextDouble();

        System.out.println("Feet = " + (cm / 30.48));
        System.out.println("Inches = " + (cm / 2.54));
    }
}