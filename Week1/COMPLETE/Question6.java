import java.util.Scanner;


public class Question6 
{
	public static void main(String[] args)
	{
		String word;
		int x, y;
		char c;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please input a string: ");
		word = in.nextLine();
		y = word.length();
		
		for(int i = 0; i < y; i++)
		{
			c = word.charAt(0);
			for(int j = 0; j < word.length(); j++)
			{
				if (c > word.charAt(j))
				{
					c = word.charAt(j);
				}
			}
			
			x = word.indexOf(c);
			word = word.substring(0, x) + word.substring(x+1);	
			System.out.println(c);
			
		}
	}
}
