import java.util.Scanner;

public class FirstLastOccurrence {

    static int firstOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int answer = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                answer = mid;
                right = mid - 1;
            }
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return answer;
    }

    static int lastOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int answer = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                answer = mid;
                left = mid + 1;
            }
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted array:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("First Occurrence = " + firstOccurrence(arr, target));
        System.out.println("Last Occurrence = " + lastOccurrence(arr, target));
    }
}