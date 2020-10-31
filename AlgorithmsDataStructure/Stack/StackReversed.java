package Stack;

import java.util.*;

public class StackReversed<T>
{
	
	  public List<T> stack;
	  private int count;
	  private T top;
	  
      public StackReversed()
      {
    	  stack = new ArrayList<>();
    	  count = 0;
    	  top = null;
      } 

      public int size() 
      {
       return count;
      }

      public T pop()
      {
       if(count > 0) {
    	   T res = top;
    	   count--;
    	   stack.remove(0);
    	   try {
    		   top = stack.get(0);
    	   } catch (Exception e) {
			  return res;
    	   }
    	   
    	   return res;
       }
       return null;  
      }
	  
      public void push(T val)
      {	  
    	  for(int i = count; i> 0;i--) {
    		  stack.add(i, stack.get(i-1));
    	  }
    	 stack.add(0, val);
    	//  stack.add(val);
    	  top = stack.get(0);
    	  count++;
      }

      public T peek()
      {
       if (count > 0)return top;
       return null; 
      }
      
      public void display() {
    	  for(T val : stack)
    		  System.out.print(val + " ");
    	  System.out.println();
      }
}