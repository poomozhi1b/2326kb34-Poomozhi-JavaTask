package day7;

import java.sql.*;
import java.util.Scanner;

public class InventoryApp {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String pass = "kg@123";  
        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            while (true) {
                // Display menu
                System.out.println("\n--- JDBC Inventory App ---");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Search Product by Name");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        // Add product
                        System.out.print("Enter Product ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline

                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();

                        String insertQuery = "INSERT INTO products (id, name, price) VALUES (?, ?, ?)";
                        PreparedStatement psInsert = con.prepareStatement(insertQuery);
                        psInsert.setInt(1, id);
                        psInsert.setString(2, name);
                        psInsert.setDouble(3, price);
                        psInsert.executeUpdate();

                        System.out.println("Product added successfully.");
                        break;

                    case 2:
                        // View all products
                        String selectAll = "SELECT * FROM products";
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(selectAll);

                        System.out.println("\n--- Product List ---");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") +
                                               ", Name: " + rs.getString("name") +
                                               ", Price: ₹" + rs.getDouble("price"));
                        }
                        break;

                    case 3:
                        // Search product by name
                        System.out.print("Enter product name to search: ");
                        String searchName = sc.nextLine();

                        String searchQuery = "SELECT * FROM products WHERE name = ?";
                        PreparedStatement psSearch = con.prepareStatement(searchQuery);
                        psSearch.setString(1, searchName);

                        ResultSet rsSearch = psSearch.executeQuery();

                        if (rsSearch.next()) {
                            System.out.println("Product Found:");
                            System.out.println("ID: " + rsSearch.getInt("id"));
                            System.out.println("Name: " + rsSearch.getString("name"));
                            System.out.println("Price: ₹" + rsSearch.getDouble("price"));
                        } else {
                            System.out.println("Product not found.");
                        }
                        break;

                    case 4:
                        // Exit
                        System.out.println("Exiting Inventory App.");
                        sc.close();
                        return;

                    default:
                        System.out.println(" Invalid choice. Please try again.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}