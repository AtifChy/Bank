public class Customer {
    private String name;
    protected Account[] accounts;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
        accounts = new Account[5];
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        boolean isFull = true;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                isFull = false;
                break;
            }
        }

        if (isFull) {
            System.out.println("Account Creation Failed. Maximum number of accounts already created.");
        }
    }

    public boolean hasAccount(int accountNumber) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }

    public void deleteAccount(int accountNumber) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                accounts[i] = null;
                break;
            }
        }
    }

    public void depositBalance(int accountNumber, double amount) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                double balance = accounts[i].getBalance() + amount;
                accounts[i].setBalance(balance);
                break;
            }
        }
    }

    public void withdrawBalance(int accountNumber, double amount) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber && accounts[i].getBalance() >= amount) {
                double balance = accounts[i].getBalance() - amount;
                accounts[i].setBalance(balance);
                System.out.println("Successfully withdrawn: " + amount);
                break;
            } else if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber && accounts[i].getBalance() < amount) {
                System.out.println("Invalid Amount.");
            }
        }
    }

    public void details() {
        System.out.println("Name: " + name);
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                accounts[i].details();
            }
        }
    }
}
