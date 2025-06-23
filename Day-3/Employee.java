package task_day03;
import java.util.Scanner;

public class Employee {

    // Inner class Person
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    // Inner class EmployeeDetails extends Person
    static class EmployeeDetails extends Person {
        private double basicSalary;
        private double bonus;

        public EmployeeDetails(String name, int age, double basicSalary, double bonus) {
            super(name, age);
            this.basicSalary = basicSalary;
            this.bonus = bonus;
        }

        public double calculateSalary() {
            return basicSalary + bonus;
        }

        public double getBasicSalary() {
            return basicSalary;
        }

        public double getBonus() {
            return bonus;
        }
    }

    // main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();

        System.out.print("Enter basic salary: ");
        double basicSalary = scanner.nextDouble();

        System.out.print("Enter bonus: ");
        double bonus = scanner.nextDouble();

        // Create object
        EmployeeDetails emp = new EmployeeDetails(name, age, basicSalary, bonus);

        // Display details
        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + emp.getName());
        System.out.println("Age: " + emp.getAge());
        System.out.println("Basic Salary: " + emp.getBasicSalary());
        System.out.println("Bonus: " + emp.getBonus());
        System.out.println("Total Salary: " + emp.calculateSalary());

        scanner.close();
    }
}
