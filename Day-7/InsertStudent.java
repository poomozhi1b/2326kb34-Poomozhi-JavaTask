package day7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStudent {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String pass = "kg@123"; 

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            String query = "INSERT INTO students (id, name, course) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);

           
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course Name: ");
            String course = sc.nextLine();

            
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, course);

          
            int rows = stmt.executeUpdate();
            System.out.println("✅ " + rows + " row(s) inserted.");

            con.close();
        } catch (SQLException e) {
            System.out.println("❌ Insert Failed: " + e.getMessage());
        }

        sc.close(); 
    }
}