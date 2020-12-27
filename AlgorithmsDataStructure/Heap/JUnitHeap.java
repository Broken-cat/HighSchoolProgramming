package Heap;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitHeap {

	@Test
	public void test() {
		int a[] = {99, 62, 72, 41, 58, 47, 42, 28};
		Heap h = new Heap();
		h.MakeHeap(a, 4);
		h.Add(26);
		h.Add(63);
		//insert into empty array
	}

}
