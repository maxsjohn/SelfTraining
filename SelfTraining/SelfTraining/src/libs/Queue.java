package libs;

public class Queue<Item> {
	
	
	private class Node{
		Item item ;
		Node next ;
	}
	
	Node first ;
	Node last ;
	int N;
	
	public boolean isEmpty()
	{
		return first == null ;
	}
	
	public void enqueue(Item value_item)
	{
		Node oldLast = last ;
		last = new Node();
		last.item = value_item;
		last.next = null ;
		if(isEmpty())
			first = last ;
		else 
			oldLast.next = last ;
		N++;
	}
	
	
	public Item dequeue()
	{
		Item old_first_item = first.item ;
		first = first.next;
		if(isEmpty())
			last = null;
		N--;
		return old_first_item;
		
	}
	
	
	public int size(){
		return N;
	}
	

	public static void main(String[] args) {
		
		Queue<String> q = new Queue<String>();
		String item = StdIn.readString();
		while (!item.equals("EOF"))
		{
		
		if (!item.equals("-"))
		q.enqueue(item);
		else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");		
		item = StdIn.readString();
		}
		
		StdOut.println("(" + q.size() + " left on queue)");

	}

}
