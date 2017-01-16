package sedgewick;

public class firstMergeSort extends Sorter {
	static Comparable [] aux ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer [] a = { 1 ,4 , 88, 90 ,3, 4, 77, 89};
		show(a);
		aux = a.clone();
		merge(a ,0 , (a.length)/2 , a.length-1);
		show(a);
		

	}

	protected static void merge(@SuppressWarnings("rawtypes") Comparable[] a, int low, int mid, int high) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("rawtypes")
		
		
		int i = low;
		int j = mid+1;
		
		for(int l =low; l <= high ;l++)
			aux[l]=a[l];
		
		for(int k = low ; k <= high ; k++){
			
			if(i > mid)
				a[k] = aux[j++];
			else if(j > high)
				a[k] = aux[i++];
			else if (less(aux[j],aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
		
		
		
	}

}
