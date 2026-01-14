package exercise;

import libs.StdIn;

public class CircularLinkedList<Item> {
	
	
	protected CLLNode tail;
	protected int length;
	
	private class CLLNode
	{
		Item item;
		CLLNode next ;	
		
		public void setNext(CLLNode nextNode)
		{
			this.next = nextNode;
		}		
		public CLLNode(Item data)
		{
			this.item = data;
		}
		public CLLNode getNext() {
			// TODO Auto-generated method stub
			return next;
		}
		public Item getData() {
			// TODO Auto-generated method stub
			return item;
		}
	}
	
	public CircularLinkedList()
	{
		tail =null;
		length =0;
	}
	
	public void add(Item data)
	{
		addToHead(data);
	}
	
	public void addToHead(Item data)
	{
		CLLNode temp = new CLLNode(data);
		if(tail == null)
		{
			tail = temp;
			tail.setNext(tail);
		}
		else
		{
			temp.setNext(tail.getNext());
			tail.setNext(temp);
		}
		length++;
	}
	
	public void addToTail(Item data)
	{
		addToHead(data);
		tail = tail.getNext();
	}
	
	
	public Item peek()
	{
		return  tail.getNext().getData();
	}
	
	public Item tailPeek()
	{
		return tail.getData();
	}
	
	public Item RemoveFromHead()
	{
		CLLNode temp = tail.getNext();
		if(tail == tail.getNext())
		{
			tail =null;
		}
		
		else
		{
			tail.setNext(temp.getNext());
			temp.next = null;
		}
		return temp.getData();
	}
	
	public Item removeFromTail()
	{
		if(isEmpty())
		{
			return null;
		}
		
		CLLNode finger = tail;
		while(finger.getNext() != tail)
			finger = finger.getNext();
		
		CLLNode temp = tail;
		
		if(finger == tail)
		{
			tail = null;
		}
		else
		{
			finger.setNext(tail.getNext());
			tail = finger;
		}
		return tail.getData();

	}
	
	public boolean contains(Item data)
	{
		if(tail == null)
			return false;
		
		CLLNode finger = tail;
		while(finger !=tail && (!(finger.getData() == data)))
				finger =  finger.getNext();
		
		return finger.getData() == data;
	}
	
	public Item removeItem(Item data)
	{
		if(tail == null) return null;
		
		CLLNode finger = tail.getNext();
		CLLNode previous = tail;
		int compares;
		for(compares=0; compares< length && (!(finger.getData() == data)); compares++ )
		{
			previous = finger;
			finger = finger.getNext();
		}
		
		if(finger.getData() == data)
		{
			if(tail == tail.getNext())
				tail = null;
			else
			{
				if(finger == tail)
					tail = previous;
				previous.setNext(previous.getNext().getNext());
			}
			return finger.getData();
		}
		return null;
		
	}
	
	public String toString()
	{
		String result= "[";
		if(tail == null)
		{
			return result+"]";
		}
		
		result = result + tail.getData();
		CLLNode temp = tail.getNext();
		while(temp != tail)
		{
			result = result+" , "+temp.getData();
			temp = temp.getNext();
		}
		
		return result+"]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CircularLinkedList<String> q = new CircularLinkedList<String>();
		String item = StdIn.readString();
		while (!item.equals("EOF"))
		{
			q.add(item);
			item = StdIn.readString();
		}		

		System.out.println(q);	
		q.RemoveFromHead();
		System.out.println(q);	
		q.removeFromTail();
		System.out.println(q);	
	}

	private boolean isEmpty() {
		// TODO Auto-generated method stub
		return tail == tail.getNext();
	}

}
