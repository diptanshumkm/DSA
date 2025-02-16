public class BankAcc {
    private double balance = 0;

    // Existing constructor
    public BankAcc(int x) {
        if (x > 0) {
            this.balance = x;
        }
    }

    // New constructor with one argument
    public BankAcc(double initialBalance) {
        if (initialBalance > 0) {
            this.balance = initialBalance;
        }
    }

    double getBalance() {
        return balance;
    }

    public void depositAmount(double deposit) {
        if (deposit > 0) {
            balance += deposit;
            System.out.println("Deposited amount: " + deposit);
        } else {
            System.out.println("Invalid deposit amount...");
        }
    }

    public static void main(String[] args){

        BankAcc acc = new BankAcc(100);
        System.out.println("Initial balance: "+acc.getBalance());
        

    }
}