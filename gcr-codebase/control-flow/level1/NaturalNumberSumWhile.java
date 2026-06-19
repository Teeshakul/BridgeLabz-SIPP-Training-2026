import java.util.Scanner;

public class NaturalNumberSumWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int i = 1, sum = 0;

        while (i <= n) {
            sum += i;
            i++;
        }

        System.out.println("While Sum = " + sum);
        System.out.println("Formula Sum = " + (n * (n + 1) / 2));
    }
}