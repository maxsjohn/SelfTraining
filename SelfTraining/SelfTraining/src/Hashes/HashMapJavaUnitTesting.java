package Hashes;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class HashMapJavaUnitTesting {

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testClear() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashMapIntFloat() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashMapInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashMapMapOfQextendsKQextendsV() {
		fail("Not yet implemented");
	}

	@Test
	public void testInit() {
		fail("Not yet implemented");
	}

	@Test
	public void testHash() {
		fail("Not yet implemented");
	}

	@Test
	public void testIndexFor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEntry() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutKV() {
		fail("Not yet implemented");
	}

	@Test
	public void testResize() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransfer() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutAllMapOfQextendsKQextendsV() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveEntryForKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveMapping() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsValueObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEntry() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateEntry() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewKeyIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewValueIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewEntryIterator() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeySet() {
		fail("Not yet implemented");
	}

	@Test
	public void testEntrySet() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testCapacity() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadFactry() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone1() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testAbstractMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsValueObject1() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetObject1() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutKV1() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutAllMapOfQextendsKQextendsV1() {
		fail("Not yet implemented");
	}

	@Test
	public void testKeySet1() {
		fail("Not yet implemented");
	}

	@Test
	public void testValues() {
		fail("Not yet implemented");
	}

	@Test
	public void testEntrySet1() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		HashMap<String, String> hashed = new HashMap<String , String>();
		
		String[][] input =
			{
					{"John" , "Software Engieer"},
					{"Joey" , "Software Manager"},
					{"Klux" , "Mech Engieer"},
					{"Johnson" , "Elect Engieer"},
					{"Jimmy" , "Support Engieer"}
			};
		
		 
		for(int i =0; i< input.length; i++)		
		{
				hashed.put(input[i][0], input[i][1]);
		}
		
		Iterator<?> i = hashed.newEntryIterator();
		
		while(i.hasNext() )
		{
			System.out.println(i.next().toString());
		}
		
		
	}

}
