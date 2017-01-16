package narasimha;

import java.util.Random;

public class SkipList <T extends Comparable<T>,U> {

	private class Node{
		public T key;
		public U value;
		public long level  ;
		public Node next;
		public Node down;
		
		public Node(T key , U value , long level , Node next , Node down)
		{
			this.key = key;
			this.value = value;
			this.level= level;
			this.next= next;
			this.down=down;
			
			String ret  = "[";
			ret+=" "+key+" "+level ;
			System.out.print(ret+ " "+"]");
					
			

		}


		
	}
	
	public Node head;
	private Random _random;
	private long size;
	private double _p;
	
	private long level()
	{
		long level =0;
		while(level<=size && _random.nextDouble() < _p)
			level++;
		
		return level;
		
		
	}
	
	public SkipList()
	{
		head = new Node(null,null,0,null,null);
		_random = new Random();
		size=0;
		_p=0.5;
	}
	
	
	
	public void add(T key, U value)
	{
		long level =level();
		if(level > head.level)
			head = new Node(null , null,level,null,head);
		
		Node cur = head;
		Node last = null;
		
		while(cur != null)
		{

			
			
			if(cur.next == null || cur.next.key.compareTo(key) >0)
			{
				
				
				if(level >= cur.level)
				{
					Node n= new Node(key,value,cur.level , cur.next ,null);
					if(last != null)
					{
						last.down = n;
					}
					cur.next = n;
					last = n;
				}
				cur = cur.down;
				continue;
			}
			else if(cur.next.key.equals(key))
			{
				cur.next.value =value;
				return;
			}
			cur = cur.next;
		}
		size++;
		
	}
	
	public boolean containsKey(T key)
	{
		return get(key)!= null;
	}

	
	public U remove(T key)
	{
		U value = null;
		Node cur = head;
		while(cur != null)
		{
			if(cur.next == null || cur.next.key.compareTo(key) >= 0)
			{
				if(cur.next != null && cur.next.equals(key))
				{
					value = cur.next.value;
					cur.next = cur.next.next;
				}
				cur = cur.down;
				continue;
			}
			cur = cur.next;
		}
		size--;
		return value;
	}
	

	public U get(T key)
	{
		Node cur = head;
		int count  =0;
		System.out.println("Getting ");
		while(cur != null && (count++ != -1)){
			
			if(cur.next != null)
				System.out.print(cur.next.key+ " ");
			else
				System.out.print("?");
			
			if(cur.next == null || cur.next.key.compareTo(key) > 0)
			{
				System.out.print(">");
				cur = cur.down;
				continue;
			}
			else if(cur.next.key.equals(key))
			{
				System.out.println("=== ");
				System.out.println(count);
				return cur.next.value;
			}
			System.out.print("<");
			cur = cur.next;
		}
		System.out.println("Coubting ");
		System.out.println(count);
		return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		SkipList<Integer,Integer> s = new SkipList<Integer , Integer>();
		Random r = new Random();
		
		String str = "87 56 94 22 86 4 3 97 71 22 83 97 19 60 56 14 84 42 66 29 93 10 65 4 28 1 51 24 9 8 60 89 6 79 35 51 73 3 94 36 91 94 75 66 73 94 65 47 49 86 50 36 20 61 82 92 42 69 58 6 0 92 48 54 37 59 71 9 13 46 7 38 40 36 50 54 22 48 34 37 16 14 66 94 90 89 1 70 84 70 18 0 60 93 14 74 46 36 122 8 34";
		
		String[] arr = str.split(" ");
		
		for(int i =0 ; i<101 ; i++)
		{
			int num = Integer.parseInt(arr[i]);
			s.add(num, i);
	//		System.out.print(num + " ");
		}
			
		System.out.println(" ");
		Integer f ;
		int search = 51 ;
		f=		s.get(search);
		if(f != null)
			System.out.println("Search Succesful "+search +"  " +f.intValue() );
	
		System.out.println(" size "+ s.size );		
		

	}
	

}
