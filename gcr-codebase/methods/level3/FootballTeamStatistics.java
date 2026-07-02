import java.util.Random;

public class FootballTeamStatistics {

    static int[] generateHeights() {

        Random r = new Random();
        int[] heights = new int[11];

        for (int i = 0; i < heights.length; i++)
            heights[i] = 150 + r.nextInt(101);

        return heights;
    }

    static int findSum(int[] arr) {

        int sum = 0;

        for (int n : arr)
            sum += n;

        return sum;
    }

    static double findMean(int[] arr) {
        return (double) findSum(arr) / arr.length;
    }

    static int findShortest(int[] arr) {

        int min = arr[0];

        for (int n : arr)
            if (n < min)
                min = n;

        return min;
    }

    static int findTallest(int[] arr) {

        int max = arr[0];

        for (int n : arr)
            if (n > max)
                max = n;

        return max;
    }

    public static void main(String[] args) {

        int[] heights = generateHeights();

        System.out.println("Player Heights");

        for (int h : heights)
            System.out.print(h + " ");

        System.out.println("\nMean Height = " + findMean(heights));
        System.out.println("Shortest = " + findShortest(heights));
        System.out.println("Tallest = " + findTallest(heights));
    }
}