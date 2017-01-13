package sedgewick;

public class Sorter {
	
	protected static void exch(Comparable[] a, int i, int j) {
		// TODO Auto-generated method stub
		
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}





	protected static boolean less(Comparable a, Comparable b) {
		// TODO Auto-generated method stub
		return a.compareTo(b) < 0;
	}

	protected static void show(Comparable[] a) {
		// TODO Auto-generated method stub
		
		String retStr = "";
		for(int i=0 ; i< a.length; i++)
			retStr+=" "+a[i];
		
		System.out.println(retStr);
		
	}

	

}
