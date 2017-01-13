package hackerrank;

import java.io.*;
import java.util.*;

public class reverseShuffle {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        int[] arr = new int[26];

        for (int i = 0; i < input.length(); i++)
        {
            arr[(Character.getNumericValue(input.charAt(i)) - Character.getNumericValue('a'))]++;
        }

        String output = "";        
        for (int i = 0; i < arr.length; i++)
        {
           
            int times = arr[i] / 2;
            while (times != 0)
            {
                int num = 97 + i;
                output+=((char) (num));
          
                times--;
            }
   
           
        }
       if(output.isEmpty() != true)
         System.out.println(output);
        
        for (int i = 0; i < arr.length; i++)
        {         
        	arr[i] = arr[i] / 2;
          
        }    
        
        char[] s = input.toCharArray();     //input
        char []a = new char[(input.length())/2];      //op string



        int [] htskips =  arr;
        int [] httaken = htskips.clone();
  
        
        
        int i = input.length()-1;
        char best_seen = ('z'+1) ;
        int best_index = 0 ;
        int j=0;
        int small = smallest(httaken);
        for( ; i >= 0 ; i--) {
            if(httaken[s[i]-97]==0) continue ;
            if( (s[i]-97) > small ) {
                if( htskips[s[i]-97] == 0 ) {
                    if ( s[i] < best_seen ) {
                        httaken[s[i]-97]--;
                        a[j] = s[i];
                        j++;
                        best_seen = ('z'+1) ;
                    }
                    else {
                        while (i<best_index) {
                            i++ ;
                            htskips[s[i]-97]++ ;
                        }
                        httaken[s[i]-97]--;
                        a[j] = s[i] ;
                        j++ ;
                        best_seen = ('z'+1) ;
                    }
                }
                else {
                    htskips[s[i]-97]--;
                    if( s[i] < best_seen) {
						best_seen = s[i];
						best_index = i;
					}
				}
			} else {
				if (httaken[s[i] - 97] != 0) {
					httaken[s[i] - 97]--;
					small = smallest(httaken);
					a[j] = s[i];
					j++;
					best_seen = ('z' + 1);
				}
			}
		}
        String newString = String.valueOf(a);
        System.out.println(newString);
	}
    
    public static int smallest(int [] a) {
        int i;
        for(i = 0 ; i < 26 ; i++)
            if( a[i] != 0 )
                return i;

        return 25;
    }
 
}