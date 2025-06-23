package Day4;

import java.io.*;
import java.util.*;

public class EmployeeRecord {

    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Employee Record System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEmployee(scanner);
                case 2 -> viewEmployees();
                case 3 -> updateEmployee(scanner);
                case 4 -> deleteEmployee(scanner);
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Salary: ");
        String salary = scanner.nextLine();

        String record = id + "," + name + "," + department + "," + salary;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(record);
            writer.newLine();
            System.out.println("Employee added.");
        } catch (IOException e) {
            System.err.println("Error writing file.");
        }
    }

    private static void viewEmployees() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nID\tName\t\tDepartment\tSalary");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.printf("%s\t%s\t\t%s\t\t%s\n", data[0], data[1], data[2], data[3]);
            }
        } catch (IOException e) {
            System.err.println("Error reading file.");
        }
    }

    private static void updateEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID to update: ");
        String idToUpdate = scanner.nextLine();

        List<String> records = new ArrayList<>();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(idToUpdate)) {
                    found = true;

                    System.out.print("Enter new Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter new Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter new Salary: ");
                    String salary = scanner.nextLine();

                    records.add(idToUpdate + "," + name + "," + department + "," + salary);
                } else {
                    records.add(line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file.");
        }

        if (found) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String record : records) {
                    writer.write(record);
                    writer.newLine();
                }
                System.out.println("Employee updated.");
            } catch (IOException e) {
                System.err.println("Error writing file.");
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Enter Employee ID to delete: ");
        String idToDelete = scanner.nextLine();

        List<String> records = new ArrayList<>();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (!data[0].equals(idToDelete)) {
                    records.add(line);
                } else {
                    found = true;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file.");
        }

        if (found) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String record : records) {
                    writer.write(record);
                    writer.newLine();
                }
                System.out.println("Employee deleted.");
            } catch (IOException e) {
                System.err.println("Error writing file.");
            }
        } else {
            System.out.println("Employee not found.");
        }
    }
}
