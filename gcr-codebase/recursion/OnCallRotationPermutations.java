import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnCallRotationPermutations {

    static void generatePermutations(String[] engineers,
                                     boolean[] used,
                                     List<String> current,
                                     List<List<String>> result) {

        if (current.size() == engineers.length) {

            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < engineers.length; i++) {

            if (used[i])
                continue;

            used[i] = true;

            current.add(engineers[i]);

            generatePermutations(engineers,
                    used,
                    current,
                    result);

            current.remove(current.size() - 1);

            used[i] = false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of engineers: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] engineers = new String[n];

        System.out.println("Enter engineer names:");

        for (int i = 0; i < n; i++)
            engineers[i] = sc.nextLine();

        List<List<String>> result = new ArrayList<>();

        generatePermutations(engineers,
                new boolean[n],
                new ArrayList<>(),
                result);

        System.out.println("\nPossible On-Call Schedules:");

        for (List<String> schedule : result)
            System.out.println(schedule);
    }
}