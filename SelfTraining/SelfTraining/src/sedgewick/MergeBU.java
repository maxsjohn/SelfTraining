package sedgewick;

public class MergeBU extends MergeSort{
	
	private static Comparable [] aux;
	public static void sort(Comparable[] a){
		int N = a.length;
		aux = new Comparable[N];
		
		for(int sz=1; sz < N ;sz=sz+sz){
			System.out.println("["+sz+"]N-sz= "+(N-sz));
			for(int lo=0; lo< N-sz;lo+=sz+sz){
				System.out.println("[lo="+lo+"](lo+sz+sz-1, N-1)  "+(lo+sz+sz-1)+", "+ (N-1));
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
			}
			System.out.println();
		}
		
		
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
		
		show(a);	
		
	}	

	public static void main(String[] args) {
		String [] a = { "M" ,"E" , "R", "G" ,"E"};
		show(a);
		sort(a);
		show(a);

	}

}
