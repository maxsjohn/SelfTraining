package hackerearcth;
import java.util.Scanner;
public class Oz {
    public static void main(String args[] ) throws Exception {

		Scanner scan = new Scanner(System.in);
		int  N = scan.nextInt();
//		int [] answer = new int[N];
		
		for(int i=0; i<N;i++)
		{
			int  l = scan.nextInt();
			int  r = scan.nextInt();		
		
			System.out.println( getSumOfLuckyInBetween(l,r));
			
		}

		
	}
    
	public static Integer getTheLuckyNumber(int num)
	{
		String numStr = String.valueOf(num);
		String outPut = "";
		
		
		for(int i=0; i< numStr.length();i++)
		{
			if(numStr.charAt(i)=='3' ||  numStr.charAt(i)=='4' ||    numStr.charAt(i)=='5'   )
				outPut +=outPut="5";
			else
				outPut +=outPut="2";	
			
			
			
		}
		Integer.parseInt(outPut);
		
		if(Integer.parseInt(outPut) < num)
			outPut="2"+outPut;
		
		
		return Integer.parseInt(outPut);
	}
	
 	private static int getSumOfLuckyInBetween(int l, int r) {
		// TODO Auto-generated method stub
		int sum =0;
		
		for(int  i=l; i <= r ; i++)
		{
			sum +=getTheLuckyNumber(i);
		}
		
		
		return sum;
	}   
    
}
