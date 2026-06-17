import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amarAge = sc.nextInt();
        int akbarAge = sc.nextInt();
        int anthonyAge = sc.nextInt();

        double amarHeight = sc.nextDouble();
        double akbarHeight = sc.nextDouble();
        double anthonyHeight = sc.nextDouble();

        int youngest = Math.min(amarAge,
                        Math.min(akbarAge, anthonyAge));

        double tallest = Math.max(amarHeight,
                          Math.max(akbarHeight, anthonyHeight));

        System.out.println("Youngest Age = " + youngest);
        System.out.println("Tallest Height = " + tallest);
    }
}