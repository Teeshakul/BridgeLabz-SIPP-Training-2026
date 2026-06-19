import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double perimeter = sc.nextDouble();

        System.out.println("Side = " + (perimeter / 4));
    }
}