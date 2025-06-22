package Day4;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriting {
    public static void main(String[] args) 
    {
        String text = "Hello World\nWelcome to Java Programming\nThis is line 3";

        String filePath = "output.txt"; // or use absolute path here

        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        System.out.println("Attempting to write file at: " + filePath);

        String[] lines = text.split("\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            for (String line : lines)
            {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File written successfully to " + filePath);
        }
        catch (IOException e)
        {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
