package bin;

import java.util.Arrays;

public class Level18Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 19, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 2, 20 };
		int[] b = { 1, 3, 4, 5, 6, 2, 7 };
		// double timeStart = System.currentTimeMillis();
		System.out.println(Level1.MisterRobot(7, a));
		// double timeSpent = System.currentTimeMillis()-timeStart;
		// System.out.print("sec: " + timeSpent/1000);
	}

}

class Level1 {
	static boolean MisterRobot(int N, int[] data) {
		double timeStart = System.currentTimeMillis();		
		for (int i = 0; i < data.length; i++) {
			if ((i + 1) != data[i]) {
				while (!isSorted(data)) {
					int tmpInd = searchInd(i + 1, data);
					swipeLeft(data, tmpInd, tmpInd + 2);
					double timeSpent = System.currentTimeMillis() - timeStart;
					if (timeSpent/1000 >= 1)
						return false;

				}
			}
		}

		return true;
	}

	static int searchInd(int k, int[] data) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == k)
				return i;
		}
		return k;
	}

	static int[] swipeLeft(int[] data, int N, int E) {
		try {
			for (int i = N; i < E; i++) {
				int tmp = data[N - 2];
				data[N - 2] = data[N - 1];
				data[N - 1] = data[N];
				data[N] = tmp;
			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		return data;
	}

	static boolean isSorted(int[] array) {
		for (int i = 0; i < array.length - 1; i++)
			if (array[i] >= array[i + 1])
				return false;
		return true;
	}

}
