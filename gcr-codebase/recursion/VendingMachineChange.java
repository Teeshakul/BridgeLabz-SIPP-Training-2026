import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VendingMachineChange {

    static void combinationSum(int[] coins,
                               int target,
                               int start,
                               int sum,
                               List<Integer> current,
                               List<List<Integer>> result) {

        if (sum == target) {

            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < coins.length; i++) {

            if (sum + coins[i] > target)
                break;

            current.add(coins[i]);

            combinationSum(coins,
                    target,
                    i,
                    sum + coins[i],
                    current,
                    result);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coin types: ");
        int n = sc.nextInt();

        int[] coins = new int[n];

        System.out.println("Enter coin values:");

        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();

        Arrays.sort(coins);

        System.out.print("Enter target amount: ");
        int target = sc.nextInt();

        List<List<Integer>> result = new ArrayList<>();

        combinationSum(coins,
                target,
                0,
                0,
                new ArrayList<>(),
                result);

        System.out.println("\nPossible Coin Combinations:");

        for (List<Integer> combination : result)
            System.out.println(combination);
    }
}