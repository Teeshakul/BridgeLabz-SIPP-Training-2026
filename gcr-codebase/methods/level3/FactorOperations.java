import java.util.Scanner;

public class FactorOperations {

    static int[] findFactors(int number) {

        int count = 0;

        for (int i = 1; i <= number; i++)
            if (number % i == 0)
                count++;

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++)
            if (number % i == 0)
                factors[index++] = i;

        return factors;
    }

    static int greatestFactor(int[] factors) {

        if (factors.length == 1)
            return factors[0];

        return factors[factors.length - 2];
    }

    static int sumFactors(int[] factors) {

        int sum = 0;

        for (int i : factors)
            sum += i;

        return sum;
    }

    static int productFactors(int[] factors) {

        int product = 1;

        for (int i : factors)
            product *= i;

        return product;
    }

    static double cubeProduct(int[] factors) {

        double product = 1;

        for (int i : factors)
            product *= Math.pow(i, 3);

        return product;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors: ");

        for (int i : factors)
            System.out.print(i + " ");

        System.out.println("\nGreatest Factor = " + greatestFactor(factors));
        System.out.println("Sum = " + sumFactors(factors));
        System.out.println("Product = " + productFactors(factors));
        System.out.println("Cube Product = " + cubeProduct(factors));
    }
}