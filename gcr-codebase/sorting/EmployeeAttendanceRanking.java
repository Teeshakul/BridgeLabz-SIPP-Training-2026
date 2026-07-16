import java.util.Scanner;

public class EmployeeAttendanceRanking {

    static void sort(int[] ids, int[] attendance) {

        for (int i = 0; i < attendance.length - 1; i++) {

            int max = i;

            for (int j = i + 1; j < attendance.length; j++) {

                if (attendance[j] > attendance[max] ||
                        (attendance[j] == attendance[max] && ids[j] < ids[max])) {

                    max = j;
                }
            }

            int temp = attendance[i];
            attendance[i] = attendance[max];
            attendance[max] = temp;

            temp = ids[i];
            ids[i] = ids[max];
            ids[max] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] ids = new int[n];
        int[] attendance = new int[n];

        System.out.println("Enter Employee IDs:");

        for (int i = 0; i < n; i++)
            ids[i] = sc.nextInt();

        System.out.println("Enter Attendance:");

        for (int i = 0; i < n; i++)
            attendance[i] = sc.nextInt();

        System.out.print("Enter K: ");
        int k = sc.nextInt();

        sort(ids, attendance);

        System.out.println("\nTop " + k + " Employees");

        for (int i = 0; i < k; i++)
            System.out.println(ids[i] + " -> " + attendance[i] + "%");
    }
}