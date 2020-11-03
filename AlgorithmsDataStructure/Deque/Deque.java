
public class Deque<T>
{
	
	private LinkedList<T> dequ;
	private int count;
	public T head;
	public T tail;
	
    public Deque()
    {
    	dequ = new LinkedList<>();
    	count = 0;
    	head = null;
    	tail = null;
    }

    public void addFront(T item)
    {
    	dequ.addLast(item);
    	head = dequ.peekLast();
    	count++;
    }

    public void addTail(T item)
    {
    	dequ.addFirst(item);
    	tail = dequ.peekFirst();
    	count++;
    }

 	public T removeFront() {
		if (count > 0) {
			T res = dequ.peekFirst();
			dequ.removeFirst();
			tail = dequ.peekFirst();
			count--;
			return res;
		}

		return null;
	}

	public T removeTail() {
		if (count > 0) {
			T res = dequ.peekLast();
			dequ.removeLast();
			head = dequ.peekLast();
			count--;
			return res;
		}
		return null;
	}
        
    public int size()
    {
     return count; 
    }
}
