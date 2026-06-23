import java.util.Scanner;

public class ToUpperCaseComparison {

    static String convert(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z')
                ch = (char)(ch - 32);

            result += ch;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String s1 = convert(text);
        String s2 = text.toUpperCase();

        System.out.println(s1.equals(s2));
    }
}