import java.util.Arrays;

public class RandomStatistics {

    static int[] generate4DigitRandomArray(int size) {

        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
            arr[i] = (int) (Math.random() * 9000) + 1000;

        return arr;
    }

    static double[] findAverageMinMax(int[] arr) {

        int sum = 0;
        int min = arr[0];
        int max = arr[0];

        for (int n : arr) {

            sum += n;
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return new double[]{
                (double) sum / arr.length,
                min,
                max
        };
    }

    public static void main(String[] args) {

        int[] numbers = generate4DigitRandomArray(5);

        System.out.println(Arrays.toString(numbers));

        double[] result = findAverageMinMax(numbers);

        System.out.println("Average = " + result[0]);
        System.out.println("Minimum = " + (int) result[1]);
        System.out.println("Maximum = " + (int) result[2]);
    }
}