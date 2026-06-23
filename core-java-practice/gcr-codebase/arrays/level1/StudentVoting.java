import java.util.Scanner;

public class StudentVoting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] age = new int[10];

        for (int i = 0; i < age.length; i++) {
            age[i] = sc.nextInt();

            if (age[i] < 0)
                System.out.println("Invalid Age");
            else if (age[i] >= 18)
                System.out.println("Can Vote");
            else
                System.out.println("Cannot Vote");
        }
        sc.close();
    }
}