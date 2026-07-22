import java.util.Arrays;
import java.util.Random;

public class LibrarySortingComparison {

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

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void countingSort(int[] arr) {

        int[] count = new int[21];

        for (int num : arr)
            count[num]++;

        int index = 0;

        for (int i = 1; i <= 20; i++)
            while (count[i]-- > 0)
                arr[index++] = i;
    }

    static void compareRuntime(int size) {

        Random random = new Random();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
            arr[i] = random.nextInt(1000);

        int[] merge = arr.clone();
        int[] quick = arr.clone();

        long start = System.nanoTime();
        mergeSort(merge, 0, merge.length - 1);
        long mergeTime = System.nanoTime() - start;

        start = System.nanoTime();
        quickSort(quick, 0, quick.length - 1);
        long quickTime = System.nanoTime() - start;

        System.out.println("\nSize : " + size);
        System.out.println("Merge Sort : " + mergeTime + " ns");
        System.out.println("Quick Sort : " + quickTime + " ns");
    }

    public static void main(String[] args) {

        compareRuntime(100);
        compareRuntime(1000);
        compareRuntime(10000);
    }
}