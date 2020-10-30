package DynArray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;

public class DynArrayJUnit {

	@Test
	public void arr() {
		int[] arr = new int[5];
		arr = null;
		assertNull(arr);
	}
	
	@Test
	public void makeArray() {
		DynArray<Boolean> dyn = new DynArray<Boolean>(Boolean.class);
		List<Boolean> t = new ArrayList<Boolean>(); 
		List<Boolean> s = Arrays.asList(dyn.array);
		dyn.display();
		assertThat(t.size(), is(0)); // True
		assertThat(s.size(), is(0)); // false
		assertThat(s.isEmpty(), is(false)); // True
		Assert.assertEquals(new ArrayList<Boolean>(16), dyn.array);//False
		assertEquals(new ArrayList<Boolean>(0), dyn.array);
		Assert.assertEquals(List.of(), dyn.array);
	//	dyn.makeArray(10);
	//	assertNull(dyn.array);
		
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
		DynArray<Boolean> dyn = new DynArray<Boolean>(Boolean.class);
		dyn.display();
		for(int i = 0; i < 1; i++) 
			dyn.append(true);
		dyn.display();
		dyn.makeArray(80);
		dyn.display();
	}
	
	@Test
	public void insert() {
		DynArray<Integer> dyn = new DynArray<Integer>(Integer.class);
		int [] arr = null;
		assertEquals(arr, dyn.array);
		for (int i = 0; i < 15; i++) 
			dyn.insert(i, i);
		dyn.display();
		dyn.insert(8, 15);
		dyn.display();
		dyn.insert(99, 15);
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
