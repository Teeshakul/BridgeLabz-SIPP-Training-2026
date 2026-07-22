import java.util.Scanner;

public class NumberChecker5 {

    static boolean isPerfect(int n) {

        int sum = 0;

        for (int i = 1; i < n; i++)
            if (n % i == 0)
                sum += i;

        return sum == n;
    }

    static boolean isAbundant(int n) {

        int sum = 0;

        for (int i = 1; i < n; i++)
            if (n % i == 0)
                sum += i;

        return sum > n;
    }

    static boolean isDeficient(int n) {

        int sum = 0;

        for (int i = 1; i < n; i++)
            if (n % i == 0)
                sum += i;

        return sum < n;
    }

    static int factorial(int n) {

        int fact = 1;

        for (int i = 1; i <= n; i++)
            fact *= i;

        return fact;
    }

    static boolean isStrong(int n) {

        int original = n;
        int sum = 0;

        while (n > 0) {
            sum += factorial(n % 10);
            n /= 10;
        }

        return sum == original;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        System.out.println("Perfect = " + isPerfect(number));
        System.out.println("Abundant = " + isAbundant(number));
        System.out.println("Deficient = " + isDeficient(number));
        System.out.println("Strong = " + isStrong(number));
    }
}