import java.util.Scanner;

public class EmployeeBonusArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        int[] years = new int[10];
        double totalBonus = 0;

        for(int i=0;i<10;i++){
            salary[i] = sc.nextDouble();
            years[i] = sc.nextInt();
        }

        for(int i=0;i<10;i++){
            double bonus = years[i] > 5 ? salary[i]*0.05 : salary[i]*0.02;
            double newSalary = salary[i] + bonus;

            totalBonus += bonus;

            System.out.println("Old Salary: " + salary[i]);
            System.out.println("Bonus: " + bonus);
            System.out.println("New Salary: " + newSalary);
        }

        System.out.println("Total Bonus = " + totalBonus);
    }
}