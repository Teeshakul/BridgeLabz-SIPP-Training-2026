public class DiscountFee {
    public static void main(String[] args) {
        double fee = 125000;
        double discount = fee * 10 / 100;

        System.out.println("Discount = " + discount);
        System.out.println("Final Fee = " + (fee - discount));
    }
}