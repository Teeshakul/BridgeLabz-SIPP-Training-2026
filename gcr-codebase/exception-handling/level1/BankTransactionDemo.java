class InsufficientBalanceException extends Exception{

    InsufficientBalanceException(String msg){
        super(msg);
    }
}

class BankAccount{

    double balance=5000;

    void withdraw(double amount)
            throws InsufficientBalanceException{

        if(amount<0)
            throw new IllegalArgumentException("Invalid amount!");

        if(amount>balance)
            throw new InsufficientBalanceException("Insufficient balance!");

        balance-=amount;

        System.out.println("Withdrawal successful, new balance: "+balance);
    }
}

public class BankTransactionDemo{

    public static void main(String[] args){

        BankAccount b=new BankAccount();

        try{

            b.withdraw(2000);

        }
        catch(InsufficientBalanceException | IllegalArgumentException e){

            System.out.println(e.getMessage());
        }
    }
}