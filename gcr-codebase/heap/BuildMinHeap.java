import java.util.Arrays;
import java.util.Scanner;

public class BuildMinHeap {

    static void heapify(int[] arr, int i, int size) {

        int smallest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] < arr[smallest])
            smallest = left;

        if (right < size && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != i) {

            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapify(arr, smallest, size);
        }
    }

    static void buildHeap(int[] arr) {

        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, i, arr.length);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of priorities: ");
        int n = sc.nextInt();

        int[] priorities = new int[n];

        System.out.println("Enter priorities:");

        for (int i = 0; i < n; i++)
            priorities[i] = sc.nextInt();

        buildHeap(priorities);

        System.out.println("Min Heap:");

        System.out.println(Arrays.toString(priorities));
    }
}