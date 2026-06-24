import java.util.Scanner;

public class TotalPurchasePrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double price = sc.nextDouble();
        int qty = sc.nextInt();

        System.out.println("Total Price = " + (price * qty));
    }
}