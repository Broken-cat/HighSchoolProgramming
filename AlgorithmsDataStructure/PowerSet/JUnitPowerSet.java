package PowerSet;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUnitPowerSet {

	@Before
	public void setUp() throws Exception {
	}
	

	@Test
	public void createPower() {
		PowerSet pw = new PowerSet();
		assertTrue("qwe"=="qwe");
		for(int i = 0; i < 50000000; i++)
			pw.put(String.valueOf("asd"));
		pw.put("zxc");
		PowerSet pw2 = makePW();
		pw.union(pw2);
		pw.put("zxc");
	}

	
	@Test 
	public void union() {
		System.out.println("union");
		PowerSet pw = new PowerSet();
		pw.put("1");
		pw.put("3");
		pw.put("2");
		pw.put("4");
		pw.put("5");
		PowerSet pw2 = new PowerSet();
		pw2.put("4");
		pw2.put("6");
		pw2.put("7");
		pw.union(pw2);
		System.out.println("------------------------------------------------------");
	}
	
	
	@Test 
	public void difference() {
		System.out.println("difference");
		PowerSet pw = new PowerSet();
		pw.put("1");
		pw.put("3");
		pw.put("2");
		pw.put("4");
		pw.put("5");
		PowerSet pw2 = new PowerSet();
		pw2.put("4");
		pw2.put("6");
		pw2.put("7");
		pw.difference(pw2);
		System.out.println("------------------------------------------------------");
	}
	
	@Test
	public void Intersection() {
		System.out.println("Intercetion");
		PowerSet pw = new PowerSet();
		for(int i = 0; i < 20; i++)
			pw.put(String.valueOf(i));
		PowerSet pw2 = new PowerSet();
		for(int i = 0; i < 10; i++)
			pw2.put(String.valueOf(i));
		pw.intersection(pw2);
		System.out.println("------------------------------------------------------");
	}
	
	
	public PowerSet makePW() {
		PowerSet t = new PowerSet();
		t.put("qe");
		t.put("ad");
		t.put("tu");
		t.put("zc");
		return t;
	}
	
	
	@Test
	public void isSub() {
		PowerSet pw = new PowerSet();
		pw.put("1");
		pw.put("2");
		pw.put("3");
		pw.put("4");
		PowerSet pw2 = new PowerSet();
		pw2.put("1");
		pw2.put("4");
		PowerSet pw3 = pw.intersection(pw2);
		assertTrue(pw.isSubset(pw2));
		
	}
	
}
