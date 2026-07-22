import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StarCatalogBinarySearch {

    static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    static int searchRotated(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[left] <= arr[mid]) {

                if (target >= arr[left] && target < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;

            } else {

                if (target > arr[mid] && target <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    static int firstOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return ans;
    }

    static int lastOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return ans;
    }

    static int findMinimum(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            if (arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid;
        }

        return arr[left];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] stars = new int[20];

        Random random = new Random();

        for (int i = 0; i < stars.length; i++)
            stars[i] = random.nextInt(100);

        Arrays.sort(stars);

        System.out.println(Arrays.toString(stars));

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Binary Search = " + binarySearch(stars, target));
        System.out.println("First = " + firstOccurrence(stars, target));
        System.out.println("Last = " + lastOccurrence(stars, target));

        int[] rotated = {40,50,60,70,10,20,30};

        System.out.println("Rotated Search = " + searchRotated(rotated, target));
        System.out.println("Minimum = " + findMinimum(rotated));
    }
}