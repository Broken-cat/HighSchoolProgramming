package Stack;

import static org.junit.Assert.assertTrue;

import java.awt.*;
import java.util.ArrayList;

import org.junit.Test;

public class JUnitStackReversed {

	@Test
	public void push() {
		StackReversed s = new StackReversed<>();
		for(int i = 0; i < 10; i++)s.push(i);
		s.display();
	}
	
	@Test
	public void pop() {
		StackReversed s = new StackReversed<>();
		for(int i = 0; i < 10; i++)s.push(i);
		s.display();
		s.pop();
		s.display();
	}
	
	@Test
	public void genArr() {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(9);
		list.add(true);
		list.add("wow");
		
		Object[] a = new Object[3];
		for(int i =0;i < 3; i++) {
			Class clazz = list.get(i).getClass();
			a[i] = list.get(i).getClass();
		}
		
		
		
		
	}

}
