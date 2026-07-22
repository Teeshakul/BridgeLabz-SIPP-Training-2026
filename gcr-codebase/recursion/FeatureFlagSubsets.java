import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FeatureFlagSubsets {

    static void generateSubsets(String[] flags,
                                int index,
                                List<String> current,
                                List<List<String>> result) {

        if (index == flags.length) {

            result.add(new ArrayList<>(current));
            return;
        }

        current.add(flags[index]);

        generateSubsets(flags,
                index + 1,
                current,
                result);

        current.remove(current.size() - 1);

        generateSubsets(flags,
                index + 1,
                current,
                result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of feature flags: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] flags = new String[n];

        System.out.println("Enter feature names:");

        for (int i = 0; i < n; i++)
            flags[i] = sc.nextLine();

        List<List<String>> result = new ArrayList<>();

        generateSubsets(flags,
                0,
                new ArrayList<>(),
                result);

        System.out.println("\nAll Feature Combinations:");

        for (List<String> subset : result)
            System.out.println(subset);
    }
}