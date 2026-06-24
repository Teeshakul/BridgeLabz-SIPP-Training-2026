import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println("Quotient = " + (n1 / n2));
        System.out.println("Remainder = " + (n1 % n2));
    }
}