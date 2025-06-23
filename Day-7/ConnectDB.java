package day7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "";
        String pass = "";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected Successfully!");
            con.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}