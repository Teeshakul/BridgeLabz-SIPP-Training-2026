import java.time.YearMonth;
import java.util.Scanner;

public class CalendarDisplay {

    static String getMonthName(int month) {

        String[] months = {
                "January","February","March","April","May","June",
                "July","August","September","October","November","December"
        };

        return months[month - 1];
    }

    static int firstDay(int month, int year) {

        int m = month;
        int y = year;

        if (m < 3) {
            m += 12;
            y--;
        }

        int q = 1;
        int k = y % 100;
        int j = y / 100;

        int h = (q + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;

        return (h + 6) % 7;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Month: ");
        int month = sc.nextInt();

        System.out.print("Enter Year: ");
        int year = sc.nextInt();

        int days = YearMonth.of(year, month).lengthOfMonth();
        int start = firstDay(month, year);

        System.out.println("\n   " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < start; i++)
            System.out.print("    ");

        for (int day = 1; day <= days; day++) {

            System.out.printf("%3d ", day);

            if ((day + start) % 7 == 0)
                System.out.println();
        }
    }
}