package DummyLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitDumTest {

	@Test
	public void AddInTail() {
		LinkedList link = new LinkedList();
		link.addInTail(new Node(15));
		link.addInTail(new Node(30));
		link.addInTail(new Node(45));
		link.addInTail(new Node(30));
		link.display();
	}
	
	@Test
	public void remove() {
		LinkedList link = new LinkedList();
		link.addInTail(new Node(15));
		link.addInTail(new Node(30));
		link.addInTail(new Node(45));
		link.addInTail(new Node(30));
		link.display();
		link.remove(30);
		link.display();
		link.insertAfter(new Node(15), new Node(50));
		link.insertAfter(new Node(50), new Node(65));
		link.insertAfter(new Node(45), new Node(45));
		link.display();
		link.insertAfter(new Node(65), new Node(70));
		link.display();
		link.addInTail(new Node(80));
		link.display();
		link.remove(15);
		link.remove(80);
		link.display();
	}
	
	@Test
	public void removeAll() {
		LinkedList link = new LinkedList();
		link.addInTail(new Node(15));
		link.addInTail(new Node(30));
		link.addInTail(new Node(45));
		link.addInTail(new Node(30));
		link.display();
		link.removeAll(30);
		link.display();
		link.insertAfter(new Node(15), new Node(50));
		link.insertAfter(new Node(50), new Node(65));
		link.insertAfter(new Node(45), new Node(45));
		link.display();
		link.insertAfter(new Node(65), new Node(70));
		link.display();
		link.addInTail(new Node(80));
		link.display();
		link.removeAll(15);
		link.removeAll(80);
		link.display();
	}
	
	@Test
	public void InsertAfter() {
		LinkedList link = new LinkedList();
		link.insertAfter(new Node(15), new Node(50));
		link.insertAfter(new Node(50), new Node(65));
		link.insertAfter(new Node(45), new Node(45));
		link.display();
		link.insertAfter(new Node(65), new Node(70));
		link.display();
		link.addInTail(new Node(80));
		link.display();
	}

}
