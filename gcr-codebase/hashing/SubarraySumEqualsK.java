import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumEqualsK {

    static int countSubarrays(int[] revenueChanges, int k) {

        Map<Integer, Integer> prefixCount = new HashMap<>();

        prefixCount.put(0, 1);

        int runningSum = 0;
        int answer = 0;

        for (int change : revenueChanges) {

            runningSum += change;

            answer += prefixCount.getOrDefault(runningSum - k, 0);

            prefixCount.put(runningSum,
                    prefixCount.getOrDefault(runningSum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of revenue changes: ");
        int n = sc.nextInt();

        int[] revenue = new int[n];

        System.out.println("Enter revenue changes:");

        for (int i = 0; i < n; i++)
            revenue[i] = sc.nextInt();

        System.out.print("Enter target sum: ");
        int k = sc.nextInt();

        System.out.println("Number of Subarrays = " + countSubarrays(revenue, k));
    }
}