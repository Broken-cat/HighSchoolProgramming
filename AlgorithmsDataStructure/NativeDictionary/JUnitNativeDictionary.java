package NativeDictionary;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitNativeDictionary {

	@Test
	public void put() {
		NativeDictionary<Integer> dic = new NativeDictionary<Integer>(11, Integer.class);
		dic.put("David", 1);
		dic.put("Aaron", 2);
		dic.put("Harry", 3);
		dic.put("Victor", 4);
		dic.put("Luke", 5);
		dic.put("Fred", 6);
		dic.put("Scotty", 7);
		dic.put("Bruno", 8);
		dic.put("Rashford", 9);
		dic.put("Cavani", 10);
		dic.put("David", 99);
		dic.put("Antony", 11);
		dic.put("Din", 12);
		dic.put("Paul", 13);
		dic.put("Michael", 14);
		dic.put("Wayne", 15);
		dic.put("Cristiano", 16);
		dic.put("Edwin", 17);
		
		assertTrue(dic.isKey("David"));
		assertTrue(dic.isKey("Luke"));
		assertTrue(dic.isKey("Fred"));
		assertTrue(dic.isKey("Victor"));
		assertFalse(dic.isKey("Cristiano"));
		
		assertNotNull(dic.get("David"));
		assertNotNull(dic.get("Bruno"));
		assertNull(dic.get("Edwin"));
		assertNull(dic.get("Din"));
		
		assertNull(dic.get("ff"));
	}
	
	
	@Test
	public void putEquals() {
		
	}

}
