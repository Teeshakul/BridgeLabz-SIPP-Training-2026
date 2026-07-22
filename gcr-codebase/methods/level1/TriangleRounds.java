import java.util.Scanner;

public class TriangleRounds {

    static double findRounds(double a, double b, double c) {

        double perimeter = a + b + c;
        return 5000 / perimeter;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter three sides: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        System.out.printf("Rounds Required = %.2f", findRounds(a, b, c));
    }
}