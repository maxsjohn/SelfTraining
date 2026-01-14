package hackerearcth;

import java.util.HashMap;
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

class Value{
	public Value(int index, int a) {
		// TODO Auto-generated constructor stub
		LeastIndex =index;
		diff = a;
		
	}
	int LeastIndex = 0;
	int diff =0; 
}

class monkShops {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        //Scanner*/
    	HashMap<Integer, Value> hash = new HashMap<Integer, Value>();
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int a = 0;
        int highest = 0;
        for (int i = 0; i < N; i++) {
        
        	a = s.nextInt();
        	int diff = putAndCalculate(hash ,i ,a);
        	
        	if(diff > highest)
        		highest = diff;       	
        }
        
        if(highest ==0)
        	highest = -1;
        	
        System.out.println(highest);
    }

	private static int putAndCalculate(HashMap<Integer, Value> hash, int index , int a) {
		
		if(hash.containsKey(a) == false){
			Value  v = new Value(index, a);
			hash.put(a, v);
			return 0;
		}
		Value v = hash.get(a)  ;
		int diff = index - v.LeastIndex;
		hash.put(a,new Value(v.LeastIndex,diff ) )  ;
		return diff;
	}
}
