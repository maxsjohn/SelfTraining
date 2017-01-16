package sedgewick;

public class MergeSort extends firstMergeSort {
	
	public static void  sort(Comparable [] a){
		
		aux = new Comparable[a.length];
		
		sort(a,0,a.length-1);
		
	}
	
	

	private static void sort(Comparable[] a, int low, int high) {
		// TODO Auto-generated method stub
		
		if(high <= low )
		{
	
			return;		
		}

		
		
		int mid = low + ((high-low)/2);
		
		sort(a,low ,mid);
		sort(a,mid+1,high);
		merge(a,low, mid, high);
		show(a);
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] a = { 2 ,1 , 2 ,1 , 2 ,1,  2 ,1,  2 ,1, 0};
		show(a);
		sort(a);
		show(a);
	}

}
