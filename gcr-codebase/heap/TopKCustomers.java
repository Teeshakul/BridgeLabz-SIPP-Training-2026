import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopKCustomers {

    static List<Integer> topK(int[] transactions, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int amount : transactions) {

            if (minHeap.size() < k) {

                minHeap.offer(amount);

            } else if (amount > minHeap.peek()) {

                minHeap.poll();
                minHeap.offer(amount);
            }
        }

        List<Integer> result = new ArrayList<>(minHeap);

        Collections.sort(result, Collections.reverseOrder());

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of customers: ");
        int n = sc.nextInt();

        int[] transactions = new int[n];

        System.out.println("Enter transaction amounts:");

        for (int i = 0; i < n; i++)
            transactions[i] = sc.nextInt();

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        System.out.println("Top " + k + " Customers:");

        System.out.println(topK(transactions, k));
    }
}