package LinkedList2;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LinkedList2JUNIT {

	int k = 5000000;
	int m = 8;
	
	@Test
	public void remove() throws InterruptedException {
		LinkedList2	linked = new LinkedList2();
		for(int i = 0; i < k;i++)
			linked.addInTail(new Node(i));
	//	linked.display();
		
		linked.remove(k-1);
			
		//linked.display();
	}
	
	@Test 
	public void removeAll() {
		LinkedList2	linked = new LinkedList2();
		for(int i = 0; i < k;i++)
			linked.addInTail(new Node(i));
		linked.removeAll(66666);
	}
	
	@Test
	public void find() {
		LinkedList2	linked = new LinkedList2();
		for(int i = 0; i < k;i++)
			linked.addInTail(new Node(i));
		linked.find(k-1);
	}
	
	@Test
	public void findAll() {
		LinkedList2	linked = new LinkedList2();
		for(int i = 0; i < 500;i++)
			linked.addInTail(new Node(i));
		linked.findAll(499);
		linked.findAll(498);
		linked.display();
	}
	
	@Test
	public void count() {
		LinkedList2	linked = new LinkedList2();
		for(int i = 0; i < k;i++)
			linked.addInTail(new Node(i));
		linked.count();
	}
	
	@Test 
	public void clear() {
		LinkedList2	linked = new LinkedList2();
		for(int i = 0; i < 1000;i++)
			linked.insertAfter(new Node(i), new Node(i+1));
		//linked.clear();
		linked.find(20000);
		linked.findAll(22000);
	//	linked.display();
		linked.remove(1);
		//linked.display();
		linked.removeAll(999);
		linked.count();
		linked.display();
		
	}
	
	@Test
	public void insertAfter() {
		LinkedList2	linked = new LinkedList2();
		for(int i = 0; i < 50000000;i++)
			linked.insertAfter(new Node(i), new Node(i+1));
		linked.removeAll(1);
		linked.remove(2);
		linked.removeAll(50000000);
	//	linked.display();
	}

}
