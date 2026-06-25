interface CouponValidator {

    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code.length() >= 5;
    }
}

class ShoppingCart implements CouponValidator {

    public boolean validateCoupon(String code) {
        return code.startsWith("SAVE") && CouponValidator.isLengthValid(code);
    }
}

public class ShoppingCartDemo {
    public static void main(String[] args) {

        String[] coupons = {"SAVE10", "ABC", "SAVE50", "HELLO"};

        ShoppingCart cart = new ShoppingCart();

        for (String c : coupons) {
            if (cart.validateCoupon(c))
                System.out.println(c + " Valid");
            else
                System.out.println(c + " Invalid");
        }
    }
}