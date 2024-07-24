package Projects;

import java.util.InputMismatchException;
import java.util.Scanner;

// Class representing a Bank Account
class BankAccount {
    private double balance;

    // Constructor to initialize the account with an initial balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
            System.out.println("New balance: " + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }

    // Method to check the current balance
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}

// Class representing an ATM
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize the ATM with a BankAccount
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu and handle user input
    public void displayMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        // Check balance option
                        account.checkBalance();
                        break;
                    case 2:
                        // Deposit option
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 3:
                        // Withdraw option
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 4:
                        // Exit option
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    // Main method to create a BankAccount and an ATM, and start the ATM menu
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.0); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}