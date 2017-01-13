package narasimha;

import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class UnrolledLinkedList<E>  extends AbstractList<E> implements List<E>{
	
//	TC HELP
//	9945999549
	
	private int nodeCapacity;
	private int size;
	private ListNode firstNode;
	private ListNode lastNode;
	
	public class ListNode
	{
		ListNode next;
		ListNode previous;
		int NumElements =0;
		Object[] elements;
		
		public ListNode()
		{
			elements = new Object[nodeCapacity];
		}
	}
	
	public UnrolledLinkedList(int capacity) throws IllegalArgumentException
	{
		if(capacity < 8)
			throw new IllegalArgumentException("node capacity must be greate than 8");
		
		this.nodeCapacity = capacity;
		firstNode = new ListNode();
		lastNode = firstNode;
	}
	
	public UnrolledLinkedList()
	{
		this(16);
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public boolean add(E e)
	{
		insertIntoNode(lastNode, lastNode.NumElements,e);
		return true;
	}
	
	private void insertIntoNode(ListNode node ,int ptr ,E element)
	{
		if(node.NumElements == nodeCapacity)
		{
			ListNode newNode = new ListNode();
			int elementsToMove = nodeCapacity/2;
			int startIndex = nodeCapacity - elementsToMove ;
			for(int i=0 ; i< elementsToMove; i++)
			{
				newNode.elements[i]= node.elements[startIndex+i];
				node.elements[startIndex+i] = null;
			}
			node.NumElements-=elementsToMove;
			newNode.NumElements = elementsToMove;
			
			newNode.next = node.next;
			newNode.previous = node;
			
			if(node.next != null)
				node.next.previous= newNode;
			
			node.next = newNode;
			if(node == lastNode)
				lastNode = newNode;
			
			if(ptr > node.NumElements)
			{
				node = newNode;
				ptr = ptr-node.NumElements;
			}
		}
		
		for(int i =node.NumElements; i>ptr ;i--)
		{
			node.elements[i] = node.elements[i-1];
		}
		
		node.elements[ptr] = element;
		node.NumElements ++;
		size++;
		modCount++;
		
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnrolledLinkedList<Integer> link = new UnrolledLinkedList<Integer>(8);
		
		for(int i=0 ; i<25;i++)
			link.add(i);
		
		System.out.println(link);
			
		
		

	}

	@Override
	public E get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public String toString()
	{
		String result= "[";
		ListNode tempFirstNode = firstNode;
		ListNode tempLasttNode = lastNode;		
		while(tempFirstNode != null )
		{
			result = result+"[";
			for(int i=0 ;i<tempFirstNode.NumElements;i++)
				result = result+" , "+ tempFirstNode.elements[i];
			result = result+"]";
			
			tempFirstNode = tempFirstNode.next;
		}
		result = result+"]";
		return result;

	}
	
	private class ULLIterator implements ListIterator<E>
	{
		ListNode currentNode;
		int ptr;
		int index;
		
		private int expectedModCount = modCount;
		
		public ULLIterator(ListNode node , int ptr , int index) {
			// TODO Auto-generated constructor stub
			this.currentNode = node;
			this.ptr = ptr;
			this.index = index;
			
		}

		@Override
		public void add(E arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (index<size-1);
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			ptr++;
			if(ptr >= currentNode.NumElements)
			{
				if(currentNode.next != null)
				{
					currentNode = currentNode.next;
					ptr=0;
				}
				else
				{
					throw new NoSuchElementException();
				}
			}
			index++;
			return (E) currentNode.elements[ptr];
			
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public E previous() {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			ptr--;
			if(ptr <0)
			{
				if(currentNode.previous != null)
				{
					currentNode = currentNode.previous;
					ptr = currentNode.NumElements-1;
				}
				else
				{
					throw new NoSuchElementException();					
				}
			}
			index--;
			return (E) currentNode.elements[ptr];
		}


		public int previousIndex() {
				return index-1;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(E arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
