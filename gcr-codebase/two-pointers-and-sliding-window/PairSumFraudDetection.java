import java.util.Arrays;
import java.util.Scanner;

public class PairSumFraudDetection {

    static int[] findPair(int[] transactions, int target) {

        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {

            int sum = transactions[left] + transactions[right];

            if (sum == target)
                return new int[]{transactions[left], transactions[right]};

            if (sum < target)
                left++;
            else
                right--;
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        int[] transactions = new int[n];

        System.out.println("Enter sorted transactions:");

        for (int i = 0; i < n; i++)
            transactions[i] = sc.nextInt();

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        int[] pair = findPair(transactions, target);

        if (pair[0] == -1)
            System.out.println("Pair Not Found");
        else
            System.out.println("Pair = " + Arrays.toString(pair));
    }
}