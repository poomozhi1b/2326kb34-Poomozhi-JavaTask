package Day5;
import java.util.*;

public class StudentCourseEnrollment {
    static ArrayList<String> students = new ArrayList<>();
    static HashMap<String, ArrayList<String>> courseMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Course Enrollment ---");
            System.out.println("1. Add Student");
            System.out.println("2. Assign Course");
            System.out.println("3. Display Students and Courses");
            System.out.println("4. Remove Student");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1: addStudent(); break;
                case 2: assignCourse(); break;
                case 3: display(); break;
                case 4: removeStudent(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        students.add(name);
        courseMap.put(name, new ArrayList<>());
        System.out.println("Student added.");
    }

    static void assignCourse() {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        if (courseMap.containsKey(name)) {
            System.out.print("Enter Course to Assign: ");
            String course = sc.nextLine();
            courseMap.get(name).add(course);
            System.out.println("Course assigned.");
        } else {
            System.out.println("Student not found!");
        }
    }

    static void display() {
        System.out.println("\n--- Students and Their Courses ---");
        Iterator<Map.Entry<String, ArrayList<String>>> iterator = courseMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> entry = iterator.next();
            System.out.println("Student: " + entry.getKey() + " - Courses: " + entry.getValue());
        }
    }

    static void removeStudent() {
        System.out.print("Enter Student Name to Remove: ");
        String name = sc.nextLine();
        if (students.contains(name)) {
            students.remove(name);
            courseMap.remove(name);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found!");
        }
    }
}