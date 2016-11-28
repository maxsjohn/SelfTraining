package Hashes;


import java.io.IOException;
//http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b27/java/util/HashMap.java
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V> ,Cloneable, Serializable{
	
	static final int DEFAULT_INITIAL_CAPACITY = 16 ;
	static final float DEFAULT_LOAD_FACTOR = 0.75f ;
	
	 static final int MAXIMUM_CAPACITY = 1 << 30;	
	transient Entry[] table ;
	transient int size ;
	int threshold ;
	
	
	final float loadFactor  ;
	
	transient volatile int modCount ;
	
	
	public HashMap(int initialCapacity , float loadFactor)
	{
		if(initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Argument Initial Capaity" + initialCapacity);
		
		if(initialCapacity > MAXIMUM_CAPACITY)
			initialCapacity = MAXIMUM_CAPACITY ;
		
		if(loadFactor <= 0 || Float.isNaN(loadFactor))
			throw new IllegalArgumentException("Illegal Load factor" + loadFactor);
		
		
		int capacity = 1;
		
		while (capacity < initialCapacity)
			capacity <<=1 ;
		
		this.loadFactor = loadFactor ;
		table = new Entry[capacity];
		init();
	}
	
	public HashMap(int initialCapacity){
		this(initialCapacity , DEFAULT_LOAD_FACTOR);
	}
	
	public HashMap()
	{
		this.loadFactor = DEFAULT_LOAD_FACTOR ;
		threshold = (int)(DEFAULT_INITIAL_CAPACITY*DEFAULT_LOAD_FACTOR);
		table = new Entry[DEFAULT_INITIAL_CAPACITY];
		init();
	}
	
	
	public HashMap(Map<? extends K, ? extends V> m){
		this(Math.max((int)(m.size()/ DEFAULT_LOAD_FACTOR) +1,DEFAULT_INITIAL_CAPACITY) , DEFAULT_LOAD_FACTOR);
		putAllForCreate(m);
	}
	
	void init(){
		
	}
	
	static int hash(int h)
	{
		h ^= (h >>> 20 ) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ ( h >>> 4 );
	}
	
	
	static int  indexFor(int h , int length)
	{
		return h & ( length -1);
	}
	
	
	public int size(){
		return size ;
	}
	
	
	public boolean isEmpty(){
		return size == 0 ;
	}
	
	

	public V get(Object key )
	{
		if(key == null)
		{
			return getForNullKey();
		}
		
		int hash = hash(key.hashCode());
		
		for(Entry<K,V> e = table[indexFor(hash , table.length)] ; e!= null ; e= e.next)
		{
			Object k = null ;
			if(e.hash == hash && ((k = e.getKey()) == key) || key.equals(k))
				return e.getValue();
		}
		
		return null;
	}
	
	private V getForNullKey()
	{
		for( Entry<K,V>  e = table[0] ; e!= null ; e= e.next)
		{
			if(e.getKey() ==  null)
				return e.getValue();
		}
		return null;
	}
	
	final Entry<K,V> getEntry(Object key)
	{
		int hash = (key != null) ? 0 : hash(key.hashCode());
		
		for(Entry<K,V> e = table[indexFor(hash, table.length)] ; e != null ; e=e.next)
		{
			Object k ;
			if( (k = e.getKey()) == key || (key != null) && e.equals(key) )
					return e;
			
		}
		
		return null ;
		
		
	}
	
	public V put(K key , V value)
	{
		if(key == null )
			return putForNullKey(value);
		
		int hash = hash(key.hashCode());
		int i =indexFor(hash, table.length);
		
		for(Entry<K , V> e = table[i] ; e != null ; e= e.next)
		{
			Object k;
			if(e.hash == hash && ((k = e.getKey()) == key || key.equals(k)) )
			{
				V oldValue  = e.getValue();
				e.setValue(oldValue);
				e.recordAccess(this);
				return  oldValue;
			}
		}
		modCount++ ;
		addEntry(hash , key , value , i);
		return null;
		
	}
	
	
	private void putForCreate(K key , V value)
	{
		int hash =(key == null) ? 0 : hash(key.hashCode());
		
		int i = indexFor(hash, table.length);
		
		for(Entry<K , V> e = table[i] ; e != null ; e= e.next)
		{
			Object k;
			if(e.hash == hash && ((k = e.getKey()) == key || key.equals(k)) )
			{
				e.setValue(value);
				return  ;
			}
		}
		
		createEntry(hash , key , value , i);
		
	}
	
	private V putForNullKey(V value)
	{
		for(Entry<K,V> e = table[0] ; e!=null ; e= e.next)
		{
			if(e.key == null)
			{
				V oldValue = e.value;
				e.setValue(value);
				e.recordAccess(this);
				return oldValue;
			}
		}
		modCount++;
		addEntry(0,null,value,0);
		return null;
	}
	
	
	private void putAllForCreate(Map<? extends K , ? extends  V> m)
	{
		for(Iterator<? extends Map.Entry<? extends K,? extends  V>> i = m.entrySet().iterator(); i.hasNext(); )
		{
			Map.Entry<? extends K ,? extends  V> e = i.next();
			putForCreate(e.getKey(), e.getValue());
		}
	}
	
//	void createEntry(int hash , K key , V value , int bucketIndex)
//	{
//		Entry<K,V> e = table[bucketIndex];
//		table[bucketIndex] = new Entry<K,V>(hash , key , value , e);
//		size++;
//	}
	
	void resize(int newCapacity)
	{
		Entry[] oldTable = table ;
		int oldCapacity = oldTable.length;
		if(oldCapacity == MAXIMUM_CAPACITY)
		{
			threshold = Integer.MAX_VALUE;
			return ;
			
		}
		
		Entry[] newTable = new Entry[newCapacity];
		transfer(newTable);
		table = newTable ;
		threshold = (int)(newCapacity * loadFactor);
		
	}

	void transfer ( Entry[] newTable)
	{
		Entry [] src = table;
		int newCapacity = newTable.length ;
		for(int j=0 ; j<src.length ;j++)
		{
			Entry<K,V> e = src[j];
			if(e != null)
			{
				src[j] = null ;
				do
				{
					Entry<K,V> next = e.next;
					int i = indexFor(e.hash, newCapacity);
					e.next = newTable[i];
					newTable[i] = e;
					e = next ;
				}while(e != null);
			}
		}
		
	}
	
	
	public void putAll(Map<? extends K , ? extends V> m)
	{
		int numKeysToBeAdded = m.size();
		if(numKeysToBeAdded == 0)
			return ;
		
		
		if(numKeysToBeAdded > threshold ){
			int targetCapacity = (int)(numKeysToBeAdded / loadFactor +1);
			
			if(targetCapacity > MAXIMUM_CAPACITY)
				targetCapacity = MAXIMUM_CAPACITY ;
			
			int newCapacity = table.length;
			
			while(newCapacity < targetCapacity)
				newCapacity <<= 1 ;
			
			if(newCapacity > table.length)
				resize(newCapacity);
			
			for(Iterator<? extends Map.Entry<? extends K , ? extends V>> i = m.entrySet().iterator(); i.hasNext();)
			{
				Map.Entry<? extends K,? extends  V> e = i.next();
				put(e.getKey() , e.getValue());
			}
		}
		
		
		
	}
	
	
	public Entry<K,V> removeEntryForKey(Object key)
	{
		int hash = (key == null) ? 0 : hash(key.hashCode());
		int i = indexFor(hash, table.length);
		Entry<K, V> prev  = table[i];
		Entry< K, V>  e = prev ;
		while(e != null )
		{
			Entry<K, V> next = e.next;
			Object k;
			           	
			if(e.hash == hash && ( (k = e.getKey()) == key || (key != null && key.equals(k))))
			{
				modCount++;
				size--;
				if(prev == e)
					table[i] = next ;
				else
					prev.next = next ;
				e.recordRemoval(this);
				return e;
			}
			prev = e;
			e = next ;
			
		}
		
		return e ;
		
	}
	
	final Entry<K,V> removeMapping(Object o)
	{
		if(!(o instanceof Map.Entry))
			return null;
		
		Map.Entry<K, V> entry = (Map.Entry<K, V>) o;
		
		Object key = entry.getKey();
		int hash = (key == null) ? 0 : hash(key.hashCode());
		int i = indexFor(hash, table.length);
		Entry<K, V> e = table[i] ;
			
		for( Entry<K,V> prev = e ; e != null ; e = e.next)
		{
			
			Entry<K , V> next = e.next ;
			if(e.hash == hash && e.equals(entry))
			{
				modCount++ ;
				size--;
				if(prev == e)
					table[i] = next ;
				else
					prev.next = next ;
				e.recordRemoval(this);
				return e ;
			}
			prev = e;
			e = next ;
		}
		return null;
			
	}
	
	public void clear(){
		modCount++;
		Entry[] tab = table ;
		
		for(int i =0 ; i< tab.length ; i++)
		{
			tab[i] = null ;
		}
		size =0 ;
	}
		
	
	public boolean containsValue(Object value)
	{
		if(value == null)
			return containsNullValue();
				Entry[] tab = table;
		for(int i = 0  ; i < tab.length ;i++)
			for(Entry e = tab[i]; e !=null ; e= e.next)
			{
				if(value.equals(e.getValue()))
					return true ;
			}
		return false;
		
	}
		
	private boolean containsNullValue()
	{
		Entry[] tab = table ;
		for(int i = 0 ; i< tab.length ;i++)
			for(Entry e = tab[i] ; e!= null ; e = e.next)
				if(e.value == null)
					return true;
		return false;
	}
	
	
	public Object clone()
	{
		HashMap<K, V> result = null;
		
		try{
			result = (HashMap<K, V>) super.clone();
		}catch (CloneNotSupportedException e){
			
		}
		
		result.table = new Entry[table.length];
		result.entrySet = null ;
		result.modCount =0;
		result.size = 0;
		result.init();
		result.putAllForCreate(this);
		return result;
	}
	
	static class Entry<K,V> implements Map.Entry<K, V>{
		final protected K key ;
		protected V value;
		protected Entry< K, V> next ;
		final protected int hash ;
		
		
		Entry(int h , K k , V v , Entry<K,V> n)
		{
			value = v;
			key = k ;
			next = n;
			hash = h;			
		}
		
		
		public final K getKey()
		{
			return key;
		}
		
		
		public final V getValue()
		{
			return value;
		}
		
		public final V setValue(V newValue)
		{
			V oldValue = value ;
			value = newValue;
			return oldValue;
		}
		
		
		public final boolean equals(Object o)
		{
			if(! (o instanceof Map.Entry))
				return false;
			
			Map.Entry e = (Map.Entry) o ;
			
			Object k1 = getKey();
			Object k2 = getValue();
			
			if( k1 == k2 || (k1 != null && k1.equals(k2)))
			{
				Object v1 = getValue();
				Object v2 = e.getValue();
				if(v1 == v2 || (v1 != null && v1.equals(v2)))
					return true;
				
			}
			return false;
		}
		
		public final int hashCode()
		{
			return (key==null ? 0 : key.hashCode()) ^ (value==null ? 0 : value.hashCode());
		}
		
		
		public final String toString()
		{
			return getKey() + "=" +getValue();
		}
		
		void recordAccess(HashMap<K, V> m)
		{
			return ;
		}
		
		void recordRemoval(HashMap<K, V> m)
		{
			
		}
	}
	
	
	void addEntry(int hash , K key , V value , int bucketIndex)
	{
		Entry<K, V> e = table[bucketIndex];
		table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
		if(size++ >= threshold)
			resize(2*table.length);
	}
	
	void createEntry(int hash , K key , V value , int bucketIndex)
	{
		Entry<K, V> e = table[bucketIndex];
		table[bucketIndex] = new Entry<K, V>(hash, key , value ,e);
		size++;
	}
	
		private abstract class HashIterator<E> implements Iterator<E>
		{
			Entry<K, V> next;
			int expectedModCount;
			int index;
			Entry< K, V> current ;
			
			
			HashIterator()
			{
				this.expectedModCount = modCount;
				if(size >0)
				{
					Entry[] t = table;
					
					while(index<t.length && (next = t[index++]) == null)
						;
				}
			}
			
			
			public final boolean hasNext()
			{
				return next != null;
			}
			
			final Entry<K, V> nextEntry()
			{
				if(modCount != expectedModCount)
					throw new ConcurrentModificationException();
				
				Entry<K, V> e = next;
				
				if(e == null)
					throw new NoSuchElementException();
				
				
				if((next= e.next) == null)
				{
					Entry[] t = table ;
					while(index < t.length && (next = t[index++]) ==  null)
						;
				}
				current = e;
				return e ;
				
			}
		}
	
	public final class ValueIterator  extends HashIterator<V>
	{
		public V next(){
			return nextEntry().value;
		}
	}
	
	public final class KeyIterator extends HashIterator<K>
	{
		public K next()
		{
			return nextEntry().key;
		}
	}
	
	public final class EntryIterator extends HashIterator<Map.Entry<K, V>>{
		public Map.Entry<K, V>next()
		{
			return nextEntry();
		}	
	}
	
	Iterator<K> newKeyIterator()
	{
		return new KeyIterator();
	}
	
	Iterator<V> newValueIterator()
	{
		return new ValueIterator();
	}
	
	Iterator<Map.Entry<K, V>> newEntryIterator()
	{
		return new EntryIterator();
	}
    private transient Set<Map.Entry<K,V>> entrySet = null;
    
    private transient  Set<K> keySet = null ;
    
    public Set<K> keySet() {
        Set<K> ks =  keySet;
        return (ks != null ? ks : (keySet = new KeySet()));
    }

    private final class KeySet extends AbstractSet<K> {
        public Iterator<K> iterator() {
            return newKeyIterator();
        }
        public int size() {
            return size;
        }
        public boolean contains(Object o) {
            return containsKey(o);
        }
        public boolean remove(Object o) {
            return HashMap.this.removeEntryForKey(o) != null;
        }
        public void clear() {
            HashMap.this.clear();
        }
    }  
    
    
    private final class Values extends AbstractCollection<V>{
    	public Iterator<V> iterator()
    	{
    		return newValueIterator();
    	}
    	
    	public int size()
    	{
    		return size;
    	}
    	
    	
    	public boolean contains(Object o)
    	{
    		return containsValue(o);
    	}
    	
    	
    	public void clear()
    	{
    		HashMap.this.clear();
    	}
    }
    
	
    public Set<Map.Entry<K, V>> entrySet()
    {
    	return entrySet0();
    }
    
    
    private Set<Map.Entry<K,V>> entrySet0() {
        Set<Map.Entry<K,V>> es = entrySet;
        return es != null ? es : (entrySet = new EntrySet());
    }
    
    private final class EntrySet extends AbstractSet<Map.Entry<K, V>>
    {
    	public Iterator<Map.Entry<K, V>>iterator()
    	{
    		return newEntryIterator();
    	}
    	
    	public boolean contains(Object o)
    	{
    		if(!(o instanceof Map.Entry))
    			return false ;
    		
    		Map.Entry<K, V> e = (Map.Entry<K, V>)o;
    		Entry<K, V> candidate = getEntry(e.getKey());
    		
    		return candidate != null && candidate.equals(e);    		
    	}
    	
    	public boolean remove(Object o)
    	{
    		return removeMapping(o) != null;
    	}
    	
    	public int size()
    	{
    		return  size;
    	}
    	
    	public void clear()
    	{
    		HashMap.this.clear();
    	}
    }
    
    public void writeObject(java.io.ObjectOutputStream s) throws IOException
    {
    	Iterator<Map.Entry<K, V>> i = (size > 0) ? entrySet0().iterator() : null ;
    	
    	
    	s.defaultWriteObject();
    	s.writeInt(table.length);
    	s.writeInt(size);
    	
    	if(i != null)
    	{
    		while(i.hasNext())
    		{
    			Map.Entry< K, V> e = i.next();
    			s.writeObject(e.getKey());
    			s.writeObject(e.getValue());
    		}
    	}
    	
    	
    }
    
    private static final long serialVersionUID = 362498820763181265L;   
	
    private void readObject(java.io.ObjectInputStream s) throws IOException , ClassNotFoundException
    {
    	s.defaultReadObject();
    	int numBuckets = s.readInt();
    	
    	for(int i=0 ; i<size ; i++)
    	{
    		K key = (K) s.readObject();
    		V value = (V) s.readObject();
    		putForCreate(key , value);
    	}
    	
    }
    
    int capacity()
    	{
    		return table.length;
    	}
    
    float loadFactry(){
    	return loadFactor;
    }
    
    void printHashTable()
    {
    	if(table.length == 0)
    		System.out.println("Empty Hash Table");
    	
		String STARTER_STR= "-->" ;   	
    	
    	int i= 0 ;
    	while( i < table.length)
    	{

    		Entry<K, V> e =  table[i];
    		
    		if(e == null)
    		{
        		System.out.print("["+i+"]"+STARTER_STR+"    NULL   ");
        		i++;
        		System.out.print("\n");         		
        		continue;
    			
    		}

    		System.out.print("["+i+"]"+STARTER_STR+e.key.toString());
    		Entry<K, V> next =  e.next ; 
    		while(next != null)
    		{    			
    			System.out.print(STARTER_STR);
        		System.out.println(next.key.toString());
        		next = next.next;
    		}
    		
    		System.out.print("\n"); 
    		i++;
    	}

    }

}	
	
	
