import java.util.Scanner;

public class FactorsOfNumber {

    static int[] findFactors(int number) {

        int count = 0;

        for (int i = 1; i <= number; i++)
            if (number % i == 0)
                count++;

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                factors[index++] = i;
        }

        return factors;
    }

    static int findSum(int[] factors) {

        int sum = 0;

        for (int i : factors)
            sum += i;

        return sum;
    }

    static int findProduct(int[] factors) {

        int product = 1;

        for (int i : factors)
            product *= i;

        return product;
    }

    static double findSquareSum(int[] factors) {

        double sum = 0;

        for (int i : factors)
            sum += Math.pow(i, 2);

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors: ");

        for (int i : factors)
            System.out.print(i + " ");

        System.out.println("\nSum = " + findSum(factors));
        System.out.println("Product = " + findProduct(factors));
        System.out.println("Sum of Squares = " + findSquareSum(factors));
    }
}