import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortStudentMarks {

    static void bubbleSort(int[] marks) {

        boolean swapped;

        for (int i = 0; i < marks.length - 1; i++) {

            swapped = false;

            for (int j = 0; j < marks.length - i - 1; j++) {

                if (marks[j] > marks[j + 1]) {

                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        System.out.println("Enter marks:");

        for (int i = 0; i < n; i++)
            marks[i] = sc.nextInt();

        bubbleSort(marks);

        System.out.println("Sorted Marks");

        System.out.println(Arrays.toString(marks));
    }
}