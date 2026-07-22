import java.util.Scanner;

public class FixedWindowCPUSpike {

    static int maxSubarraySum(int[] cpuLoad, int k) {

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < cpuLoad.length; end++) {

            windowSum += cpuLoad[end];

            if (end >= k - 1) {

                if (windowSum > maxSum)
                    maxSum = windowSum;

                windowSum -= cpuLoad[start];
                start++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of readings: ");
        int n = sc.nextInt();

        int[] cpuLoad = new int[n];

        System.out.println("Enter CPU readings:");

        for (int i = 0; i < n; i++)
            cpuLoad[i] = sc.nextInt();

        System.out.print("Enter window size: ");
        int k = sc.nextInt();

        System.out.println("Maximum Window Sum = " + maxSubarraySum(cpuLoad, k));
    }
}