public class Fixed extends Account {
    private int year;

    public Fixed() {
    }

    public Fixed(int accountNumber, double balance, int year) {
        super(accountNumber, balance);
        this.year = year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void details() {
        super.details();
        System.out.println("Account Type: Fixed\nYear: " + year);
    }
}
