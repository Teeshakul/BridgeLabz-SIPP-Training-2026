import java.util.Scanner;

public class RecursiveNaturalSum {

    static int recursiveSum(int n) {

        if (n == 0)
            return 0;

        return n + recursiveSum(n - 1);
    }

    static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        int recursive = recursiveSum(n);
        int formula = formulaSum(n);

        System.out.println("Recursive Sum = " + recursive);
        System.out.println("Formula Sum = " + formula);

        if (recursive == formula)
            System.out.println("Both results are same.");
    }
}