import java.util.Scanner;

public class NumberChecker1 {

    static int countDigits(int n) {

        int count = 0;

        while (n != 0) {
            count++;
            n /= 10;
        }

        return count;
    }

    static int[] storeDigits(int n) {

        int size = countDigits(n);
        int[] digits = new int[size];

        for (int i = size - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }

        return digits;
    }

    static boolean isDuck(int[] digits) {

        for (int i = 1; i < digits.length; i++)
            if (digits[i] == 0)
                return true;

        return false;
    }

    static boolean isArmstrong(int number, int[] digits) {

        int sum = 0;

        for (int d : digits)
            sum += Math.pow(d, digits.length);

        return sum == number;
    }

    static void largestSecondLargest(int[] digits) {

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int d : digits) {

            if (d > largest) {
                second = largest;
                largest = d;
            } else if (d > second && d != largest) {
                second = d;
            }
        }

        System.out.println("Largest = " + largest);
        System.out.println("Second Largest = " + second);
    }

    static void smallestSecondSmallest(int[] digits) {

        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int d : digits) {

            if (d < smallest) {
                second = smallest;
                smallest = d;
            } else if (d < second && d != smallest) {
                second = d;
            }
        }

        System.out.println("Smallest = " + smallest);
        System.out.println("Second Smallest = " + second);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Duck = " + isDuck(digits));
        System.out.println("Armstrong = " + isArmstrong(number, digits));

        largestSecondLargest(digits);
        smallestSecondSmallest(digits);
    }
}