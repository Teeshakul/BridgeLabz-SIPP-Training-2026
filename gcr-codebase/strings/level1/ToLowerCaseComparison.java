import java.util.Scanner;

public class ToLowerCaseComparison {

    static String convert(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z')
                ch = (char)(ch + 32);

            result += ch;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String s1 = convert(text);
        String s2 = text.toLowerCase();

        System.out.println(s1.equals(s2));
    }
}