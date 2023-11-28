import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

class Customer {
    private String name;
    private String customerId;
    private ArrayList<Account> accounts;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}

class Bank {
    private ArrayList<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Bank
        Bank bank = new Bank();

        // Create Customer
        Customer customer = new Customer("Teja kiran", "C001");

        // Create Account
        Account account = new Account("A001", 1000.0);

        // Associate Account with Customer
        customer.addAccount(account);

        // Associate Customer with Bank
        bank.addCustomer(customer);

        // Example Usage
        System.out.println("Welcome to the Bank Management System!");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Account: " + account.getAccountNumber() + ", Balance: " + account.getBalance());

        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);

        System.out.print("Enter withdrawal amount: ");
        double withdrawalAmount = scanner.nextDouble();
        account.withdraw(withdrawalAmount);

        // Display Customer's Accounts
        ArrayList<Account> customerAccounts = customer.getAccounts();
        System.out.println("Customer's Accounts:");
        for (Account a : customerAccounts) {
            System.out.println("Account: " + a.getAccountNumber() + ", Balance: " + a.getBalance());
        }
    }
}
