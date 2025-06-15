package task_day02;
import java.util.Scanner;
public class Splitwords 
{
public static void main(String[] args)
{
	//Spliting sentence into words
	Scanner r = new Scanner(System.in);
	System.out.println("Enter a sentence");
	String a = r.nextLine();
	String[] words=a.split(" ");
	for(String word:words)
	{
		System.out.println(word);
	}
	
}
}
