package lvl21;

import java.nio.charset.StandardCharsets;
import java.util.*;

import sun.misc.IOUtils;

public class Level21Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tmp = "нклм";
		String lll = "вибк";
		String tmp2 = "вкиб";
		byte[] arr = tmp.getBytes();
		byte[] arr2 = tmp2.getBytes();
		byte[] arr3 = lll.getBytes();
		System.out.println("вибк".compareTo("викб"));// 9

		System.out.println(lll + " -> " + BiggerGreater(lll));
		System.out.println(tmp2 + " -> " + BiggerGreater(tmp2));
		System.out.println(tmp + " -> " + BiggerGreater(tmp));
		// System.out.println(Arrays.toString(arr3));
		// System.out.print(Arrays.toString(arr));
		// System.out.println("");
		// System.out.print(Arrays.toString(arr2));
		// System.out.println(BiggerGreater("вибк"));
	}

	static Stack<String> steck = new Stack<String>();

	public static Stack<String> removeDuplicates(Stack<String> list) {

		// Create a new ArrayList
		Stack<String> newList = new Stack<String>();

		// Traverse through the first list
		for (String element : list) {

			// If this element is not present in newList
			// then add it
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
		}

		return res;
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
