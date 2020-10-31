package Stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitStack {

	@Test
	public void Push() {
		Stack s = new Stack<>();
		for(int i = 0; i < 10000; i++)s.push(i);
		for(int i = 0; i < 10000; i++)s.pop();
	}
	
	
	@Test
	public void Pop() {
		Stack s = new Stack<>();
		s.push(new Integer(8));
		s.push(new String("raz"));
		s.push(true);
		s.display();
		s.pop();
		s.display();
		s.push(new String("dva"));
		s.push(false);
		s.push(true);
		s.display();
		s.pop();
		s.display();
		s.pop();
		s.display();
	}
	
	@Test
	public void peek() {
		Stack s = new Stack<>();
		s.push(new Integer(8));
		s.push(new String("raz"));
		s.push(true);
		s.display();
		s.peek();
		s.display();
		s.push(new String("dva"));
		s.push(false);
		s.push(true);
		s.display();
		s.pop();
		s.display();
		s.peek();
		s.display();
	}
	
	

}
