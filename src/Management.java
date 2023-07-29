import java.util.Random;
import java.util.Scanner;

public class Management {
    Scanner input;
    Random random;
    Customer[] customers;
    private int numCustomer;
    Customer customer;

    public Management() {
        input = new Scanner(System.in);
        random = new Random();
        customers = new Customer[10];
        numCustomer = 0;
    }

    public void run() {
        int choice;
        do {
            menu();
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1 -> newCustomer();
                case 2 -> createAccount();
                case 3 -> updateAccount();
                case 4 -> deleteAccount();
                case 5 -> depositBalance();
                case 6 -> withdrawBalance();
                case 7 -> accountDetails();
                case 0 -> System.out.print("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public void menu() {
        System.out.println("======================");
        System.out.println("Bank Management Menu:");
        System.out.println("1. Register");
        System.out.println("2. Create Account");
        System.out.println("3. Update Account");
        System.out.println("4. Delete Account");
        System.out.println("5. Deposit Balance");
        System.out.println("6. Withdraw Balance");
        System.out.println("7. Account Details");
        System.out.println("0. Exit");
        System.out.println("======================");
        System.out.print("Enter you choice: ");
    }

    public void newCustomer() {
        System.out.println("\nRegister");

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        customer = new Customer(name);

        customers[numCustomer] = customer;
        numCustomer++;

        System.out.println("Registration successful.");
    }

    public Customer findCustomer(String name) {
        for (int i = 0; i < numCustomer; i++) {
            if (customers[i].getName().equalsIgnoreCase(name)) {
                return customers[i];
            }
        }
        return null;
    }

    public void createAccount() {
        System.out.println("\nCreate Account");

        System.out.print("Enter Customer Name: ");
        String name = input.nextLine();
        customer = findCustomer(name);

        if (customer != null) {
            int accountNumber;
            boolean isUnique;

            do {
                // Generate random numbers from 100 to 900
                accountNumber = 100 + random.nextInt(900);
                isUnique = true;

                for (int i = 0; i < numCustomer; i++) {
                    if (customers[i].hasAccount(accountNumber)) {
                        isUnique = false;
                        break;
                    }
                }
            } while (!isUnique);

            System.out.println("Assigned Account Number: " + accountNumber);

            System.out.print("Enter Balance: ");
            double balance = input.nextDouble();
            input.nextLine();

            System.out.println("Enter Account Type: ");
            System.out.println("1. Saving");
            System.out.println("2. Fixed");
            System.out.print("Enter your choice: ");
            int accountType = input.nextInt();
            input.nextLine();

            switch (accountType) {
                case 1 -> {
                    System.out.print("Enter Interest Rate: ");
                    double interest = input.nextDouble();
                    input.nextLine();
                    Account saving = new Saving(accountNumber, balance, interest);
                    customer.addAccount(saving);
                }
                case 2 -> {
                    System.out.print("Enter Year: ");
                    int year = input.nextInt();
                    input.nextLine();
                    Account fixed = new Fixed(accountNumber, balance, year);
                    customer.addAccount(fixed);
                }
                default -> System.out.println("Invalid Type");
            }
            System.out.println("Account creation was successful.");
        } else {
            System.out.println("Customer with name \"" + name + "\" doesn't exist. Please Register First.");
        }
    }

    public void updateAccount() {
        System.out.println("\nUpdate Account");

        System.out.print("Enter Customer Name: ");
        String name = input.nextLine();
        customer = findCustomer(name);

        System.out.print("Enter Account Number: ");
        int accountNumber = input.nextInt();
        input.nextLine();

        for (int i = 0; i < customer.accounts.length; i++) {
            if (customer.accounts[i] != null && customer.accounts[i].getAccountNumber() == accountNumber) {
                System.out.print("New Account Number: ");
                int newAccountNumber = input.nextInt();
                input.nextLine();
                customer.accounts[i].setAccountNumber(newAccountNumber);

                System.out.print("New Balance: ");
                double newBalance = input.nextInt();
                input.nextLine();
                customer.accounts[i].setBalance(newBalance);

                String getType = String.valueOf(customer.accounts[i].getClass());
                if (getType.contains("Saving")) {
                    System.out.print("New Interest Rate: ");
                    double interest = input.nextDouble();
                    input.nextLine();
                    ((Saving) customer.accounts[i]).setInterest(interest);
                } else if (getType.contains("Fixed")) {
                    System.out.print("Change Year: ");
                    int year = input.nextInt();
                    input.nextLine();
                    ((Fixed) customer.accounts[i]).setYear(year);
                }

                System.out.println("Account updated successfully.");
                break;
            }
        }
    }

    public void deleteAccount() {
        System.out.println("\nDelete Account");

        System.out.print("Enter Customer Name: ");
        String name = input.nextLine();
        customer = findCustomer(name);

        System.out.print("Enter Account Number: ");
        int accountNumber = input.nextInt();
        input.nextLine();
        customer.deleteAccount(accountNumber);
    }

    public void depositBalance() {
        System.out.println("\nDeposit Balance");

        System.out.print("Enter Customer Name: ");
        String name = input.nextLine();
        customer = findCustomer(name);

        System.out.print("Enter Account Number: ");
        int accountNumber = input.nextInt();
        input.nextLine();

        System.out.print("Enter Deposit Amount: ");
        int amount = input.nextInt();
        input.nextLine();

        customer.depositBalance(accountNumber, amount);
    }

    public void withdrawBalance() {
        System.out.println("\nWithdraw Balance");

        System.out.print("Enter Customer Name: ");
        String name = input.nextLine();
        customer = findCustomer(name);

        System.out.print("Enter Account Number: ");
        int accountNumber = input.nextInt();
        input.nextLine();

        System.out.print("Enter Withdraw Amount: ");
        int amount = input.nextInt();
        input.nextLine();

        customer.withdrawBalance(accountNumber, amount);
    }

    public void accountDetails() {
        System.out.println("\nAccount Details");

        System.out.println("----------------------");

        System.out.print("Enter Customer Name: ");
        String name = input.nextLine();
        customer = findCustomer(name);

        if (customer == null) {
            System.out.println("No customer found with the given name.");
        } else {
            customer.details();
        }

        System.out.println("----------------------");

        System.out.print("Press Enter to Continue...");
        input.nextLine();
    }
}