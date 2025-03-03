//----------------------------------------------**ENCAPSULATION**------------------------------------------------------------
/*
    Why Encapsulation?
    Encapsulation helps in: ✅ Data Hiding – Prevents direct access to variables, ensuring controlled access.
    ✅ Data Integrity – Protects variables from unintended modifications.
*/



public class Encapsulation {


public class BankAcc {
    
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    
    BankAcc(int accNum, String name){
        this.accountNumber = accNum;
        setName(name);
        this.balance = 0.0;
        System.out.println("Account created successfully!");
    }

    public int getAccNum(){
        return accountNumber;
    }

    public String getAccHolderName(){
        return accountHolderName;
    }

    public double getBalance(){
        return balance;
    }

    public void setName(String name){
        if (name.isEmpty()) {
            System.out.println("Name field cannot be empty");
        }else{
            this.accountHolderName= name;
        }
    }

    public void deposit(double bal){
        System.out.println("Depositing: "+ bal);
        if (bal>=0) {
            this.balance+=bal;
        }else{
            System.out.println("Balance cannot be negative");
        }
        System.out.println("New Balance: "+ this.balance);

    }

    public void withdraw(double amt){
        System.out.println("Withdrawing: "+ amt);
        if (amt <= this.balance ) {
            this.balance-=amt;
        }else{
            System.out.println("Insuffiecient balance");
        }

        System.out.println("New balance: " + this.balance);
    }

    
    public void displayAccInfo(){
        System.out.println("Account number: " + this.accountNumber);
        System.out.println("Account Holder Name: " + this.accountHolderName);
    }

}


}