package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        int minValue = c[0];
        for (int i = 1; i < c.length; i++) {
            if (c[i] < minValue) {
                minValue = c[i];
        }
        int MaxHap = 2*minValue;
            
        for (int i = 1; i < c.length; i++)
            {
            
        }
            
    }
        
    }
}