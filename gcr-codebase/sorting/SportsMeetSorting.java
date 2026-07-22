import java.util.Arrays;
import java.util.Random;

public class SportsMeetSorting {

    static void bubbleSort(int[] arr) {

        int swaps = 0;
        boolean sorted;

        System.out.println("\nBubble Sort");

        for (int i = 0; i < arr.length - 1; i++) {

            sorted = true;

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    sorted = false;
                }
            }

            System.out.println("Pass " + (i + 1) + " : " + Arrays.toString(arr));

            if (sorted) {
                System.out.println("Already Sorted (Best Case)");
                break;
            }
        }

        System.out.println("Total Swaps = " + swaps);
    }

    static void insertionSort(int[] arr) {

        int swaps = 0;

        System.out.println("\nInsertion Sort");

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j--;
                swaps++;
            }

            arr[j + 1] = key;

            System.out.println("Pass " + i + " : " + Arrays.toString(arr));
        }

        System.out.println("Total Shifts = " + swaps);
    }

    static void topThree(int[] arr) {

        int[] copy = arr.clone();
        Arrays.sort(copy);

        System.out.println("\nTop 3 Medalists Scores");

        for (int i = copy.length - 1; i >= copy.length - 3; i--)
            System.out.println(copy[i]);
    }

    public static void main(String[] args) {

        Random random = new Random();

        int[] scores = new int[50];

        for (int i = 0; i < scores.length; i++)
            scores[i] = random.nextInt(101);

        bubbleSort(scores.clone());

        insertionSort(scores.clone());

        topThree(scores);

        int[] sample = {64, 25, 12, 22, 11};

        System.out.println("\nTracing Bubble Sort on Sample");

        bubbleSort(sample);
    }
}