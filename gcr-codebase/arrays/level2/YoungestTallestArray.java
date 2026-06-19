import java.util.Scanner;

public class YoungestTallestArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];

        for(int i=0;i<3;i++) ages[i] = sc.nextInt();
        for(int i=0;i<3;i++) heights[i] = sc.nextDouble();

        int youngest = ages[0];
        double tallest = heights[0];

        for(int i=1;i<3;i++){
            if(ages[i] < youngest) youngest = ages[i];
            if(heights[i] > tallest) tallest = heights[i];
        }

        System.out.println("Youngest Age = " + youngest);
        System.out.println("Tallest Height = " + tallest);
    }
}