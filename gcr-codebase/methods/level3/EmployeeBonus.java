public class EmployeeBonus {

    static double[][] generateEmployeeData() {

        double[][] data = new double[10][2];

        for (int i = 0; i < data.length; i++) {

            data[i][0] = 10000 + (int) (Math.random() * 90000);
            data[i][1] = 1 + (int) (Math.random() * 10);
        }

        return data;
    }

    static double[][] calculateBonus(double[][] data) {

        double[][] result = new double[10][2];

        for (int i = 0; i < data.length; i++) {

            double salary = data[i][0];
            double years = data[i][1];

            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;

            result[i][0] = salary + bonus;
            result[i][1] = bonus;
        }

        return result;
    }

    public static void main(String[] args) {

        double[][] oldData = generateEmployeeData();
        double[][] newData = calculateBonus(oldData);

        double oldTotal = 0;
        double newTotal = 0;
        double bonusTotal = 0;

        System.out.println("OldSalary\tYears\tBonus\tNewSalary");

        for (int i = 0; i < oldData.length; i++) {

            System.out.printf("%.2f\t%.0f\t%.2f\t%.2f%n",
                    oldData[i][0],
                    oldData[i][1],
                    newData[i][1],
                    newData[i][0]);

            oldTotal += oldData[i][0];
            newTotal += newData[i][0];
            bonusTotal += newData[i][1];
        }

        System.out.println("\nOld Salary Total = " + oldTotal);
        System.out.println("New Salary Total = " + newTotal);
        System.out.println("Bonus Total = " + bonusTotal);
    }
}