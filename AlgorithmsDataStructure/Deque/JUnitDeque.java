package Deque;

import static org.junit.Assert.*;import org.hamcrest.core.Is;
import org.junit.Test;

public class JUnitDeque {

	@Test
	public void AddFront() {
		Deque de = new Deque();
		de.addFront(1);
		assertTrue(de.head.equals(1));
		de.addFront(2);
		de.addFront("qwe");
		assertTrue(de.head.equals("qwe"));
	}
	
	@Test
	public void AddTail() {
		Deque de = new Deque();
		de.addTail(1);
		assertTrue(de.tail.equals(1));
		de.addTail(2);
		de.addTail("qwe");
		assertTrue(de.tail.equals("qwe"));
	}
	
	@Test
	public void removeFront() {
		Deque de = new Deque();
		de.addFront(1);
		de.addTail(2);
		de.addTail(3);
		de.addFront(4);
		de.removeFront();
		assertTrue(de.head.equals(1));
		de.removeTail();
		assertTrue(de.tail.equals(2));
		assertFalse(de.head.equals(4));
	}
	
	@Test
	public void addMany() {
		Deque de = new Deque();
	/*	for(int i = 0; i < 5000000;i++)
			de.addFront(i);
		for(int i = 0; i < 5000000;i++)
			de.removeFront();*/
		
		for(int i = 0; i <50000000;i++)
			de.addTail(i);
		for(int i = 0; i < 50000000; i++)
			de.removeTail();
	}
	
	
	@Test
	public void palledrom() {
		Deque de = new Deque();
		String str = "123454321";
		char[] chrs = str.toCharArray();
		boolean isPal = true;
		int i = 0;
		while(isPal && i <= str.length()/2) {
			de.addFront(chrs[i]);
			de.addTail(chrs[chrs.length-1-i]);
			if(!de.head.equals(de.tail))
				isPal = false;
			i++;
		}
		assertTrue(isPal == true);
		
	}

}
