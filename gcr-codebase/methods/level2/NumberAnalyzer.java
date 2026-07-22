import java.util.Scanner;

public class NumberAnalyzer {

    static boolean isPositive(int number) {
        return number >= 0;
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    static int compare(int n1, int n2) {

        if (n1 > n2)
            return 1;
        else if (n1 == n2)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {

            System.out.print("Enter number: ");
            numbers[i] = sc.nextInt();

            if (isPositive(numbers[i])) {

                if (isEven(numbers[i]))
                    System.out.println("Positive Even");
                else
                    System.out.println("Positive Odd");

            } else {

                System.out.println("Negative");
            }
        }

        int result = compare(numbers[0], numbers[4]);

        if (result == 1)
            System.out.println("First element is Greater");
        else if (result == 0)
            System.out.println("Both are Equal");
        else
            System.out.println("First element is Smaller");
    }
}