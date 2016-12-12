package exercise;

import java.util.Iterator;

import libs.Queue;
import libs.StdIn;
import libs.StdOut;

public class Bag<Item> implements Iterable<Item> {
	
	private class Node{
		
		Item item ;
		Node next ;
		
	}
	
	private Node first; 
	
	public void add(Item valueItem)
	{
		Node oldFirst = first ;
		first = new Node();
		first.item = valueItem;
		first.next = oldFirst;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag<String> q = new Bag<String>();
		String item = StdIn.readString();
		while (!item.equals("EOF"))
		{	
		q.add(item);
		item = StdIn.readString();
		}
		
		for(String e : q)
		{
			System.out.println(e);
		}
	

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new BagIterator();
	}
	
	private class BagIterator implements Iterator<Item>
	{

		Node current ;
		
		public BagIterator()
		{

			current = first ;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.next;

			return item;
			
		}
		
		
		
	}

}
