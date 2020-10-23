package DummyLinkedList;

public class Node {
	public int value;
	public Node next;
	public Node prev;

	public Node(int _value) {
		value = _value;
		next = null;
		prev = null;
	}
	
	public Node() {
		next = null;
		prev = null;
	}

	public void display() {
		System.out.println(this.prev.value + " " + this.next.value);
	}
}



