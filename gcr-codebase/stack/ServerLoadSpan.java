import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ServerLoadSpan {

    static int[] calculateSpan(int[] load) {

        int n = load.length;

        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && load[stack.peek()] <= load[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                span[i] = i + 1;
            else
                span[i] = i - stack.peek();

            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of readings: ");
        int n = sc.nextInt();

        int[] load = new int[n];

        System.out.println("Enter server load readings:");

        for (int i = 0; i < n; i++)
            load[i] = sc.nextInt();

        int[] span = calculateSpan(load);

        System.out.println("Load Span:");

        System.out.println(Arrays.toString(span));
    }
}