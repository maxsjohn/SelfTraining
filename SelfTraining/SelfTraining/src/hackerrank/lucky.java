package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class lucky {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long n = in.nextLong();
            checkLucky(n);
        }
        
    }
    
	private static void checkLucky(long currentInt)    
    {
        boolean  passed = false ;
        for(int i=0 ; i<= currentInt; i++)
        {
        	if (splitAndCheck(currentInt-i,i) == true)
        	{
        		passed = true;
        	}
        		
        }
        if(passed == true)
    	System.out.println("Yes");
        else
    		System.out.println("No"); 	   	
    }
  

	private static boolean splitAndCheck(long first, long second) {
		// TODO Auto-generated method stub
		
		long firstMod7  = first%7;
		long firstMod4  = first%4;
		long secondMod7  = second%7;
		long secondMod4  = second%4;
		
		if(firstMod7 ==0 && secondMod7 == 0)
			return true;
			
		if(firstMod7 ==0 && secondMod4 == 0)
			return true;
		
		if(firstMod4 ==0 && secondMod7 == 0)
			return true;
		
		if(firstMod4 ==0 && secondMod4 == 0)
			return true;		
		
		return false;
	}
}