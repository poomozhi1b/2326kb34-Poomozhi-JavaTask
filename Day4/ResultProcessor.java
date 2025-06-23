package Day4;

import java.io.*;

public class ResultProcessor
{

    public static void main(String[] args)
    {
        String inputFile = "marks.txt";
        String outputFile = "results.txt";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) 
        {
            String line;
            writer.write("Name,Average,Grade\n");

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts.length != 4) continue;

                String name = parts[0];
                int mark1 = Integer.parseInt(parts[1]);
                int mark2 = Integer.parseInt(parts[2]);
                int mark3 = Integer.parseInt(parts[3]);

                double average = (mark1 + mark2 + mark3) / 3.0;
                String grade = gradeFromAverage(average);

                writer.write(String.format("%s,%.2f,%s\n", name, average, grade));
            }

            System.out.println("Processing complete. Results saved to " + outputFile);

        } catch (IOException e)
        {
            System.err.println("File error: " + e.getMessage());
        }
    }

    private static String gradeFromAverage(double average) 
    {
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }
}

