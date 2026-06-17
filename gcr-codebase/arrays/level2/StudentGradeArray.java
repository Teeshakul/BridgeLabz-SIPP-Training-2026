import java.util.Scanner;

public class StudentGradeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double[] percentage = new double[n];
        String[] grade = new String[n];

        for(int i=0;i<n;i++){
            double p = sc.nextDouble();
            double c = sc.nextDouble();
            double m = sc.nextDouble();

            percentage[i] = (p+c+m)/3;

            if(percentage[i] >= 80) grade[i] = "A";
            else if(percentage[i] >= 70) grade[i] = "B";
            else if(percentage[i] >= 60) grade[i] = "C";
            else if(percentage[i] >= 50) grade[i] = "D";
            else if(percentage[i] >= 40) grade[i] = "E";
            else grade[i] = "R";
        }

        for(int i=0;i<n;i++){
            System.out.println(percentage[i] + " " + grade[i]);
        }
    }
}