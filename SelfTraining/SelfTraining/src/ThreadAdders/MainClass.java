package ThreadAdders;

public class MainClass {
	
	public static double  sum ;
	
	public synchronized static double  addToSum(double value)
	{
		return sum+=value ;
		
	}
	
    public static void main(String[] args) 
	{
 
    	StopWatch stopwatcher = new StopWatch();
    	double hugeNumber = 10000000 ;
    	double start = 0;
    	double end = 0 ;
    	double newNum = 0 ;
		
		int processors = Runtime.getRuntime().availableProcessors();
		

		processors = 1 ;
		
		System.out.println(processors);		
		double chunks = hugeNumber/ processors;
		
		
		Thread threadArray[] = new Thread[processors+1];
		int index = 0; 

		for( ; index <= processors-1; index++) {
			
			start = newNum ;
			end =  chunks* (index+1);
			
			if(end > hugeNumber)
				break ;
			
			AdderThread laborThread  = new AdderThread(newNum ,end );	
            Thread t = new Thread( laborThread);
            threadArray[index] = t ;
            t.start();	
			newNum = end+1 ;						
			
		}
		double  remainder =   hugeNumber% processors ;
		if(remainder > 0)
		{

			AdderThread laborThread  = new AdderThread(chunks*processors ,chunks*processors+remainder );
            Thread t = new Thread( laborThread);
            threadArray[index] = t ;
            t.start();	
            try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
		}
		index--;
		
		while(index >= 0 )
		{
			try
			{
				threadArray[index].join();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			index -- ;
		}
		
		System.out.println("HugeNumber = " + hugeNumber + "The Final OutPut is " + MainClass.sum);
		
		System.out.println("TimeElased " + stopwatcher.getElapsedTime());
		
		
	}


	

}



