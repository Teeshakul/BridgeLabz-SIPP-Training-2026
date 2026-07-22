import java.util.*;

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String msg) {
        super(msg);
    }
}

public class HospitalBillingSystem {

    static void payBill(double balance, double bill)
            throws InsufficientFundsException {

        if (bill > balance)
            throw new InsufficientFundsException("Payment Failed: Insufficient Funds");

        System.out.println("Payment Successful");
    }

    public static void main(String[] args) {

        try {
            int totalBill = 1000;
            int items = 0;
            System.out.println(totalBill / items);

        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero items");
        }

        try {
            int[] patients = {101,102,103};
            System.out.println(patients[5]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid patient index");
        }

        try {
            int amount = Integer.parseInt("abc");

        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input");
        }

        try {
            payBill(5000,7000);

        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }
}