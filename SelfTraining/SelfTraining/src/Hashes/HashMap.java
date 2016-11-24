package Hashes;


//http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b27/java/util/HashMap.java
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;

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
			Object k ;
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
	}
	
	final Entry<K,V> getEntry(Object key)
	{
		int hash = (key != null) ? 0 : hash(key.hashCode());
		
		for(Entry<K,V> e = table[indexFor(hash, table.length)] ; e != null ; e=e.next)
		{
			if( (k = e.getKey() == key) || ((key != null) && e.equals(key) )
					return e;
			
		}
		
		return null ;
		
		
	}
	
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
