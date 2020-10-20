
public class LinkedList2 {
	public Node head;
	public Node tail;

	public LinkedList2() {
		head = null;
		tail = null;
	}

	public void display() {
		Node current = this.head;
		System.out.print("Forward: ");
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
		current = this.tail;
		System.out.print("Backward: ");
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.prev;
		}
		System.out.println();
		System.out.println("Head --> " + this.head.value);
		System.out.println("Tail --> " + this.tail.value);
	}

	public void addInTail(Node _item) {
		if (head == null) {
			this.head = _item;
			this.head.next = null;
			this.head.prev = null;
		} else {
			this.tail.next = _item;
			_item.prev = tail;
		}
		this.tail = _item;
	}

	public Node find(int _value) {
		if (this.head == null)
			return null;
		Node current = this.head;
		while (current != null) {
			if (current.value == _value)
				return current;
			current = current.next;
		}
		return null;
	}

	public ArrayList<Node> findAll(int _value) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		if (this.head == null)
			return nodes;
		Node current = this.head;
		while (current != null) {
			if (current.value == _value)
				nodes.add(current);
			current.prev = current;
			current = current.next;
		}
		return nodes;
	}

	public boolean remove(int _value) {
		if (this.head == null)
			return false;
		if (this.head.value == _value) {
			this.head = this.head.next;
			return true;
		}
		if (this.tail.value == _value) {
			this.tail = this.tail.prev;
			this.tail.next = null;
			return true;
		}
		Node current = this.head;
		current.prev = null;
		while (current != null) {
			if (current.value == _value) {
				current.next.prev = current.prev;
				current.prev.next = current.next;
			}
			
			current = current.next;
		}
		return true;
	}

	public void removeAll(int _value) {
		if (this.head == null)
			return;		
		if (this.head == this.tail && this.head.value == _value) {
			this.tail = null;
			this.head = null;
			return;
		}
		Node current = this.head;
		while (current != null) {
			if (current.value != _value) {
				current = current.next;
			} else {
				if (this.head == current && this.head.value == _value) {
					if(this.head == this.tail) {
						this.head = null;
						return;
					}
					this.head.next.prev = null;
					this.head = current.next;
					current = current.next;
					continue;
				}
				if(this.tail == current && this.tail.value == _value) {
					this.tail.prev= current.prev;
					this.tail = current.prev;
					this.tail.next = null;
					return;
				}
				current.next.prev = current.prev;
				current.prev.next = current.next;
				current = current.next;
			}	
		}
	}

	public void clear() {
		if (this.head == null)
			return;
		Node current = this.head;
		while (current != null) {
			this.head = current.next;
			current = current.next;
		}
		this.tail = null;
	}
	public int count() {
		int count = 0;
		if (this.head == null)
			return count;
		Node current = this.head;
		while (current != null) {
			count++;
			current.prev = current;
			current = current.next;
		}
		System.out.println("count " + count);
		return count;
	}

	public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
		if (this.head == null) {
			addInTail(_nodeToInsert);
			return;
		}
		Node current = this.head;
		while(current != null) {
			if(_nodeAfter.value == this.tail.value) {
				this.tail.next = _nodeToInsert;
				_nodeToInsert.prev = this.tail;
				this.tail = _nodeToInsert;
				_nodeToInsert.next = null;
				return;
			}
			if(current.value == _nodeAfter.value) {	
				_nodeToInsert.next = current.next;
				current.next.prev = _nodeToInsert;
				current.next = _nodeToInsert;
				_nodeToInsert.prev = current;
				return;
			}
			current = current.next;
		}
	}
}

class Node
{
     public int value;
     public Node next;
     public Node prev;

     public Node(int _value) 
     { 
       value = _value; 
       next = null;
       prev = null;
     }
     
     public void display() {
    	 System.out.println(this.prev.value + " " + this.next.value);
     }
}
