import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int[] digits = new int[20];
        int count = 0;

        while(number != 0){
            digits[count++] = number % 10;
            number /= 10;
        }

        for(int i=0;i<count;i++){
            System.out.print(digits[i]);
        }
    }
}