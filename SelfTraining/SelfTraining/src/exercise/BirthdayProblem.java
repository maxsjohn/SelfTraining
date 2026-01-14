package exercise;

import Hashes.HashMap;
import libs.StdRandom;

public class BirthdayProblem {
	
	static class value{
		public value(int counter) {
			
			countPast = counter;
			// TODO Auto-generated constructor stub
		}
		int countPast = 0;
		boolean found = false  ;
	}
	
	
	public static void main(String[] args)
	{
		if(args[0].isEmpty())
		{
			System.out.println("Need input in command line");
			return;
		}
		
		int N;
		HashMap<Integer, value> hashed = new HashMap<Integer , value>();		
		N = Integer.parseInt(args[0]);
		int count  = N ;
		int counter =0 ;
		float probSum = 0;
		
		while(count != 0)
		{
			counter++ ;
			int genN = StdRandom.uniform(0, N);
			if(hashed.containsKey(genN) && hashed.get(genN).found == false)
			{
				count--;
				int oldCounter =  hashed.get(genN).countPast;
				float prob = (float)(counter - oldCounter);
				hashed.get(genN).found = true;
				System.out.println(counter - oldCounter);
				probSum+=prob;
				
			}	
			else
			{
				value v = new value(counter);
				hashed.put(genN, v);				
			}

					
				
		}
		
		System.out.println("emperical value is " + probSum/N );
		System.out.println("Calculate value sqrtpi*N/2 = " + Math.sqrt((Math.PI*N/2)) );

		
		
	}

}
