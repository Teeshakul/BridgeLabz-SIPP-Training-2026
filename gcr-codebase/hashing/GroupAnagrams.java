import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GroupAnagrams {

    static List<List<String>> groupAnagrams(String[] words) {

        Map<String, List<String>> groups = new HashMap<>();

        for (String word : words) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] words = new String[n];

        System.out.println("Enter words:");

        for (int i = 0; i < n; i++)
            words[i] = sc.nextLine();

        List<List<String>> result = groupAnagrams(words);

        System.out.println("\nGrouped Anagrams:");

        for (List<String> group : result)
            System.out.println(group);
    }
}