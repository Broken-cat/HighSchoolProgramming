package Queue;

import java.util.*;

public class QueueBasedStacks<T>
{
		
	  private int count;
	  private Stack<T> enqu;
	  private Stack<T> dequ;
      public QueueBasedStacks()
      {
    	  count = 0;
    	  enqu = new Stack<T>();
    	  dequ = new Stack<T>();
      } 

      public void enqueue(T item)
      {
    	  enqu.push(item);
    	  count++;
      }

      public T dequeue()
      {
    	if (count > 0 ) {
    		if(dequ.isEmpty())  
        		while(!enqu.isEmpty())
        			dequ.push(enqu.pop());
    	count--;
        return dequ.pop();
    	}
        return null;
      }

      public int size()
      {
        return count; 
      }

}