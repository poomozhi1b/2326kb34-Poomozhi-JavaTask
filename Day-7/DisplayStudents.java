package day7;

import java.sql.*;

public class DisplayStudents {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String pass = "kg@123";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("------------------");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Display Failed: " + e.getMessage());
        }
    }
}