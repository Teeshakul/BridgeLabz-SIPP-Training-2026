import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        double num = sc.nextDouble();

        while (num != 0) {
            sum += num;
            num = sc.nextDouble();
        }

        System.out.println(sum);
    }
}