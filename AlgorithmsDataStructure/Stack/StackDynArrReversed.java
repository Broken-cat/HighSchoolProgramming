package Stack;

import java.util.*;

public class StackReversed<T> {

	public Object[] stack;
	private int capacity;
	private int count;
	private T top;

	public StackReversed() {
		makeArray(16);
		count = 0;
		top = null;
	}

	public int size() {
		return count;
	}

	public void remove() {
		stack[0] = null;
		for (int i = 1; i <= count; i++) {
			stack[i - 1] = stack[i];
		}
		stack[count]=null;
	}

	public T pop() {
		if (count > 0) {
			T res = top;
			count--;
			remove();
			try {
				top = (T) stack[count - 1];
			} catch (Exception e) {
				return res;
			}

			return res;
		}
		return null;
	}

	public void makeArray(int new_capacity) {
		try {
			stack = Arrays.copyOf(stack, new_capacity);
			capacity = new_capacity;
		} catch (Exception e) {
			// TODO: handle exception
			stack = new Object[new_capacity];
			capacity = new_capacity;
		}
	}
	
	public void moveArray() {
		for(int i = count;i > 0;i--) {
			stack[i] = stack[i-1]; 
		}
	}

	public void push(T val) {
		try {
			moveArray();
			stack[0] = val;
			top = (T) stack[0];
		} catch (Exception e) {
			// TODO: handle exception
			makeArray(capacity*2);
			moveArray();
			stack[0] = val;
			top = (T) stack[0];
		}
		count++;
	}

	public T peek() {
		if (count > 0)
			return top;
		return null;
	}

	public void display() {
		for (Object val : stack)
			System.out.print(String.valueOf(val) + " ");
		System.out.println();
	}
}