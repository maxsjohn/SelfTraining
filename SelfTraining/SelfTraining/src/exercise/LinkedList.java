package exercise;

import java.util.EmptyStackException;
import java.util.Iterator;

import libs.Queue;
import libs.StdIn;
import libs.StdOut;

public class LinkedList<Item> implements Iterable<Item> {
	
	
	private class Node{
		Item item ;
		Node next;
	}
	
	protected Node first;
	protected int N;
	
	
	public boolean isEmpty()
	{
		return N== 0 ;
	}
	
	public int size()
	{
		return N;
	}
	
	public void  add(Item entry)
	{
		Node oldFirst = first ;
		first = new Node();
		first.item = entry;
		first.next = oldFirst;
		N++;
	}
	
	public Node getNodeAtIndex(int index)
	{
		int l_index = index;
		Node current = first;
		if(index < 0)
			return null;
		
		if(index > this.size())
			return null;
		
		while(l_index > 0 )
		{
			current = current.next;
			l_index--;
		}
		
		return current;
	}
	
	public Item getAtIndex(int index)
	{
		Node node = getNodeAtIndex(index);
		if(node == null)
			return null;
		return node.item;
	}
	
	
	public void insertAtIndex(int index , Item item) 
	{
		int l_index = index;
		if(l_index > this.size())
			return;
		
		Node newNode = new Node();
		N++;
		if(index == 0)
		{
			newNode.next = first;
			first = newNode ;
			return;
					
		}
		
		Node prevNode = getNodeAtIndex( index-1);		
		newNode.item = item;
		newNode.next = prevNode.next;
		prevNode.next = newNode;			
	}
	
	
	public  Node reverse()
	{
		Node prev = null;
		Node cur = first ;
		while(cur != null)
		{
			Node temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
			
		}
		first = prev ;		
		return first;
		
	}
	

	public Item deleteAtIndex(int index ) 
	{
		int l_index = index;
		if(l_index > this.size())
			return null;
		
		Node newNode = new Node();
		N--;
		if(index == 0)
		{
			Node oldFirst = first;
			first = null ;
			return oldFirst.item;				
		}
		
		Node prevNode = getNodeAtIndex( index-1);
		Node temp = prevNode.next;
		prevNode.next = prevNode.next.next;
		return temp.item;
	
	}	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<Item>
	{
		Node currentNode ;
		
		public LinkedListIterator() {
			// TODO Auto-generated constructor stub
			currentNode = first;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currentNode != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Node temp = currentNode;
			currentNode =  currentNode.next;
			return temp.item;
			
		}
		
	}
	
	
	
	public static void main(String[] args) {

		LinkedList<String> q = new LinkedList<String>();
		String item = StdIn.readString();
		while (!item.equals("EOF"))
		{
			q.add(item);
			item = StdIn.readString();
		}
	//	printColection(q);
		q.insertAtIndex(3, "Goto");
		printColection(q);	
		System.out.println("Deted Item is " + q.deleteAtIndex(4));
		
		printColection(q);		
		q.reverse();
		printColection(q);			
		

	}
	
	static void printColection(LinkedList<String> q)
	{
		int i =0;
		for(String str : q)
		{	
			
			System.out.print("["+(i++) +"] = " +str +" ");
			
		}
		System.out.println();
	}
	
}
