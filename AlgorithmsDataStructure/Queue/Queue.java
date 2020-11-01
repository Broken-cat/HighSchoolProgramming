package Queue;

import java.util.Arrays;
import java.util.LinkedList;

public class Queue<T> implements QueueBeh<T>
{
	
	  private int count;
	  private LinkedList<T> queue;
	  private T top;
	  
      public Queue()
      {
    	  queue = new LinkedList<T>();
    	  count = 0;
      } 

      public void enqueue(T item)
      {
        queue.add(item);
        top = queue.peekFirst();
        count++;
      }

      public T dequeue()
      {
    	if(count > 0) {
    		T last = queue.peekFirst();
    		queue.removeFirst();
    		top = queue.peekFirst();
    		count--;
            return last;	
    	}
        return null; 
      }

      public int size()
      {
        return count;
      }
      
      public void round(int N) {
    	  Object[] arr = queue.toArray();
    	  int len = arr.length-1;
    	  for(int i = 0; i < N; i++) {
    		  Object last = arr[len];
    		  for(int j = len; j >0; j--) {
    			  arr[j]=arr[j-1];
    		  }
    		  arr[0] = last;
    	  }
    	  queue = new LinkedList(Arrays.asList(arr));
    	  top = queue.peekFirst();
      }

}

interface QueueBeh<T> {
	void enqueue(T item);
	T dequeue();
	int size();
}