import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumWindowSubstring {

    static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0)
            return "";

        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        Map<Character, Integer> window = new HashMap<>();

        int required = need.size();
        int formed = 0;

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch) &&
                    window.get(ch).intValue() == need.get(ch).intValue())
                formed++;

            while (left <= right && formed == required) {

                if (right - left + 1 < minLength) {

                    minLength = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);

                window.put(remove, window.get(remove) - 1);

                if (need.containsKey(remove) &&
                        window.get(remove) < need.get(remove))
                    formed--;

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLength);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter main string: ");
        String s = sc.nextLine();

        System.out.print("Enter target string: ");
        String t = sc.nextLine();

        System.out.println("Minimum Window = " + minWindow(s, t));
    }
}