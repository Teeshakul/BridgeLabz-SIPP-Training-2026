import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubarrayNDistinct {

    static int longestSubarray(int[] keyIds, int n) {

        Map<Integer, Integer> frequency = new HashMap<>();

        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < keyIds.length; end++) {

            frequency.put(keyIds[end],
                    frequency.getOrDefault(keyIds[end], 0) + 1);

            while (frequency.size() > n) {

                int leftKey = keyIds[start];

                frequency.put(leftKey, frequency.get(leftKey) - 1);

                if (frequency.get(leftKey) == 0)
                    frequency.remove(leftKey);

                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of API requests: ");
        int size = sc.nextInt();

        int[] keyIds = new int[size];

        System.out.println("Enter API Key IDs:");

        for (int i = 0; i < size; i++)
            keyIds[i] = sc.nextInt();

        System.out.print("Enter maximum distinct keys: ");
        int n = sc.nextInt();

        int answer = longestSubarray(keyIds, n);

        System.out.println("Longest Valid Subarray Length = " + answer);
    }
}