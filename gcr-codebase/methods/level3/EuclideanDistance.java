import java.util.Scanner;

public class EuclideanDistance {

    static double distance(double x1, double y1, double x2, double y2) {

        return Math.sqrt(Math.pow(x2 - x1, 2) +
                Math.pow(y2 - y1, 2));
    }

    static double[] lineEquation(double x1, double y1,
                                 double x2, double y2) {

        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;

        return new double[]{m, b};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1 y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Enter x2 y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.println("Distance = " + distance(x1, y1, x2, y2));

        double[] ans = lineEquation(x1, y1, x2, y2);

        System.out.println("Slope = " + ans[0]);
        System.out.println("Intercept = " + ans[1]);

        System.out.println("Equation: y = " + ans[0] + "x + " + ans[1]);
    }
}