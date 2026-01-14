package hackerrank;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class candies {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] c = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}

		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int c_i = 0; c_i < n; c_i++) {
			arr.add(c[c_i]);
		}
		
		Collections.sort(arr);
		int minValue = arr.get(0);
//		for (int i = 1; i < c.length; i++) {
//			if (c[i] < minValue) {
//				minValue = c[i];
//			}
//		}

		int MaxHap = 2 * minValue;
		int maxHapFactor = minValue ;
		if(arr.contains(MaxHap))
			maxHapFactor = MaxHap;
		
		int ways = 0;
		for(int e : arr)
		{
			if(minValue == e)
				ways++;
			
			if(MaxHap <= e)
				maxHapFactor = MaxHap;
			
				
		}
		
		
		System.out.println(maxHapFactor+ " "+ways);
		
		
		

	}

}
