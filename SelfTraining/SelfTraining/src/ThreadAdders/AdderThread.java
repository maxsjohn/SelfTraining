package ThreadAdders;

public class AdderThread  implements Runnable{
	
	double  m_start = 0 ;
	double m_end = 0;
	double sum ;
	
	
	public AdderThread(double start, double end) {
		// TODO Auto-generated constructor stub
		m_start =  start ;
		m_end =  end ;		
	}

	public void run()
	{
		
		System.out.println("The start is "+m_start  +" The end is " +m_end);
		
		for(double i= m_start ; i<= m_end ; i++)
		{
			sum+=i;
			
		}
		
		MainClass.addToSum(sum);
		
	}

}
