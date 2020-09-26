
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
		Collections.sort(s);
		int comparableInt = s.elementAt(0);
		int tmpMax = 0;	
		int k = 1;
		for (Integer i : s) {
			if (comparableInt == i) {
				k++;
			} else {
				if (k > tmpMax) {
					tmpMax = k;
					comparableInt = s.elementAt(i-1);
				} else {
					k = 0;
				}
				
			}
		}
		return comparableInt;
	}

}
