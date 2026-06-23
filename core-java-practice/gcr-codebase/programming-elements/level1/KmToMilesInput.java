import java.util.Scanner;

public class KmToMilesInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double km = sc.nextDouble();

        System.out.println("Miles = " + (km / 1.6));
    }
}