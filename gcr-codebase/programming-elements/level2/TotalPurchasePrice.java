import java.util.Scanner;

public class TotalPurchasePrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double price = sc.nextDouble();
        int quantity = sc.nextInt();

        System.out.println("Total Price = " + (price * quantity));
    }
}