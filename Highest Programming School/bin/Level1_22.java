
import java.util.*;
public class Level1 {


	static boolean SherlockValidString(String s) {
		char[] chars = s.toCharArray();
		Stack<Integer> nums = new Stack<Integer>();
		char ch = chars[0];
		int count = 0;
		int difChars = 1;
		for (int i = 0; i < chars.length; i++) {
			if (ch == chars[i])
				count++;
			else {
				difChars++;
				nums.push(count);
				count = 1;
				ch = chars[i];
			}
		}
		nums.push(count);
		int avgCount = findFrequent(nums);
		int possibleRemove = 1;
		for (Integer l : nums) {
			if (avgCount == l)
				continue;
			else {
				if (possibleRemove != 0 && (avgCount == l + 1 || avgCount == l - 1)) {
					possibleRemove--;
				} else {
					return false;
				}
			}
		}

		return true;
	}

	static int findFrequent(Stack<Integer> s) {
		int len = s.size();
		  int[] a = new int[s.size()];
		  for (int i = 0; i < len; i++)a[i] = s.elementAt(i);
		  int count = 1, tempCount;
		  int popular = a[0];
		  int temp = 0;
		  for (int i = 0; i < (a.length - 1); i++)
		  {
		    temp = a[i];
		    tempCount = 0;
		    for (int j = 1; j < a.length; j++)
		    {
		      if (temp == a[j])
		        tempCount++;
		    }
		    if (tempCount > count)
		    {
		      popular = temp;
		      count = tempCount;
		    }
		  }
		  return popular;
	}

}

