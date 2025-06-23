package day7;

import java.sql.*;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String pass = "kg@123";  

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            while (true) {
                System.out.println("\n--- Student DB Manager ---");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search by ID");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Course: ");
                        String course = sc.nextLine();

                        PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES (?, ?, ?)");
                        ps.setInt(1, id);
                        ps.setString(2, name);
                        ps.setString(3, course);
                        ps.executeUpdate();
                        System.out.println("Student added.");
                        break;

                    case 2:
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM students");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("course"));
                        }
                        break;

                    case 3:
                        System.out.print("Enter Student ID: ");
                        int sid = sc.nextInt();
                        PreparedStatement ps2 = con.prepareStatement("SELECT * FROM students WHERE id = ?");
                        ps2.setInt(1, sid);
                        ResultSet rs2 = ps2.executeQuery();
                        if (rs2.next()) {
                            System.out.println("Name: " + rs2.getString("name") + ", Course: " + rs2.getString("course"));
                        } else {
                            System.out.println("No student found.");
                        }
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }

        sc.close();
    }
}