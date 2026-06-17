import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double physics = sc.nextDouble();
        double chemistry = sc.nextDouble();
        double maths = sc.nextDouble();

        double percentage = (physics + chemistry + maths) / 3;

        String grade;

        if(percentage >= 80)
            grade = "A";
        else if(percentage >= 70)
            grade = "B";
        else if(percentage >= 60)
            grade = "C";
        else if(percentage >= 50)
            grade = "D";
        else if(percentage >= 40)
            grade = "E";
        else
            grade = "R";

        System.out.println("Percentage = " + percentage);
        System.out.println("Grade = " + grade);
    }
}