import java.util.Scanner;

public class NumberChecker2 {

    static int countDigits(int n) {

        int count = 0;

        while (n != 0) {
            count++;
            n /= 10;
        }

        return count;
    }

    static int[] storeDigits(int n) {

        int[] digits = new int[countDigits(n)];

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }

        return digits;
    }

    static int sumDigits(int[] digits) {

        int sum = 0;

        for (int d : digits)
            sum += d;

        return sum;
    }

    static double sumSquareDigits(int[] digits) {

        double sum = 0;

        for (int d : digits)
            sum += Math.pow(d, 2);

        return sum;
    }

    static boolean isHarshad(int number, int[] digits) {
        return number % sumDigits(digits) == 0;
    }

    static void frequency(int[] digits) {

        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++)
            freq[i][0] = i;

        for (int d : digits)
            freq[d][1]++;

        System.out.println("Digit Frequency");

        for (int i = 0; i < 10; i++)
            if (freq[i][1] > 0)
                System.out.println(freq[i][0] + " -> " + freq[i][1]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Sum = " + sumDigits(digits));
        System.out.println("Square Sum = " + sumSquareDigits(digits));
        System.out.println("Harshad = " + isHarshad(number, digits));

        frequency(digits);
    }
}