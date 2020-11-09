
class Node<T> {
	public T value;
	public Node<T> next, prev;

	public Node(T _value) {
		value = _value;
		next = null;
		prev = null;
	}
}

public class OrderedList<T extends Comparable<T>> implements Comparator<T>{
	public Node<T> head, tail;
	private boolean _ascending;
	private int count;
	private T max, min;
	public OrderedList(boolean asc) {
		count = 0;
		head = null;
		tail = null;
		_ascending = asc;

	}

	boolean getAscenging() {
		return _ascending;
	}

	/*public void display() {
		Node<T> current = this.head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
		System.out.println("head: " + this.head.value);
		System.out.println("tail: " + this.tail.value);
		System.out.println("min: " + min + " " + "max: " + max + " count: " + count);

	}*/

	public int compare(T v1, T v2) {
		return (v1.compareTo(v2));
	}

	public void add(T value) {
		Node<T> nodeToAdd = new Node<T>(value);
		Node<T> current = this.head;
		if (this.head == null) {
			addInTail(nodeToAdd);
			max = this.head.value;
			min = this.head.value;
			count++;
			return;
		}
		if (compare(nodeToAdd.value, min) < 0 || compare(nodeToAdd.value, max) > 0) {
			if (_ascending) {
				if (compare(nodeToAdd.value, this.head.value) > 0)
					addInTail(nodeToAdd);
				else
					addInHead(nodeToAdd);
				min = this.head.value;
				max = this.tail.value;
			} else {
				if (compare(nodeToAdd.value, this.head.value) > 0)
					addInHead(nodeToAdd);
				else
					addInTail(nodeToAdd);
				min = this.tail.value;
				max = this.head.value;

			}
			count++;
			return;
		}

		if(!_ascending) {
			while (current.next != null) {
				if ((compare(nodeToAdd.value, current.value) < 0 && compare(nodeToAdd.value, current.next.value) > 0)
						|| (compare(current.value, nodeToAdd.value) == 0))
					break;
				current = current.next;
			}
		} else {
			while (current.next != null) {
				if ((compare(nodeToAdd.value, current.value) > 0 && compare(nodeToAdd.value, current.next.value) < 0)
						|| (compare(current.value, nodeToAdd.value) == 0))
					break;
				current = current.next;
			}
		}
		
		insertAfter(current, nodeToAdd);
		count++;
	}

	public void insertAfter(Node<T> _nodeAfter, Node<T> _nodeToInsert) {
		Node<T> current = this.head;
		while (current != null) {
			if (_nodeAfter.value == this.tail.value) {
				this.tail.next = _nodeToInsert;
				_nodeToInsert.prev = this.tail;
				this.tail = _nodeToInsert;
				_nodeToInsert.next = null;
				return;
			}
			if (current.equals(_nodeAfter)) {
				_nodeToInsert.next = current.next;
				current.next.prev = _nodeToInsert;
				current.next = _nodeToInsert;
				_nodeToInsert.prev = current;
				return;
			}
			current = current.next;
		}
	}

	public void addInHead(Node<T> _item) {
		this.head.prev = _item;
		_item.next = head;
		this.head = _item;
		if (_ascending)
			min = this.head.value;
		else
			max = this.head.value;
	}

	public void addInTail(Node<T> _item) {
		if (head == null) {
			this.head = _item;
			this.head.next = null;
			this.head.prev = null;

		} else {
			this.tail.next = _item;
			_item.prev = tail;
		}
		this.tail = _item;
		if (_ascending)
			max = this.tail.value;
		else
			min = this.tail.value;
	}

	public Node<T> find(T val) {
		if(this.head == null || compare(val, max) > 0 || compare(val, min) < 0)return null;
		Node<T> current = this.head;
		while (!current.value.equals(val))
			current = current.next;
		return current;
	}

	public void delete(T val) {
		if (this.head == null || compare(val, max) > 0 || compare(val, min) < 0)
			return;
		if (this.head.equals(this.tail)) {
			this.head = null;
			this.tail = null;
			count--;
			return;
		}
		Node<T> current = this.head;
		while (current != null) {
			if (current.value.equals(val)) {

				if (current.equals(this.head)) {
					this.head = head.next;
					this.head.prev = null;
					count--;
					if(_ascending)min = this.head.value;
					else max = this.head.value;
					return;
				}
				if (current.equals(this.tail)) {
					this.tail = this.tail.prev;
					this.tail.next = null;
					count--;
					if(_ascending)max = this.tail.value;
					else min = this.tail.value;
					return;
				}
				current.prev.next = current.next;
				current.next.prev = current.prev;
				count--;
				return;
			}

			current = current.next;
		}
		count--;
	}

	public void clear(boolean asc) {
		_ascending = asc;
		if (this.head == null)
			return;
		Node<T> current = this.head;
		while (current != null) {
			this.head = current.next;
			current = current.next;
		}
		this.tail = null;
		count = 0;
	}

	public int count() {
		return count;
	}

	ArrayList<Node<T>> getAll() {
		ArrayList<Node<T>> r = new ArrayList<Node<T>>();
		Node<T> node = head;
		while (node != null) {
			r.add(node);
			node = node.next;
		}
		return r;
	}
}
