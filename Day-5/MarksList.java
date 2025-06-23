
package Day5;

import java.util.HashMap;
import java.util.Map;

public class MarksList {

    public static void main(String[] args) {
      
        HashMap<String, Integer> studentMarks = new HashMap<>();

       
        studentMarks.put("Alice", 85);
        studentMarks.put("Bob", 90);
        studentMarks.put("Charlie", 78);
        studentMarks.put("David", 92);

       
        int totalMarks = 0;
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            totalMarks += entry.getValue();
        }

       
        double averageMarks = totalMarks / (double) studentMarks.size();

     
        System.out.println("Student Marks:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        
        System.out.println("\nAverage Marks: " + averageMarks);
    }
}
