package Day5;
import java.util.*;
import java.io.*;

public class StudentManagementApp {
    static ArrayList<String> studentNames = new ArrayList<>();
    static HashMap<String, ArrayList<String>> studentCourses = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Mini Student Management App ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All");
            System.out.println("6. Save to File");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: addCourse(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: displayAll(); break;
                case 6: saveToFile(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        studentNames.add(name);
        studentCourses.put(id, new ArrayList<>());
        System.out.println("Student added.");
    }

    static void addCourse() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        if (studentCourses.containsKey(id)) {
            System.out.print("Enter Course Name: ");
            String course = sc.nextLine();
            studentCourses.get(id).add(course);
            System.out.println("Course added.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    static void searchStudent() {
        System.out.print("Enter Student ID to Search: ");
        String id = sc.nextLine();
        if (studentCourses.containsKey(id)) {
            System.out.println("Courses for ID " + id + ": " + studentCourses.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        String id = sc.nextLine();
        if (studentCourses.containsKey(id)) {
            studentCourses.remove(id);
            System.out.println("Student deleted.");
        } else {
            System.out.println("ID not found.");
        }
    }

    static void displayAll() {
        System.out.println("\n--- All Students and Courses ---");
        int i = 0;
        for (Map.Entry<String, ArrayList<String>> entry : studentCourses.entrySet()) {
            String id = entry.getKey();
            String name = (i < studentNames.size()) ? studentNames.get(i) : "Unknown";
            ArrayList<String> courses = entry.getValue();
            System.out.println("Name: " + name + " | ID: " + id + " | Courses: " + courses);
            i++;
        }
    }

    static void saveToFile() {
        try {
            FileWriter fw = new FileWriter("courses.txt");
            for (Map.Entry<String, ArrayList<String>> entry : studentCourses.entrySet()) {
                fw.write("ID: " + entry.getKey() + " -> Courses: " + entry.getValue() + "\n");
            }
            fw.close();
            System.out.println("Saved to courses.txt");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}