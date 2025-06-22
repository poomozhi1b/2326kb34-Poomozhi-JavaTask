package Day4;

import java.util.Scanner;


public class HandleDivideByZero 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);

		int number1, number2, result = 0;

		System.out.print("Enter the first number: ");
		number1 = scanner.nextInt();

		System.out.print("Enter the second number: ");
		number2 = scanner.nextInt();

		try 
		{
			result = number1 / number2;
			System.out.println("Result: " + result);
		} 
		catch (ArithmeticException e) 
		{
			System.out.println("Error: Cannot divide by zero");
		}

		scanner.close();
	}
}
