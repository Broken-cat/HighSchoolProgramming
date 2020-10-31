public class Stack<T> implements StackBeh<T>
{
	
	  public LinkedList<T> stack;
	  private int count;
	  private T top;
	  
      public Stack()
      {
    	  stack = new LinkedList<>();
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
    	   stack.remove(count);
    	   try {
    		   top = stack.get(count-1);
    	   } catch (Exception e) {
			  return res;
    	   }
    	   
    	   return res;
       }
       return null;  
      }
	  
      public void push(T val)
      {
    	  if(val == null)return;
    	  top = val;
    	  stack.add(val);
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

interface StackBeh<T> {
	T pop();
	void push(T val);
	T peek();
	int size();
}
