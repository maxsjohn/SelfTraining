package hackerearcth;

import java.util.Scanner;

public class MaxPowerArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner s = new Scanner(System.in);

		int testCases = s.nextInt();
		int [] testArray = new int[testCases];
		for (int t = 0; t < testCases; t++) {
			int N = s.nextInt();
			int deletion = s.nextInt();
			int[] a = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = s.nextInt();
			}

			int power = getPowerOfArray(a, deletion);
			testArray[t] = power;

		}
		
		for(int i =0 ; i< testCases ;i++)
			System.out.println(testArray[i]);
	}

	private static int getPowerOfArray(int[] a, int deletion) {
		// TODO Auto-generated method stub

		int rear = a.length - 1;
		int front = 0;
		long product = a[front] * a[rear];

		 int trial = rear ;

		while (deletion > 0) {
		    
		 trial = rear - 1;
		long trialProduct = a[front] * a[trial];
			deletion--;
			if (a[front] > a[rear]) {
				rear--;
				continue;
			} else {
				front++;
				product = a[front] * a[rear];
			}

		}

		return a[front] * a[rear];
	}

}
