package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import libs.StdIn;

public class matrixMul {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = StdIn.readInt();
        int a[][] = new int[n][n];
        
		String item = StdIn.readString();
		while (!item.equals("EOF"))
		{
	        for(int a_i=0; a_i < n; a_i++){
	            for(int a_j=0; a_j < n; a_j++){
	                a[a_i][a_j] = Integer.parseInt(item);
	                item = StdIn.readString();                
	            }
	        }
	         
		}
		
        

    	
    	int diag12 =0;
    	int diag21 =0;    	
    	int i = 0 ,j =0 ;        
        
    	for( ; i < a.length && j < a[i].length ;i++ , j++)
    		diag12 += a[i][j];

    	
    	for(i=0 , j=a[i].length-1;   i < a.length && j >= 0  ;i++ , j--)
    	{
    		System.out.println(a[j][i]);
    		diag21 += a[i][j];
    	}
    	System.out.println(diag12 +"  "+ diag21);
    	System.out.println(Math.abs(diag12-diag21));
    }
    

}
