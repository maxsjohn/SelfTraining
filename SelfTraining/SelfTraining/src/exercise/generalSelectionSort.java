package exercise;

public class generalSelectionSort  {
	
	static void sort(Comparable [] a)
	{
		int min ;
		
		for(int i=0;i<a.length;i++)
		{
			min = i;
			int j;
			for( j=i+1;j<a.length;j++)
			{

				if(!less (a[min] , a[j]) )
					min = j;
			}
			exchange(a,min,i);			
		
			
		}		
		
		
		
		
	}
	
	public static boolean less(Comparable a , Comparable b)
	{
		return a.compareTo(b) < 0 ;
	}
	
	public static void exchange(Comparable [] a , int i , int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[]a  = {44,56,44,56,49,44,56,49,-4 ,-99 };
		sort(a);
		show(a);

	}
	
	public static void show(Comparable[] a)
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}		

}
