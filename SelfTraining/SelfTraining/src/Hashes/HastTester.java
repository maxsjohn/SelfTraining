package Hashes;

import java.util.Iterator;

public class HastTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, String> hashed = new HashMap<String , String>();
		
		String[][] input =
			{
					{"John" , "Software Engieer"},
					{"Joey" , "Software Manager"},
					{"Klux" , "Mech Engieer"},
					{"Johnson" , "Elect Engieer"},
					{"Jimmy" , "Support Engieer"}
			};
		
		 
		for(int i =0; i< input.length; i++)		
		{
				hashed.put(input[i][0], input[i][1]);
		}
		
		Iterator<?> i = hashed.newEntryIterator();
		
		while(i.hasNext() )
		{
			System.out.println(i.next().toString());
		}
		

	}

}
