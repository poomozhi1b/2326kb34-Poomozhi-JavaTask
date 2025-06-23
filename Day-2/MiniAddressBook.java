package task_day02;
import java.util.Scanner;

public class MiniAddressBook {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String[] addressBook = new String[3];

        
        System.out.println("Welcome to Mini Address Book");
        for (int i = 0; i < addressBook.length; i++) {
            System.out.println("Enter details for Contact " + (i + 1));
            
            System.out.print("Name: ");
            String name = sc.nextLine();
            
            System.out.print("Phone: ");
            String phone = sc.nextLine();
            
            System.out.print("City: ");
            String city = sc.nextLine();

           
            addressBook[i] = "Name: " + name + ", Phone: " + phone + ", City: " + city;
        }

        
        System.out.println(" Your Address Book:");
        for (int i = 0; i < addressBook.length; i++) {
            System.out.println((i + 1) + ". " + addressBook[i]);
        }
        sc.close();

    }
}