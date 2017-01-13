package sedgewick;

public class firstMergeSort extends Sorter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer [] a = { 1 ,4 , 88, 90 ,3, 4, 77, 89};
		show(a);
		
		MergeSort(a ,0 , (a.length)/2 , a.length-1);
		show(a);
		

	}

	private static void MergeSort(@SuppressWarnings("rawtypes") Comparable[] a, int low, int mid, int high) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("rawtypes")
		Comparable [] aux = a.clone();
		
		int i = low;
		int j = mid;
		
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
