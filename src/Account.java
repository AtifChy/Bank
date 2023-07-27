public class Account {
    private int accountNumber;
    private double balance;

    public Account() {
        System.out.println("Empty Account");
    }

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        System.out.println("Parameterized Account");
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void details() {
        System.out.println("\nAccount Number: " + accountNumber + "\nBalance: " + balance);
    }
}
