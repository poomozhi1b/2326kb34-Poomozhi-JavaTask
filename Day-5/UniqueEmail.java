
package Day5;

import java.util.HashSet;

public class UniqueEmail {

    public static void main(String[] args) {
        
        HashSet<String> emailAddresses = new HashSet<>();

        
        emailAddresses.add("alice@example.com");
        emailAddresses.add("bob@example.com");
        emailAddresses.add("charlie@example.com");
        emailAddresses.add("alice@example.com");  

       
        System.out.println("Unique Email Addresses:");
        for (String email : emailAddresses) {
            System.out.println(email);
        }
    }
}
