import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentErrorCode {

    static int mostFrequent(int[] codes) {

        Map<Integer, Integer> frequency = new HashMap<>();

        int bestCode = codes[0];
        int bestCount = 0;

        for (int code : codes) {

            int count = frequency.getOrDefault(code, 0) + 1;

            frequency.put(code, count);

            if (count > bestCount) {

                bestCount = count;
                bestCode = code;
            }
        }

        return bestCode;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of error codes: ");
        int n = sc.nextInt();

        int[] codes = new int[n];

        System.out.println("Enter error codes:");

        for (int i = 0; i < n; i++)
            codes[i] = sc.nextInt();

        System.out.println("Most Frequent Error Code = " + mostFrequent(codes));
    }
}