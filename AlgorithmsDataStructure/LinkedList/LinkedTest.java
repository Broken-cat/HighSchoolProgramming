import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedTest {

	@Test
	public void test() {
		LinkedList test = new LinkedList();
		test.addInTail(new Node(5));
		test.remove(5);
		test.remove(5);
		test.clear();
		for(int i = 0; i < 100000; i++)
			test.addInTail(new Node(i));
		test.removeAll(1);
		test.clear();
		test.removeAll(5);
		test.count();
		test.findAll(15);
		test.find(15);
		test.insertAfter(new Node(15), new Node(20));
		test.find(99999);
		test.count();
	}

}
