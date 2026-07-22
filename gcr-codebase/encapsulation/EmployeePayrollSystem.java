abstract class Employee {

    private int employeeId;
    private String employeeName;

    public Employee(int employeeId, String employeeName) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    abstract double calculateSalary();

    public void displayEmployeeInfo() {

        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
    }
}

class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public FullTimeEmployee(int id, String name, double monthlySalary) {

        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id,
                            String name,
                            int hoursWorked,
                            double hourlyRate) {

        super(id, name);

        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    double calculateSalary() {

        return hoursWorked * hourlyRate;
    }
}

public class EmployeePayrollSystem {

    public static void main(String[] args) {

        Employee fullTime =
                new FullTimeEmployee(101,
                        "Aman",
                        50000);

        Employee partTime =
                new PartTimeEmployee(102,
                        "Rahul",
                        80,
                        500);

        fullTime.displayEmployeeInfo();
        System.out.println("Salary : " + fullTime.calculateSalary());

        System.out.println();

        partTime.displayEmployeeInfo();
        System.out.println("Salary : " + partTime.calculateSalary());
    }
}