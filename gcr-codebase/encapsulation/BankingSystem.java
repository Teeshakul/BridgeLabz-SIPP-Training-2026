abstract class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber,
                       String holderName,
                       double balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {

        balance += amount;
    }

    public void withdraw(double amount) {

        if (amount <= balance)
            balance -= amount;
        else
            System.out.println("Insufficient Balance");
    }

    public void displayAccountDetails() {

        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Balance        : ₹" + balance);
    }

    abstract double calculateInterest();
}

class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber,
                          String holderName,
                          double balance,
                          double interestRate) {

        super(accountNumber, holderName, balance);

        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {

        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends BankAccount {

    private double monthlyBonusRate;

    public CurrentAccount(String accountNumber,
                          String holderName,
                          double balance,
                          double monthlyBonusRate) {

        super(accountNumber, holderName, balance);

        this.monthlyBonusRate = monthlyBonusRate;
    }

    @Override
    double calculateInterest() {

        return getBalance() * monthlyBonusRate / 100;
    }
}

public class BankingSystem {

    public static void main(String[] args) {

        BankAccount savings =
                new SavingsAccount("SB101",
                        "Aman",
                        50000,
                        6);

        BankAccount current =
                new CurrentAccount("CA201",
                        "Rahul",
                        30000,
                        2);

        savings.deposit(5000);
        savings.withdraw(2000);

        current.deposit(10000);
        current.withdraw(3000);

        System.out.println("Savings Account");

        savings.displayAccountDetails();

        System.out.println("Interest : ₹" +
                savings.calculateInterest());

        System.out.println();

        System.out.println("Current Account");

        current.displayAccountDetails();

        System.out.println("Interest : ₹" +
                current.calculateInterest());
    }
}