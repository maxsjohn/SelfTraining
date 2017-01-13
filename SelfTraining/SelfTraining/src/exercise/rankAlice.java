package exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class rankAlice {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
         * 
         */

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        Scanner s = new Scanner(System.in);
      
        
        for( int i= 0; i< N; i++)
        {

        	line = br.readLine();
        	int students = Integer.parseInt(line);
        	int  [] arr = new int[students];
        	int  [] actRank = new int[students];
        	for( int j= 0; j< students; j++)
        	{
        		arr[j] = s.nextInt(); 
        		actRank[j]= j+1;
        	}
       		int thinking  = calculateThinking(arr,actRank);
    		System.out.println(thinking);        	
        	
        }

       
    }

	private static int calculateThinking(int[] arr, int[] actRank) {
		// TODO Auto-generated method stub
		int sum = 0;
		int diff ;
		Arrays.sort(arr);
		for(int i=0 ; i< arr.length;i++)
		{
			diff = actRank[i] - arr[i];
			sum = sum + diff ;
		}
		
		return sum;
	}
}
