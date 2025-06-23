package Day5;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentList {

    public static void main(String[] args) {
      
        ArrayList<String> students = new ArrayList<>();

        students.add("Archana");
        students.add("Arthi");
        students.add("Pooja");
        students.add("Thenisha");

      
        Iterator<String> iterator = students.iterator();

   
        System.out.println("List of Students:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}