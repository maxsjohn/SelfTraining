package Hashes;

import java.util.Iterator;

public class HastTester {
	
	
	 static class Engineer{
			
		String name ;
		String type ;
		Integer hash;
		
		public Engineer(String name , String type)
		{
			this.name = name ;
			this.type = type;
		
		}
		
		public int hashCode()
		{
			if(hash == null)
			{
				hash = 31*this.name.hashCode();
				hash = hash+ 17*this.type.hashCode();
			
			}
			return hash;
		}
		
		public String toString()
		{
			return this.name+"  "+this.type;  
		}
		
		public boolean equals(Object e)
		{
			if(!(e instanceof Engineer))
				return false;
			
			Engineer eng = (Engineer) e;
			return (eng.name.equals(this.name)) &&  (eng.type.equals(this.type));
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Engineer, Engineer> hashed = new HashMap<Engineer , Engineer>();
		
		
	
		
		String[][] input =
			{
					{"John" , "Software Engieer"},
					{"Joey" , "Software Manager"},
					{"Flux" , "Mech Engieer"},
					{"Johnson" , "Elect Engieer"},
					{"Jo1hn" , "Soft1ware Engieer"},
					{"Jo1ey" , "Soft1ware Manager"},
					{"Kl1ux" , "Mec1h Engieer"},
					{"Joh1nson" , "Elect Engieer"},					
					{"Jimmy" , "Support Engieer"}
			};
		
		Engineer[] engInput = new Engineer[input.length] ;
		
		 
		for(int i =0; i< input.length; i++)		
		{
			engInput[i] = new Engineer(input[i][0], input[i][1]);
		}
		
		for(int i =0; i< input.length; i++)		
		{
			
			hashed.put(engInput[i], engInput[i] );


		//	engInput[i] = new Engineer(input[i][0], input[i][1]);
		}
		
		Iterator<?> i = hashed.newEntryIterator();
		
//		while(i.hasNext() )
//		{
//			System.out.println(i.next().toString());
//		}
		
		hashed.printHashTable();
		System.out.println(hashed.get(new Engineer("Flux","Mech Engieer")  ));
		System.out.println(hashed.get(new Engineer("xxx","Mech Engieer")  ));	
		System.out.println(hashed.get(null));		

	}

}
