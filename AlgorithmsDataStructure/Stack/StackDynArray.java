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

	public void remove(int c) {
		stack[c] = null;
		for (int i = c + 1; i < count; i++) {
			stack[i - 1] = stack[i];
		}
	}

	public T pop() {
		if (count > 0) {
			T res = top;
			count--;
			remove(count);
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

	public void push(T val) {
		try {
			stack[count] = val;
			top = (T) stack[count];
		} catch (Exception e) {
			// TODO: handle exception
			makeArray(capacity*2);
			stack[count] = val;
			top = (T) stack[count];
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