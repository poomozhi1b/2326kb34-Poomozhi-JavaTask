package task_day02;

public class Reverse 
{
	public static void main(String[] args)
	{
		
	//reversing an array of numbers
	int[] num= {10,20,30,40,50};
	System.out.println("\n The original order is:");
	for(int i:num)
	{
		System.out.print(" "+i);
	}
	System.out.println("\n The reverse order is:");
	for(int i=num.length-1;i>=0;i--)
	{
		System.out.print(" "+num[i]);
	}
    }

}
