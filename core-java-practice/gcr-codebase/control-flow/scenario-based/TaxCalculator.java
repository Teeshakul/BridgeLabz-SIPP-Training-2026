/*A kingdom's tax system charges 5% for income <10K, 15% for 10K–
50K, 30% above 50K. Read a citizen's income, print tax bracket and
amount. Extend: loop over an array of 10 citizens and tally total tax
collected. */

import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] incomes = new double[10];
        double totalTax = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter income of citizen " + (i + 1) + ": ");
            incomes[i] = sc.nextDouble();

            double tax;
            String bracket;

            if (incomes[i] < 10000) {
                tax = incomes[i] * 0.05;
                bracket = "5% Tax Bracket";
            } 
            else if (incomes[i] <= 50000) {
                tax = incomes[i] * 0.15;
                bracket = "15% Tax Bracket";
            } 
            else {
                tax = incomes[i] * 0.30;
                bracket = "30% Tax Bracket";
            }

            totalTax += tax;

            System.out.println("Income: " + incomes[i]);
            System.out.println("Tax Bracket: " + bracket);
            System.out.println("Tax Amount: " + tax);
            System.out.println();
        }

        System.out.println("Total Tax Collected = " + totalTax);
    }
}