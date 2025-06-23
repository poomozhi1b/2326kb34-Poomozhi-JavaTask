package task_day02;
import java.util.Scanner;
public class Analyzer {
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.println("STRING ANALYZER");
			System.out.println("Ente a Sentence:");
			String in=s.nextLine();
			String[] words=in.split(" ");
			int wordcount=words.length;
			String reversed=" ";
			for(int i=in.length()-1;i>=0;i--)
			{
				reversed+=in.charAt(i);
			}
			String largest=words[0];
			for(String word:words)
			{
				if(word.length()>largest.length())
				{
					largest=word;
					
				}
			}
			
			System.out.println("character count is:"+in.length());
			System.out.println("Word count:"+wordcount);
			System.out.println("Reversed string:"+reversed);
			System.out.println("largest word:"+largest);
			
					
			
				
	}

}
