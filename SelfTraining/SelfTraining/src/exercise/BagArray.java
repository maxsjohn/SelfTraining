package exercise;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;



/*
 * size();
 * add()
 * 
 */
public class BagArray<T> implements Iterable<T>{

	private int size ;

	transient T[] table ;
	
	
	final private int INITIAL_LENGTH = 16;
	
	public int size(){
		return size;
	}
	
	public BagArray() {
		// TODO Auto-generated constructor stub
		table = (T[]) new Object[INITIAL_LENGTH];
		size = 0;
		
	}
	
	public void add(T element)
	{
		if(table.length == size)
		{
			T[] tempTable = (T[]) new Object[(table.length)*2];
			table = CopyContentAndReturnDestination(tempTable ,table);
		}
		table[size++] = element;
	}
	
	
	T[] CopyContentAndReturnDestination(T[] destination , T[] source)
	{
		for(int i =0; i< source.length;i++)
		{
			destination[i] = source[i];
		}
		
		return destination;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new BagContentIterator();
	}
	
	
	public final class BagContentIterator  extends BagIterator
	{
		public T next(){
			return nextElement();
		}
	}
		
	
	
	private abstract class BagIterator implements Iterator<T>
	{
		T next;
		int expectedModCount;
		int index;
		T current ;
		
		
		BagIterator()
		{
			this.expectedModCount = size;
			if(size >0)
			{
				T[] t = table;
				
				while(index<t.length && (next = t[index++]) == null)
					;
			}
		}
		
		
		public final boolean hasNext()
		{
			return next != null;
		}
		
		final T nextElement()
		{
			if(size != expectedModCount)
				throw new ConcurrentModificationException();
			
			T e = next;
			
			if(e == null)
				throw new NoSuchElementException();
			
			
			if((next= e) != null)
			{
				T[] t = table ;
				while(index < t.length && (next = t[index++]) ==  null)
					;
			}
			current = e;
			return e ;
			
		}
	}	
	
	public T getElement(int i)
	{
		return table[i];
	}
	

}
