package LinkedListGit;

import java.util.ArrayList;

public class LinkedListTests {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.addInTail(new Node(15));
		ll.addInTail(new Node(16));
		ll.addInTail(new Node(17));
		ll.addInTail(new Node(15));
		ll.addInTail(new Node(16));
		ll.addInTail(new Node(16));
		ll.addInTail(new Node(25));
		ll.display();
		ll.insertAfter(new Node(25), new Node(88));
		ll.insertAfter(new Node(88), new Node(35));
		ll.removeAll(15);
		ll.display();
		ll.Remove(25);
		ll.showHead();
		ll.display();
		ll.Remove(16);
		ll.showHead();
		ll.display();
		Node find = ll.find(35);
		System.out.println(find.value);
		System.out.println("count: " + ll.count());
		ll.clear();
		ll.display();
		System.out.println("count: " + ll.count()); //0
		Node find2 = ll.find(35);
		ArrayList<Node> ar = ll.findAll(0);
		
		//System.out.println(find2.value); // nullPointerException
		//System.out.println(find2.value); // nullPointerException
		LinkedList l2 = new LinkedList();
		l2.addInTail(new Node(15));
		l2.addInTail(new Node(16));
		l2.addInTail(new Node(17));
		l2.addInTail(new Node(15));
		l2.addInTail(new Node(16));
		l2.addInTail(new Node(16));
		l2.addInTail(new Node(25));
		
		LinkedList l4 = new LinkedList();
		l4.addInTail(new Node(15));
		l4.addInTail(new Node(16));
		l4.addInTail(new Node(17));
		l4.addInTail(new Node(15));
		l4.addInTail(new Node(16));
		l4.addInTail(new Node(16));
		l4.addInTail(new Node(25));
		System.out.println(l2.count() + " " + l4.count());
		
		LinkedList l3 = new LinkedList();
		l3 = l3.summLists(l2, l4);
		l3.display();
	}
}
