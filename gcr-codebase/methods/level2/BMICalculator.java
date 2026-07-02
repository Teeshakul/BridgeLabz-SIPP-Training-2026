import java.util.Scanner;

public class BMICalculator {

    static void calculateBMI(double[][] data) {

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double height = data[i][1] / 100;

            data[i][2] = weight / (height * height);
        }
    }

    static String[] getStatus(double[][] data) {

        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {

            double bmi = data[i][2];

            if (bmi < 18.5)
                status[i] = "Underweight";
            else if (bmi < 25)
                status[i] = "Normal";
            else if (bmi < 30)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        return status;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] person = new double[10][3];

        for (int i = 0; i < 10; i++) {

            System.out.print("Weight (kg): ");
            person[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            person[i][1] = sc.nextDouble();
        }

        calculateBMI(person);

        String[] status = getStatus(person);

        System.out.println("\nWeight\tHeight\tBMI\tStatus");

        for (int i = 0; i < 10; i++) {

            System.out.printf("%.1f\t%.1f\t%.2f\t%s\n",
                    person[i][0],
                    person[i][1],
                    person[i][2],
                    status[i]);
        }
    }
}