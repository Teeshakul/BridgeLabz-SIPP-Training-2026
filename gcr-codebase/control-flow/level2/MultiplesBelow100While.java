import java.util.Scanner;

public class MultiplesBelow100While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int i = n;

        while(i < 100){
            System.out.print(i + " ");
            i += n;
        }
    }
}