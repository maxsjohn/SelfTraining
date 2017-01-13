package sedgewick;

import libs.In;
import libs.StdIn;



public class SelectionSort {


	public static void sort(Comparable[] a)
	{
		int min;
		String xyz;
		Object o;
		
		
		for(int i=0 ; i< a.length; i++)
		{
			min = i;
			int j;
			for(j=i+1 ; j< a.length;j++)
			{
				if(less(a[j], a[min]) )
				{
					min = j;
	
				}

	
			}
			exch(a,i,min);	
				
		
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
		
		Integer [] a = new Integer[8];
		
		for(int i=0 ; i< a.length;i++)
			a[i] = Integer.parseInt(StdIn.readString());
		
		sort(a);
		assert isSorted(a);
		show(a);

	}





	private static void show(Comparable[] a) {
		// TODO Auto-generated method stub
		
		String retStr = "";
		for(int i=0 ; i< a.length; i++)
			retStr+=" "+a[i];
		
		System.out.println(retStr);
		
	}





	private static boolean isSorted(Comparable[] a) {
		// TODO Auto-generated method stub
		
		for(int i=1 ; i< a.length; i++)
			if(less(a[i], a[i-1]))
				return false ;
		return true;
	}


}
