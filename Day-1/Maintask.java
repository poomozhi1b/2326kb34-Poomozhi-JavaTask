package task_day01;
import java.util.Scanner;
public class Maintask
{
	public static int add(int a,int b)
	{
		return a+b;
	}
	public static int sub(int a,int b)
	{
		return a-b;
	}
	public static int mul(int a,int b)
	{
		return a*b;
	}
	public static float div(int a,int b)
	{
		return (float) a/b;
	}
	public static void main(String[] args)
	{
		Scanner p = new Scanner(System.in);
		System.out.println("***Menu driven calculator***");
		System.out.println("Enter number 1:");
		int num1=p.nextInt();
		System.out.println("Enter number 2:");
		int num2=p.nextInt();
		System.out.println("1.Addition");
		System.out.println("2.Subtraction");
		System.out.println("3.Multiplication");
		System.out.println("4.Division");
		System.out.println("Enter your choice:");
		int choice=p.nextInt();
		switch(choice)
		{
		case 1:
		System.out.println("The result is:"+add(num1,num2));
		break;
		case 2:
		System.out.println("The result is:"+sub(num1,num2));
		break;
		case 3:
		System.out.println("The result is:"+mul(num1,num2));
		break;
		case 4:
		System.out.println("The result is:"+div(num1,num2));
		break;
		default:
			System.out.println("Invalid Choice");
		}
		
	}
	

}
