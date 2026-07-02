import java.util.Scanner;

public class YoungestTallestFriend {

    static String[] names = {"Amar", "Akbar", "Anthony"};

    public static String findYoungest(int[] age) {

        int min = 0;

        for (int i = 1; i < age.length; i++) {
            if (age[i] < age[min])
                min = i;
        }

        return names[min];
    }

    public static String findTallest(double[] height) {

        int max = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[max])
                max = i;
        }

        return names[max];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {

            System.out.print("Enter age of " + names[i] + ": ");
            age[i] = sc.nextInt();

            System.out.print("Enter height of " + names[i] + ": ");
            height[i] = sc.nextDouble();
        }

        System.out.println("Youngest Friend : " + findYoungest(age));
        System.out.println("Tallest Friend : " + findTallest(height));
    }
}