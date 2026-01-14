package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class altChars {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner scan = new Scanner(System.in);
    	int testCases = Integer.parseInt(scan.nextLine());
    	String[] inputStr = new String[testCases];
    	
    	for(int i=0 ; i< testCases ;i++)
    		inputStr[i]= scan.nextLine();
    	
    	


    	
    	for(int i=0 ; i< testCases ;i++)
    	{
    		String answer1 = "";
    		String answer2= "";
        	int evenIndex = 0;
        	int oddIndex = (inputStr[i].length())/2;
	    	for(int strIndex=0 ;strIndex <inputStr[i].length();strIndex++)
	    	{
	    		if(strIndex%2 == 0)
	    		{
	    			answer1+=(inputStr[i].charAt(strIndex));
	   			
	    		}
	    		else
	    			answer2+=(inputStr[i].charAt(strIndex));
	    		
	    	}
	    	System.out.println(answer1+" "+answer2);

    		
    	}

    	
    }

}