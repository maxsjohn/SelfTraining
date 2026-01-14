package sedgewick;

import java.util.Scanner;

import libs.In;
import libs.StdIn;

public class ShellShort {

	public static void sort(Comparable [] a)
	{
		int N = a.length;
		int h = 1 ;
		
		while(h<N/3)
			h = 3*h+1;
		
		while(h >= 1)
		{
			for(int i =h ;i<N ;i++){
				for(int j=i; j >= h && less(a[j],a[j-h]) ; j-=h){
					exch(a,j,j-h);
					show(a);
				}
			}
			h=h/3;
		}
		
		
	}
	private static void exch(Comparable[] a, int i, int j) {
		// TODO Auto-generated method stub
		
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}





	private static boolean less(Comparable a, Comparable b) {
		// TODO Auto-generated method stub
		return a.compareTo(b) < 0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int i = 0;
		Integer[] a = new Integer[input.length -1]; 
		String str;
		do{
			str = input[i];
			if(str.equalsIgnoreCase("EOF"))
				break;
			a[i] = Integer.parseInt(str);
			i++;
		}while(i<input.length -1);
		
	
		show(a);
		sort(a);
		show(a);
		

	}

	private static void show(Comparable[] a) {
		// TODO Auto-generated method stub
		
		String retStr = "";
		for(int i=0 ; i< a.length; i++)
			retStr+=" "+a[i];
		
		System.out.println(retStr);
		
	}
	

}
