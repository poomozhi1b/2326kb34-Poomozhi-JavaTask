package day6;
class BankAccount {
    int balance = 1000;

    synchronized void withdraw(String threadName, int amount) {
        if (amount <= balance) {
            System.out.println(threadName + " is withdrawing " + amount);
            try {
                Thread.sleep(1000); // Simulate delay
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            balance -= amount;
            System.out.println(threadName + " withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println(threadName + " failed to withdraw. Insufficient balance: " + balance);
        }
    }
}

class Customer extends Thread {
    BankAccount account;
    String name;
    int amount;

    Customer(BankAccount account, String name, int amount) {
        this.account = account;
        this.name = name;
        this.amount = amount;
    }

    public void run() {
        account.withdraw(name, amount);
    }
}

public class BankMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Customer c1 = new Customer(account, "Thread-A", 700);
        Customer c2 = new Customer(account, "Thread-B", 400);

        c1.start();
        c2.start();
    }
}