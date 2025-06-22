package Day4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile
{
    public static void main(String[] args) 
    {
        try 
        {
            File file = new File("result.txt"); 

            Scanner reader = new Scanner(file);
            System.out.println("Contents of result.txt:");
            while (reader.hasNextLine())
            {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found. Make sure result.txt exists.");
        }
    }
}
