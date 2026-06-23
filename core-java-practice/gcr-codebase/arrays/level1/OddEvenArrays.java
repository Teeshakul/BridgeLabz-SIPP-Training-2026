import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int[] odd = new int[number];
        int[] even = new int[number];

        int o = 0, e = 0;

        for(int i=1;i<=number;i++){
            if(i % 2 == 0)
                even[e++] = i;
            else
                odd[o++] = i;
        }

        System.out.print("Odd: ");
        for(int i=0;i<o;i++)
            System.out.print(odd[i] + " ");

        System.out.print("\nEven: ");
        for(int i=0;i<e;i++)
            System.out.print(even[i] + " ");
    }
}