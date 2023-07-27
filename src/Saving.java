public class Saving extends Account {
    public double interest;

    public Saving() {
    }

    public Saving(int accountNumber, double balance, double interest) {
        super(accountNumber, balance);
        this.interest = interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

    public void details() {
        super.details();
        System.out.println("Account Type: Saving\nInterest Rate: " + interest + "%");
    }
}
