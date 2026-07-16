import java.util.Scanner;
import java.util.Stack;

public class BalancedBracketsValidator {

    static boolean isValid(String expression) {

        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == '(' || ch == '[' || ch == '{') {

                stack.push(ch);

            } else {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{'))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter brackets: ");
        String expression = sc.nextLine();

        if (isValid(expression))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }
}