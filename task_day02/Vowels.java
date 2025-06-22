package task_day02;
import java.util.Scanner;
public class Vowels {
	public static void main(String[] args)
	{
		//counting vowels and consonants in a string
		int vowels=0;
		int consonants=0;
		Scanner n = new Scanner(System.in);
		System.out.println("Enter a string");
		String a =n.nextLine();
		String str = a.toLowerCase();
		for(int i=0;i<a.length();i++)
		{
			char chr=a.charAt(i);
			if(chr=='a'||chr=='e'||chr=='i'||chr=='o'||chr=='u')
				{
				vowels++;		
				}
			else
			{
				consonants++;
			}
		}
		System.out.println("Nuber of vowels are:"+vowels);
		System.out.println("Nuber of consonants are:"+consonants);
		
	}

}
