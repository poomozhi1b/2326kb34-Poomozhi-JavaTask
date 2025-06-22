package task_day01;
import java.util.Scanner;
public class Leap {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter year:");
		int year =s.nextInt();
		if((year%4==0 && year%100!=0)||(year%400==0))
		{
			System.out.println("It is leap year");
		}
		else
		{
			System.out.println("It is not a leap year");
		}
		
	}

}
