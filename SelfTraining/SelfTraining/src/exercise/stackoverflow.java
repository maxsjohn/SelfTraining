package exercise;

public class stackoverflow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			recurse();
		}
		catch(StackOverflowError e)
		{
			;
		}
		finally
		{
			System.out.println("In finall Block");
		}
		System.out.println("Caught Succesfully");

	}
	
	
	public static void recurse()
	{
		recurse();
	}

}
