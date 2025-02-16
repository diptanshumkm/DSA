//----------------------------------------------**ENCAPSULATION**------------------------------------------------------------
/*
    Why Encapsulation?
    Encapsulation helps in: ✅ Data Hiding – Prevents direct access to variables, ensuring controlled access.
    ✅ Data Integrity – Protects variables from unintended modifications.
*/



public class practice4 {


    public static void main(String[] args) {
        
        BankAcc account = new BankAcc();
        System.out.println("Initial balance: "+account.getBalance());

        // account.depositAmount(500);
        // System.out.println("Current balance: "+account.getBalance());

        // account.balance = 20;
        // System.out.println("Current balance: "+account.getBalance());


    }
}

/*
    ✔ balance is private – It can't be accessed directly from outside the class.
    ✔ Only public methods (getBalance(), deposit(), withdraw()) allow access to balance – This prevents unauthorized modifications.
    ✔ Ensures valid transactions – We check conditions before modifying the balance.
*/