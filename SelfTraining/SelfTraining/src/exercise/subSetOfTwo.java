package exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;
*/

class subSetOfTwo {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        long [] input = new long[N];
        
        for(int i=0; i<input.length ;i++)
        {
        	line = br.readLine();
        	input[i] = Integer.parseInt(line);
        }
        
        for(int i=0; i<input.length ;i++)
        {
        	long NumberofWays = processForTwosSunset(input[i]);
        	System.out.println(NumberofWays);
        	
        }        
        
       
    }

	private static long processForTwosSunset(long input) {
		// TODO Auto-generated method stub
		String binary= "";
		
		binary =  Long.toBinaryString(input);
		binary ="0"+binary;
		int N = binary.length();
		char[] inputArray = binary.toCharArray();

		for(int i =(inputArray.length -1) ; i >=0 ; i-- )
		{
			
			if(inputArray[i] == '0' )
			{
				inputArray[i] = '1';
				break;
			}
		}
				long result =0 ;
//		System.out.println(String.valueOf(inputArray));
		int sub = inputArray.length -1;
		for(int i =sub ; i >=0 ; i-- )
		{
		//	System.out.println(Math.pow(2, sub-i));
			if(inputArray[i] == '1')
			result = (long) (result + Math.pow(2, sub-i));
		}
		
		
		return result;
	}
}