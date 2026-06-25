interface FoodDelivery {

    void deliverFood();

    default void trackOrder() {
        System.out.println("Food Order Tracking...");
    }

    static String generateDeliveryCode() {
        return "FD101";
    }
}

interface GroceryDelivery {

    void deliverGroceries();

    default void trackOrder() {
        System.out.println("Grocery Order Tracking...");
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {

    public void deliverFood() {
        System.out.println("Food Delivered");
    }

    public void deliverGroceries() {
        System.out.println("Groceries Delivered");
    }

    @Override
    public void trackOrder() {
        System.out.println("Tracking Delivery...");
    }
}

public class DeliveryExecutiveDemo {
    public static void main(String[] args) {

        String[] customers = {"Rahul", "Priya", "Aman"};

        DeliveryExecutive d = new DeliveryExecutive();

        System.out.println("Delivery Code: " +
                FoodDelivery.generateDeliveryCode());

        for (String customer : customers) {
            System.out.println("\nCustomer: " + customer);
            d.trackOrder();
            d.deliverFood();
            d.deliverGroceries();
        }
    }
}