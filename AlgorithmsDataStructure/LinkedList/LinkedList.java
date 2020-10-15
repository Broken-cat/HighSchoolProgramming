

public class LinkedList {
	public Node head;
	public Node tail;

	public LinkedList() {
		head = null;
		tail = null;
	}

	public void display() {
		System.out.print("List (head ---> tail): ");
		Node current = this.head;
		while (current != null) {
			current.display();
			current = current.next;
		}
		System.out.println();
		showHead();
		showTail();
	}

	public void addInTail(Node item) {
		if (this.head == null)
			this.head = item;
		else
			this.tail.next = item;
		this.tail = item;
	}

	public Node find(int value) {
		Node node = this.head;
		while (node != null) {
			if (node.value == value)
				return node;
			node = node.next;
		}
		return null;
	}

	public ArrayList<Node> findAll(int _value) {
		if (this.head == null)
			return null;
		ArrayList<Node> nodes = new ArrayList<Node>();
		Node current = this.head;
		while (current != null) {
			if (current.value == _value) {
				nodes.add(current);
			}
			current = current.next;
		}
		return nodes;
	}

	public void showHead() {
		System.out.println("Head --> " + this.head.value);
	}

	public void showTail() {
		System.out.println("Tail --> " + this.tail.value);
	}

	public boolean remove(int _value) {
		if (this.head == null)
			return false;
		Node current = this.head;
		if (current.value == _value) {
			this.head = current.next;
			return true;
		}
		Node previous = current;
		while (current != null) {
			if (current.value != _value) {
				previous = current;
				current = current.next;
			} else {
				if(this.tail.value == _value && this.tail == current) 
					this.tail = previous;
				current = current.next;
				previous.next = current;
				return true;
			}
		}
		return false;
	}

	public void removeAll(int _value) {
		if (this.head == null)
			return;
		Node current = this.head;
		Node previous = current;
		while (current != null) {
			if (current.value != _value) {
				previous = current;
				current = current.next;
			} else {
				if (this.head.value == _value && this.head == current)
					this.head = current.next;
				if(this.tail.value == _value && this.tail == current)
					this.tail = previous;
				current = current.next;
				previous.next = current;
			}
		}
	}

	public void clear() {
		Node current = this.head;
		while (current != null) {
			this.head = current.next;
			current = current.next;
		}
	}

	public int count() {
		Node current = this.head;
		int count = 0;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
		if (this.head == null)
			return;
		Node current = this.head;
		while (current != null) {
			if (current.value == _nodeAfter.value) {
				Node tmp = current.next;
				current.next = _nodeToInsert;
				_nodeToInsert.next = tmp;
				if (current == this.tail)
					this.tail = _nodeToInsert;
				break;
			}
			current = current.next;
		}
	}

	public LinkedList summLists(LinkedList _l1, LinkedList _l2) {
		LinkedList result = new LinkedList();
		if (_l1.count() == _l2.count()) {
			Node nodeL1 = _l1.head;
			Node nodeL2 = _l2.head;
			while (nodeL1 != null) {
				result.addInTail(new Node(nodeL1.value + nodeL2.value));
				nodeL1 = nodeL1.next;
				nodeL2 = nodeL2.next;
			}
			return result;
		}
		return null;
	}
}


class Node {
	public int value;
	public Node next;
	public Node prev;
	public Node(int _value) {
		value = _value;
		next = null;
		prev = null;
	}
	
	public void display() {
		System.out.print(value + " ");
	}
}
