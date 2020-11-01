package Queue;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Test;

public class JUnitQueue {

	@Test
	public void enqueue() {
		Queue qu = new Queue();
		qu.enqueue(1);
		qu.enqueue("qwe");
		qu.enqueue(true);
		qu.enqueue(5);
		assertTrue(qu.dequeue().equals(1));
		assertTrue(qu.dequeue().equals("qwe"));
		qu.enqueue("asd");
		assertTrue(qu.dequeue().equals(true));
		qu.enqueue(false);
		assertTrue(qu.dequeue().equals(5));
		assertTrue(qu.dequeue().equals("asd"));
		assertTrue(qu.dequeue().equals(false));
		
	}
	
	
	@Test
	public void QueueBasedStacks() {
		QueueBasedStacks qu = new QueueBasedStacks();
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);
		qu.dequeue();
		qu.enqueue(5);
		Object s = qu.dequeue();
		assertTrue(s.equals(2));
		for(int i = 0; i < 3;i++)
			s = qu.dequeue();
	}

}
