package DummyLinkedList;

public class DummyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	}

}
