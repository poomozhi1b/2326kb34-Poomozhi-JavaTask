package task_day03;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    // Book class
    static class Book {
        int id;
        String title;
        String author;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        void display() {
            System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. View All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();

                    books.add(new Book(id, title, author));
                    System.out.println("Book added successfully.");
                }

                case 2 -> {
                    System.out.print("Enter Book ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    boolean removed = false;

                    for (int i = 0; i < books.size(); i++) {
                        if (books.get(i).id == idToRemove) {
                            books.remove(i);
                            removed = true;
                            System.out.println("Book removed successfully.");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Book not found.");
                    }
                }

                case 3 -> {
                    System.out.print("Enter Book ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    boolean found = false;

                    for (Book book : books) {
                        if (book.id == idToUpdate) {
                            System.out.print("Enter new title: ");
                            book.title = scanner.nextLine();
                            System.out.print("Enter new author: ");
                            book.author = scanner.nextLine();
                            System.out.println("Book updated successfully.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found.");
                    }
                }

                case 4 -> {
                    if (books.isEmpty()) {
                        System.out.println("No books in the library.");
                    } else {
                        System.out.println("\n--- Book List ---");
                        for (Book book : books) {
                            book.display();
                        }
                    }
                }

                case 5 -> System.out.println("Exiting Library System. Goodbye!");

                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
