package task_day03;

import java.util.Scanner;

public class BankAccountDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create account
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit: $");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(name, initialBalance);
        System.out.println("\nAccount created for " + account.getAccountHolder());

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: $");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: $");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                }
                case 3 -> account.checkBalance();
                case 4 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice. Please Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
