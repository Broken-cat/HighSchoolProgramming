
import java.util.*;

public class Level1 {

	static Stack<String> steck = new Stack<String>();
	public static Stack<String> removeDuplicates(Stack<String> list) {

		Stack<String> newList = new Stack<String>();

		for (String element : list) {
			if (!newList.contains(element)) {
				newList.add(element);
			}
		}
		return newList;
	}

	static String BiggerGreater(String input) {
		steck.clear();
		printPermutn(input, "");
		steck = removeDuplicates(steck);
		Stack<Integer> nums = new Stack<Integer>();
		int i = 0;
		Collections.sort(steck);
		while (i != steck.size()) {
			String tmp = steck.elementAt(i);
			int minDiff = tmp.compareTo(input);
			nums.push(minDiff);
			i++;
		}

		int resInx = steck.indexOf(input);
		String res = input;
		try {
			res = steck.elementAt(resInx + 1);
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			return "";
		}

		
	}

	static void printPermutn(String str, String ans) {
		steck.push(String.valueOf(str + ans));
		if (str.length() == 0) {
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			printPermutn(ros, ans + ch);
		}

	}

}
