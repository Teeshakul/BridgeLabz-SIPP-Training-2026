import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SlidingWindowMaximum {

    static int[] maxWindow(int[] readings, int k) {

        int n = readings.length;

        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty() &&
                    deque.peekFirst() <= i - k)
                deque.pollFirst();

            while (!deque.isEmpty() &&
                    readings[deque.peekLast()] <= readings[i])
                deque.pollLast();

            deque.offerLast(i);

            if (i >= k - 1)
                result[i - k + 1] = readings[deque.peekFirst()];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of readings: ");
        int n = sc.nextInt();

        int[] readings = new int[n];

        System.out.println("Enter throughput readings:");

        for (int i = 0; i < n; i++)
            readings[i] = sc.nextInt();

        System.out.print("Enter window size: ");
        int k = sc.nextInt();

        int[] answer = maxWindow(readings, k);

        System.out.println("Maximum in Each Window:");

        System.out.println(Arrays.toString(answer));
    }
}