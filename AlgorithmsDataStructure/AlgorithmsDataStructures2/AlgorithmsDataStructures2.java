package AlgorithmsDataStructures2;

import java.util.*;

public class AlgorithmsDataStructures2 {
	public static int[] GenerateBBSTArray(int[] a) {
		Arrays.sort(a);
		int[] res = new int[a.length];
		sortedArrayToBST(res, a, 0, 0, a.length);
		return res;
	}

	static int[] sortedArrayToBST(int[] res, int[] arr, int i, int start, int end) {
		try {
		int mid = (start + end) / 2;
		res[i] = arr[mid];
			sortedArrayToBST(res, arr, 2 * i + 1, start, mid - 1);
			sortedArrayToBST(res, arr, 2 * i + 2, mid + 1, end);
		} catch (Exception e) {
			// TODO: handle exception
			return res;
		}
		return res;
	}
}