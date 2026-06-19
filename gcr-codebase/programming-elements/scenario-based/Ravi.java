/*Ravi just joined a coding guild. Store his name, age, rank, salary, and
membership fee (float) using correct data types. Compute his
annual bonus (12% of salary), cast it to int, and print a formatted
welcome card. */


public class Ravi{
public static void main(String[] args){
  String name="Ravi";
  int age=25;
  int rank=1;
  double salary=50000.0;
  float membership_fee=100.0f;
  //int annualbonus=(int)(salary*0.12);
  int  annualbonus=calculate(salary);
  calculate(salary);
  printWelcomeCard(name,age,rank,salary,membership_fee,annualbonus);




}
public static void printWelcomeCard(  String name,
  int age,
  int rank,
  double salary,
  float membership_fee,
  int annualbonus){
    System.out.println("Welcome " + name);
    System.out.println("Age: " + age);
    System.out.println("Rank: " + rank);
    System.out.println("Salary:"+ salary);
    System.out.println("Membership Fee: $" +membership_fee);
    System.out.println("Annual Bonus: " + annualbonus);
  }

  public static int calculate(double salary){


    return (int) (salary*.12);
  }
}



  /* to take input from command line arguments, you can use the following code:
 public class Practice {
    public static void main(String[] args) {
        String name = args[0];
        int age = Integer.parseInt(args[1]);
        int rank = Integer.parseInt(args[2]);
        double salary = Double.parseDouble(args[3]);
        float membershipFee = Float.parseFloat(args[4]);

        int annualBonus = (int)(salary * 0.12);

      
} 

        System.out.println("Welcome " + name);
        System.out.println("Age: " + age);
        System.out.println("Rank: " + rank);
        System.out.println("Salary: $" + salary);
        System.out.println("Membership Fee: $" + membershipFee);
        System.out.println("Annual Bonus: $" + annualBonus);
    }
} */