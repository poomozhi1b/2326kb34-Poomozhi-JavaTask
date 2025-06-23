package day6;
import java.lang.Thread;
class NumberPrinter extends Thread{
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println("Number:"+i);
		}
	}
	public static void main(String[] args)
	{
		NumberPrinter t1 = new NumberPrinter();
		t1.start();
	}

}
