package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import libs.StdIn;

public class PosNegZero {

    public static void main(String[] args) {

    	
        int n=8; 
        
        
        String s="";       
       	for(int j=0;j <= n;j++)
        {
            for(int i=0;i<n;i++)
        	{
        		if(i>= n-j)
                	s+="#";
        		else
        			s+=" ";
        		

        	}
            if((j != 0) == true)
    		System.out.println(s);
    		s="";

        }
              
        
    }
}
