package task_day03;
import java.util.Scanner;

public class SumOverload {

    // Overloaded method: sum of two integers
    public int sum(int a, int b) {
        return a + b;
    }

    // Overloaded method: sum of two doubles
    public double sum(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SumOverload obj = new SumOverload();

        System.out.println("Choose type of numbers to add:");
        System.out.println("1. Integers");
        System.out.println("2. Doubles");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // Get integer inputs
            System.out.print("Enter first integer: ");
            int a = scanner.nextInt();
            System.out.print("Enter second integer: ");
            int b = scanner.nextInt();

            int result = obj.sum(a, b);
            System.out.println("Sum of integers: " + result);

        } else if (choice == 2) {
            // Get double inputs
            System.out.print("Enter first double: ");
            double x = scanner.nextDouble();
            System.out.print("Enter second double: ");
            double y = scanner.nextDouble();

            double result = obj.sum(x, y);
            System.out.println("Sum of doubles: " + result);

        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
