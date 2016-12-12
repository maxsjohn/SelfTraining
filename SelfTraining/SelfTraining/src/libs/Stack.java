package libs;

public class Stack<Item> {
	
	private class Node{
		
		protected  Item node ;
		protected  Node next ;
	}
	
	Node  first ;
	int N;
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public int size()
	{
		return N;
	}
	
	
	public void push(Item item)
	{
		Node oldFirst = first;
		first = new Node();
		first.node = item ;
		first.next = oldFirst ;
		N++ ;						
	}
	
	public Item pop()
	{
		if(isEmpty())
			return null;
		Node  popedNode = first;
		first = first.next;
		N--;
		return popedNode.node;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<String> s = new Stack<String>();
		String item = StdIn.readString();
		while (! item.equalsIgnoreCase("EOF"))
		{
		
			if (!item.equals("-"))
			s.push(item);
			else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
			
			item = StdIn.readString();
		}
		StdOut.println("(" + s.size() + " left on stack)");		

	}

}
