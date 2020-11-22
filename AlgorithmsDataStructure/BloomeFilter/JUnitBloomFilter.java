package BloomeFilter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUnitBloomFilter {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		BloomFilter bm = new BloomFilter(32);
		bm.add("0123456789");
		bm.add("1234567890");
		bm.add("2345678901");
		bm.add("3456789012");
		bm.add("4567890123");
		bm.add("5678901234");
		bm.add("6789012345");
		bm.add("7890123456");
		bm.add("8901234567");
		bm.add("9012345678");
		
		assertTrue(bm.isValue("0123456789"));
		assertTrue(bm.isValue("1234567890"));
		assertTrue(bm.isValue("2345678901"));
		assertTrue(bm.isValue("3456789012"));
		assertTrue(bm.isValue("4567890123"));
		assertTrue(bm.isValue("5678901234"));
		assertTrue(bm.isValue("6789012345"));
		assertTrue(bm.isValue("7890123456"));
		assertTrue(bm.isValue("8901234567"));
		assertTrue(bm.isValue("9012345678"));
		
		assertFalse(bm.isValue("0023456789"));
		assertFalse(bm.isValue("0423456789"));
		assertFalse(bm.isValue("0023656789"));
		assertFalse(bm.isValue("0023454789"));
		assertFalse(bm.isValue("0023452789"));
		assertFalse(bm.isValue("0023851719"));
		
		
	}

}
