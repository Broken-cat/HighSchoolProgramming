package DynArray;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DynArrayJUnit {

	@Test
	public void makeArray() {
		DynArray<Integer> dyn = new DynArray<Integer>(Integer.class);
		for(int i = 0; i < 8; i++) 
			dyn.append(new Integer(i));
		dyn.makeArray(45);
		dyn.display();
		
	}
	
	@Test
	public void getItem() {
		DynArray<Integer> dyn = new DynArray<Integer>(Integer.class);
		for(int i = 0; i < 100; i++) 
			dyn.append(new Integer(i));
		assertNotNull(dyn.getItem(9));
		assertNotNull(dyn.getItem(99));
		assertNull(dyn.getItem(9999));
	}
	
	@Test
	public void append() {
		DynArray<Integer> dyn = new DynArray<Integer>(Integer.class);
		for(int i = 0; i < 100; i++) 
			dyn.append(new Integer(i));
	}
	
	@Test
	public void insert() {
		DynArray<Integer> dyn = new DynArray<Integer>(Integer.class);
		for (int i = 0; i < 15; i++) 
			dyn.insert(i, i);
		dyn.display();
		dyn.insert(8, 15);
		dyn.display();
		dyn.insert(99, 16);
		dyn.insert(99, 20);
		dyn.display();
		exceptionRule.expect(ArrayIndexOutOfBoundsException.class);
		dyn.insert(666, 666);
		
		
		/*for(int i = 0; i < 500000; i++) 
			dyn.insert(i, i);
		dyn.display();
		dyn.insert(88,7);
		dyn.insert(88,1);
		dyn.display();
		for (int i = 0; i < 25; i++)dyn.append(new Integer(i));
		dyn.display();*/
	}
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();;
	
	@Test
	public void remove() {
		DynArray<Integer> dyn = new DynArray<Integer>(Integer.class);
		for(int i = 0; i < 10000; i++) 
			dyn.append(new Integer(i));
		dyn.display();
		for(int i = 0; i < 5001;i++)dyn.remove(i);
		dyn.remove(5);
		dyn.display();
		exceptionRule.expect(ArrayIndexOutOfBoundsException.class);
		dyn.remove(1000000);
		dyn.checkCapacity();
		
		DynArray<Integer> dynAr = new DynArray<Integer>(Integer.class);
		for(int i =0;i < 16	;i++)dynAr.append(i);
		dynAr.display();
		dynAr.remove(15);
		dynAr.remove(15);
		dynAr.display();
		
	}
	

}
