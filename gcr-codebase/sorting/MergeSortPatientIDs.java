import java.util.Arrays;
import java.util.Scanner;

public class MergeSortPatientIDs {

    static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = 0; i < temp.length; i++)
            arr[left + i] = temp[i];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();

        int[] ids = new int[n];

        System.out.println("Enter Patient IDs:");

        for (int i = 0; i < n; i++)
            ids[i] = sc.nextInt();

        mergeSort(ids, 0, n - 1);

        System.out.println("Sorted Patient IDs");

        System.out.println(Arrays.toString(ids));
    }
}