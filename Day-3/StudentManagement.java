package task_day03;

import java.util.Scanner;

public class StudentManagement {

	// Student class to store data
	static class Student {
		private String name;
		private int rollNumber;
		private int[] marks = new int[3]; // 3 subjects

		// Constructor
		public Student(String name, int rollNumber) {
			this.name = name;
			this.rollNumber = rollNumber;
		}

		// Method to assign marks
		public void assignMarks(Scanner scanner) {
			System.out.println("Enter marks for 3 subjects:");
			for (int i = 0; i < 3; i++) {
				System.out.print("Subject " + (i + 1) + ": ");
				marks[i] = scanner.nextInt();
			}
		}

		// Method to display student result
		public void displayResult() {
			System.out.println("\n--- Student Result ---");
			System.out.println("Name       : " + name);
			System.out.println("Roll Number: " + rollNumber);

			int total = 0;
			System.out.println("Marks:");
			for (int i = 0; i < 3; i++) {
				System.out.println("Subject " + (i + 1) + ": " + marks[i]);
				total += marks[i];
			}

			double average = total / 3.0;
			System.out.println("Total Marks: " + total);
			System.out.println("Average    : " + average);
		}
	}

	// Main method
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Take input to create a student
		System.out.print("Enter student name: ");
		String name = scanner.nextLine();

		System.out.print("Enter roll number: ");
		int rollNumber = scanner.nextInt();

		// Create student object
		Student student = new Student(name, rollNumber);

		// Assign marks and display result
		student.assignMarks(scanner);
		student.displayResult();

		scanner.close();
	}
}
