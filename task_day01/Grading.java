package task_day01;
import java.util.Scanner;
public class Grading {
	public static String grading(double avg)
	{
		if(avg >= 90)
			return "A+";
		else if(avg >= 75)
			return "B+";
		else if(avg >= 45)
			return "C+";
		else if(avg >= 30)
			return "D+";
		else return"Fail";
		
	}
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
	    System.out.println("Enter Name:");
	    String name = s.nextLine();
	    System.out.println("Enter Mark1:");
	    int mark1 = s.nextInt();
	    System.out.println("Enter Mark2:");
	    int mark2 = s.nextInt();
	    System.out.println("Enter Mark3:");
	    int mark3 = s.nextInt();
	    System.out.println("Student name is:"+name);
	    System.out.println("Mark1:"+mark1);
	    System.out.println("Mark2:"+mark2);
	    System.out.println("Mark3:"+mark3);
	    float avg=(mark1+mark2+mark3)/3.0f;
	    System.out.println("The average is:"+avg);
	    String rank = grading(avg);
	    System.out.println("The Grade is:"+rank);
	  
	    
	
	}
	
	
	
}
