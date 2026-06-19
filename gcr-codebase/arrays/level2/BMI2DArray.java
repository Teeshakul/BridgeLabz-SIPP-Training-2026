import java.util.Scanner;

public class BMI2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double[][] person = new double[n][3];
        String[] status = new String[n];

        for(int i=0;i<n;i++){
            person[i][0] = sc.nextDouble();
            person[i][1] = sc.nextDouble();

            double h = person[i][1] / 100;
            person[i][2] = person[i][0] / (h*h);

            if(person[i][2] <= 18.4) status[i] = "Underweight";
            else if(person[i][2] <= 24.9) status[i] = "Normal";
            else if(person[i][2] <= 39.9) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for(int i=0;i<n;i++){
            System.out.println(person[i][0] + " " + person[i][1] + " " + person[i][2] + " " + status[i]);
        }
    }
}