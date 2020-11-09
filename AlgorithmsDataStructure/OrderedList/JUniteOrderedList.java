package OrderedList;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.Test;

public class JUniteOrderedList {

	@Test
	public void CompareTo() {
		OrderedList ol = new OrderedList(true);
		ol.compare(new Integer(12), new Integer(11));
		ol.compare(new Integer(11), new Integer(12));
		ol.compare(true, false);
		ol.compare('a', 'b');
	}
	
	
	@Test
	public void add() {
		OrderedList ol = new OrderedList(true);
		ol.add("asd");
		ol.add("zxczx");
		ol.add("yhjj");
		ol.add("asd qwe rty yui");
		ol.add("samrt");
		ol.add("b");
		ol.add("c");
		ol.add("oi");
	//	for(int i = 0; i < 10; i++) ol.add(i);
		ol.display();
		LinkedList<String> list = new LinkedList<String>();
		list.add("asd");
		list.add("zxczx");
		list.add("yhjj");
		list.add("asd qwe rty yui");
		list.add("samrt");
		list.add("b");
		list.add("c");
		list.add("oi");
		Collections.sort(list);
		for(String t : list)System.out.print(t + " | ");
	}
	
	@Test
	public void deleteTrue() {
		OrderedList ol = new OrderedList(true);
	for(int i = 0; i < 50;i++) 
		ol.add(i);
		ol.delete(50);
		ol.delete(50);
		ol.delete(35);
		ol.delete(0);
		ol.delete(49);
		assertTrue(ol.head.value.equals(1));
		assertTrue(ol.tail.value.equals(48));
		
	}
	
	@Test
	public void deleteFalse() {
		OrderedList ol = new OrderedList(false);
		for(int i = 0; i < 50;i++) 
		ol.add(i);
		ol.delete(50);
		ol.delete(35);
		ol.delete(0);
		ol.delete(49);
		ol.display();
		assertTrue(ol.head.value.equals(48));
		assertTrue(ol.tail.value.equals(1));
		ol.clear(false);
		ol.add(10);
		ol.add(5);
		ol.add(7);
		ol.display();
	}
	
	@Test
	public void findTrue() {
		OrderedList ol = new OrderedList(true);
	for(int i = 0; i < 50000000;i++)ol.add(i);
	assertNull(ol.find(-1));
	assertNull(ol.find(500000000));
	Node f = ol.find(4900000);
	assertTrue(f.value.equals(4900000));
	//	ol.find(999999);
	}
	
	
	@Test
	public void findFalse() {
		OrderedList ol = new OrderedList(true);
	for(int i = 0; i < 50000000;i++)ol.add(i);
	assertNull(ol.find(-1));
	assertNull(ol.find(500000000));
	Node f = ol.find(4900000);
	assertTrue(f.value.equals(4900000));
	//	ol.find(999999);
	}
	
	
	

}
