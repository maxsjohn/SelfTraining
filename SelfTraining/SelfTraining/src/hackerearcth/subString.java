package hackerearcth;

import java.util.Scanner;

public class subString {

	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int  length = scan.nextInt();
		int  N = scan.nextInt();
		String input = scan.next();	
	  	
		for(int i=0; i<N;i++)
		{
			long  l = scan.nextLong();
			long  r = scan.nextLong();		
	
			String processStr  = input.substring((int)(l-1), (int)r);
			System.out.println(processStr);
	       System.out.println(calculateDeletions(processStr));
	
			
		}
		
	}
	
	public static int calculateDeletions(String processStr ) {
		int count = 0;
	     int[] arr = new int[26];	
		for (int i = 0; i < processStr.length(); i++) {

	
			if ((++arr[(Character.getNumericValue(processStr.charAt(i)) - Character.getNumericValue('a'))]) > 1)
				count++;

		}
		return count;
	}
		
	
}
