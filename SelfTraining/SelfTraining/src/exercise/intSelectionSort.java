package exercise;

public class intSelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a  = {44,56,49,44,56,49,44,56,49,-4 ,-99 };
		int min ;
		int count = 0;
		for(int i=0;i<a.length;i++)
		{
			min = i;
			int j;
			for( j=i+1;j<a.length;j++)
			{
				count++;
				if(a[min] < a[j])
					min = j;
			}
			{
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
			
			show(a);
			
		}

		//7+6+5+4+3+2+1
		System.out.println(a.length+" "+count);
	}

	public static void show(int[] a)
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}	
}
