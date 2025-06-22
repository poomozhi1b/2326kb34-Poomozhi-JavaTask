package task_day03;

public class BankAccount {
	private String accountHolder;
	private double balance;

	// Constructor
	public BankAccount(String accountHolder, double initialBalance) {
		this.accountHolder = accountHolder;
		this.balance = initialBalance;
	}

	// Deposit method
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited: $" + amount);
		} else {
			System.out.println("Deposit must be positive.");
		}
	}

	// Withdraw method
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrew: $" + amount);
		} else {
			System.out.println("Insufficient funds or invalid amount.");
		}
	}

	// Check balance method
	public void checkBalance() {
		System.out.println("Current Balance: $" + balance);
	}

	public String getAccountHolder() {
		return accountHolder;
	}
}
