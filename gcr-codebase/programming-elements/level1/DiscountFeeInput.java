import java.util.Scanner;

public class DiscountFeeInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double fee = sc.nextDouble();
        double discount = sc.nextDouble();

        System.out.println("Discount Amount = " + (fee * discount / 100));
        System.out.println("Final Fee = " + (fee - fee * discount / 100));
    }
}