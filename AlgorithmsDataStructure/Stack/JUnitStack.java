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
		s.push(null);
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
	
	@Test
	public void balanced() {
		Stack s = new Stack<>();
		assertTrue(s.balanced("(()((())))()"));
	}
	
	      
	@Test
	  public void postFix() {
	  int res = 0;
	  String ex = "82+5*9+=";
	  char[] chrs = ex.toCharArray();
	  Stack<Character> sch = new Stack<Character>();
  	  Stack<Integer> nums = new Stack<Integer>();
  	  for(int i = 0; i < chrs.length;i++) {
  		  if(chrs[i] == '=') {
  			  res = nums.pop();
  			  return;
  		  }
  		  if(!tryParse(chrs[i])) {
  			  int a = nums.pop();
  			  int b = nums.pop();
  			  switch(chrs[i]) {
  			  case('+'):
  				  nums.push(a+b);
  			  break;
  			  case('*'):
  			  		nums.push(a*b);
  			  break;
  			  }
  		  } else {
  			sch.push(chrs[i]);
  			nums.push(Character.getNumericValue(chrs[i]));
  		  }
	
      
      public boolean balanced(String str) {
    	  char[] chrs = str.toCharArray();
    	  Stack<Character> st = new Stack<Character>();
    	  for(int i = 0; i < chrs.length; i++) {
    		  if(chrs[i] == '(') {
    			  st.push(chrs[i]);
    			  continue;
    		  }
    		  if(st.size() == 0)return false;
    		  if(chrs[i] == ')') {
    			  char poped = st.pop();
    		  } else {
    			  return false;
    		  }
    	  }
    	  return true;
      }

}
