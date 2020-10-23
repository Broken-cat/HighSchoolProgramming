package DummyLinkedList;

import java.util.ArrayList;

public class LinkedList {
	public DummyNode dummyHead;
	public DummyNode dummyTail;

	public LinkedList() {
		dummyHead = new DummyNode();
		dummyTail = new DummyNode();
		this.dummyHead.next = this.dummyTail;
		this.dummyTail.prev = this.dummyHead;
	}

	public void display() {
		Node current = this.dummyHead.next;
		System.out.print("Forward: ");
		while (current != this.dummyTail) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
		current = this.dummyTail.prev;
		System.out.print("Backward: ");
		while (current != this.dummyHead) {
			System.out.print(current.value + " ");
			current = current.prev;
		}
		System.out.println();
		System.out.println("Head --> " + this.dummyHead.next.value);
		System.out.println("Tail --> " + this.dummyTail.prev.value);
		System.out.println("Count --> " + this.count());
	}

	public void addInTail(Node _item) {
		if (this.dummyHead.next instanceof DummyNode) {
			this.dummyHead.next = _item;
			_item.prev = this.dummyHead;
		}		
			_item.prev = this.dummyTail.prev;
			this.dummyTail.prev.next = _item;
			_item.next = this.dummyTail;
			this.dummyTail.prev = _item;
	}

	public Node find(int _value) {
		if (this.dummyHead.next instanceof DummyNode)
			return null;
		Node current = this.dummyHead.next;
		while (current instanceof Node) {
			if (current.value == _value)
				return current;
			current = current.next;
		}
		return null;
	}

	public ArrayList<Node> findAll(int _value) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		if (this.dummyHead.next instanceof DummyNode)
			return nodes;
		Node current = this.dummyHead.next;
		while (current instanceof Node) {
			if (current.value == _value)
				nodes.add(current);
			current.prev = current;
			current = current.next;
		}
		return nodes;
	}

	public boolean remove(int _value) {
		Node current = this.dummyHead.next;
		while (current != this.dummyTail) {
			if (current.value == _value) {
				current.next.prev = current.prev;
				current.prev.next = current.next;
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void removeAll(int _value) {
		Node current = this.dummyHead.next;
		while (current instanceof Node) {
			if (current.value == _value) {
				current.prev.next = current.next;
				current.next.prev = current.prev;
				if(current.prev instanceof DummyNode)
						this.dummyHead.next = current.next;
				if (current.next instanceof DummyNode)
					this.dummyTail.prev = current.prev;
			}
			current = current.next;
		}
	}

	public void clear() {
		this.dummyHead.next = this.dummyTail;
		this.dummyTail.prev = this.dummyHead;
	}

	public int count() {
		int count = 0;
		if (this.dummyHead.next == this.dummyTail)
			return count;
		Node current = this.dummyHead.next;
		while (current instanceof Node) {
			count++;
			current = current.next;
		}
		return --count;
	}

	public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
		Node current = this.dummyHead.next;
		while (current instanceof Node) {
			if (current.value == _nodeAfter.value) {
				current.next.prev = _nodeToInsert;
				if(current.next instanceof DummyNode) 
					this.dummyTail.prev = _nodeToInsert;
				_nodeToInsert.next = current.next;
				current.next = _nodeToInsert;
				_nodeToInsert.prev = current;
				
				current = current.next;
			}
			current = current.next;
		}
	}
}
