import java.util.*;
import java.util.stream.Collectors;

abstract class Person {
    private int id;
    private String name;
    private String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'';
    }
}

class Customer extends Person {
    private String city;
    private boolean primeMember;

    public Customer(int id, String name, String email,
                    String city, boolean primeMember) {
        super(id, name, email);
        this.city = city;
        this.primeMember = primeMember;
    }

    public String getCity() {
        return city;
    }

    public boolean isPrimeMember() {
        return primeMember;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                ", city='" + city + '\'' +
                ", primeMember=" + primeMember +
                '}';
    }
}

class Seller extends Person {
    private String companyName;
    private double sellerRating;

    public Seller(int id, String name, String email,
                  String companyName, double sellerRating) {
        super(id, name, email);
        this.companyName = companyName;
        this.sellerRating = sellerRating;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getSellerRating() {
        return sellerRating;
    }

    @Override
    public String toString() {
        return "Seller{" +
                super.toString() +
                ", companyName='" + companyName + '\'' +
                ", sellerRating=" + sellerRating +
                '}';
    }
}

class Product {
    private int productId;
    private String productName;
    private String category;
    private double price;
    private double rating;
    private boolean inStock;
    private Seller seller;

    public Product(int productId, String productName,
                   String category, double price,
                   double rating, boolean inStock,
                   Seller seller) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.inStock = inStock;
        this.seller = seller;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public boolean isInStock() {
        return inStock;
    }

    public Seller getSeller() {
        return seller;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", inStock=" + inStock +
                ", seller=" + seller.getName() +
                '}';
    }
}

public class OnlineShoppingSystem {

    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Seller> sellers = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        // 4 Customers
        customers.add(new Customer(
                1, "Teesha", "teesha@gmail.com",
                "Delhi", true));

        customers.add(new Customer(
                2, "Riya", "riya@gmail.com",
                "Mumbai", false));

        customers.add(new Customer(
                3, "Mahak", "mahak@gmail.com",
                "Pune", true));

        customers.add(new Customer(
                4, "Nandu", "nandu@gmail.com",
                "Bangalore", false));

        // 3 Sellers
        Seller seller1 = new Seller(
                101, "Rahul", "rahul@gmail.com",
                "TechStore", 4.8);

        Seller seller2 = new Seller(
                102, "Amit", "amit@gmail.com",
                "FashionHub", 4.3);

        Seller seller3 = new Seller(
                103, "Priya", "priya@gmail.com",
                "HomeWorld", 4.9);

        sellers.add(seller1);
        sellers.add(seller2);
        sellers.add(seller3);

        // 8 Products
        products.add(new Product(
                1001, "Laptop", "Electronics",
                65000, 4.9, true, seller1));

        products.add(new Product(
                1002, "Mobile", "Electronics",
                30000, 4.7, true, seller1));

        products.add(new Product(
                1003, "T-Shirt", "Fashion",
                800, 4.2, false, seller2));

        products.add(new Product(
                1004, "Shoes", "Fashion",
                2500, 4.6, true, seller2));

        products.add(new Product(
                1005, "Chair", "Furniture",
                3500, 4.4, true, seller3));

        products.add(new Product(
                1006, "Table", "Furniture",
                7000, 4.5, false, seller3));

        products.add(new Product(
                1007, "Headphones", "Electronics",
                1500, 4.8, true, seller1));

        products.add(new Product(
                1008, "Lamp", "Home Decor",
                900, 4.1, true, seller3));

        // 1. Display all product names
        System.out.println("\n1. All Product Names");

        products.stream()
                .map(Product::getProductName)
                .forEach(System.out::println);


        // 2. Display products in stock
        System.out.println("\n2. Products In Stock");

        products.stream()
                .filter(Product::isInStock)
                .forEach(System.out::println);


        // 3. Products costing more than 1000
        System.out.println("\n3. Products Costing More Than 1000");

        products.stream()
                .filter(product -> product.getPrice() > 1000)
                .forEach(System.out::println);


        // 4. Prime Customers
        System.out.println("\n4. Prime Customers");

        customers.stream()
                .filter(Customer::isPrimeMember)
                .forEach(System.out::println);


        // 5. Sellers rating above 4.5
        System.out.println("\n5. Sellers Rating Above 4.5");

        sellers.stream()
                .filter(seller -> seller.getSellerRating() > 4.5)
                .forEach(System.out::println);


        // 6. Sort products by price
        System.out.println("\n6. Products Sorted By Price");

        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(System.out::println);


        // 7. Sort sellers by rating descending
        System.out.println("\n7. Sellers Sorted By Rating Descending");

        sellers.stream()
                .sorted(Comparator.comparingDouble(
                        Seller::getSellerRating).reversed())
                .forEach(System.out::println);


        // 8. Unique product categories
        System.out.println("\n8. Unique Product Categories");

        products.stream()
                .map(Product::getCategory)
                .distinct()
                .forEach(System.out::println);


        // 9. Count products in stock
        long inStockCount = products.stream()
                .filter(Product::isInStock)
                .count();

        System.out.println(
                "\n9. Products In Stock Count: " + inStockCount);


        // 10. Costliest and cheapest product
        Optional<Product> costliest = products.stream()
                .max(Comparator.comparingDouble(Product::getPrice));

        Optional<Product> cheapest = products.stream()
                .min(Comparator.comparingDouble(Product::getPrice));

        System.out.println("\n10. Costliest Product");

        costliest.ifPresent(System.out::println);

        System.out.println("Cheapest Product");

        cheapest.ifPresent(System.out::println);


        // 11. Average product price
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);

        System.out.println(
                "\n11. Average Product Price: " + averagePrice);


        // 12. Total value using reduce
        double totalValue = products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);

        System.out.println(
                "\n12. Total Product Value: " + totalValue);


        // 13. Check all products are in stock
        boolean allInStock = products.stream()
                .allMatch(Product::isInStock);

        System.out.println(
                "\n13. Are All Products In Stock? " + allInStock);


        // 14. Check any customer belongs to Delhi
        boolean customerFromDelhi = customers.stream()
                .anyMatch(customer ->
                        customer.getCity().equalsIgnoreCase("Delhi"));

        System.out.println(
                "\n14. Any Customer From Delhi? " + customerFromDelhi);


        // 15. Find first Prime customer
        Optional<Customer> firstPrimeCustomer = customers.stream()
                .filter(Customer::isPrimeMember)
                .findFirst();

        System.out.println("\n15. First Prime Customer");

        firstPrimeCustomer.ifPresent(System.out::println);


        // 16. Top 3 highest rated products
        System.out.println("\n16. Top 3 Highest Rated Products");

        products.stream()
                .sorted(Comparator.comparingDouble(
                        Product::getRating).reversed())
                .limit(3)
                .forEach(System.out::println);


        // 17. Group products by category
        Map<String, List<Product>> productsByCategory =
                products.stream()
                        .collect(Collectors.groupingBy(
                                Product::getCategory));

        System.out.println("\n17. Products Grouped By Category");

        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });


        // 18. Group products by seller
        Map<Seller, List<Product>> productsBySeller =
                products.stream()
                        .collect(Collectors.groupingBy(
                                Product::getSeller));

        System.out.println("\n18. Products Grouped By Seller");

        productsBySeller.forEach((seller, productList) -> {
            System.out.println(
                    seller.getName() + ": " + productList);
        });


        // 19. Partition products by stock
        Map<Boolean, List<Product>> partitionedProducts =
                products.stream()
                        .collect(Collectors.partitioningBy(
                                Product::isInStock));

        System.out.println(
                "\n19. In Stock Products: "
                        + partitionedProducts.get(true));

        System.out.println(
                "Out Of Stock Products: "
                        + partitionedProducts.get(false));


        // 20. Map Product ID to Product
        Map<Integer, Product> productMap =
                products.stream()
                        .collect(Collectors.toMap(
                                Product::getProductId,
                                product -> product));

        System.out.println("\n20. Product Map");

        productMap.forEach((id, product) ->
                System.out.println(id + " -> " + product));


        // 21. Customer names separated by commas
        String customerNames = customers.stream()
                .map(Customer::getName)
                .collect(Collectors.joining(", "));

        System.out.println(
                "\n21. Customer Names: " + customerNames);
    }
}
