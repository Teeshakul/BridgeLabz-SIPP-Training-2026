import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterVisitorDay {

    static int[] nextGreater(int[] visitors) {

        int n = visitors.length;

        int[] answer = new int[n];

        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    visitors[i] > visitors[stack.peek()]) {

                answer[stack.pop()] = visitors[i];
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] visitors = new int[n];

        System.out.println("Enter visitor counts:");

        for (int i = 0; i < n; i++)
            visitors[i] = sc.nextInt();

        int[] result = nextGreater(visitors);

        System.out.println("Next Greater Visitor Count:");

        System.out.println(Arrays.toString(result));
    }
}