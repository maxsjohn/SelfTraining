package libs;

public class Stopwatch
{
	private  long start;
	
	public Stopwatch()
	{ 
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime()
	{
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}
	
	public  void restart()
	{
		start = System.currentTimeMillis();
	}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	

}


}
	

