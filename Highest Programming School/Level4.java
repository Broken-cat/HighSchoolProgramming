
public class Level4 {

	
	static int[] MadMax(int N, int[] Tele) {
		int k = Tele.length;
		Tele = increaseArray(N, Tele);
		for (int i = k ; i < Tele.length; i++) {
			for (int j = 0; j < 256; j++) {
				if (checkInt(j, Tele)) {
					continue;
				} else {
					Tele[i] = j;
				}
			}
		 }
		 sortDown(N, Tele);
		 return sortUp(N, Tele);
	}

	static int[] increaseArray(int N, int[] Tele) {
		int[] test = new int[N];
		for (int i = 0; i < test.length; i++) {
			try {
				test[i] = Tele[i];
			} catch (Exception e) {
				// TODO: handle exception
				test[i] = -1;
			}

		}
		return test;
	}

	static boolean checkInt(int a, int[] Tele) {
		for (int i = 0; i < Tele.length; i++) {
			if (Tele[i] == a)
				return true;
		}
		return false;
	}

	static int[] sortDown(int N, int[] array) {
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < N - 1; i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false;
				}
			}
		}
		return array;
	}

	static int[] sortUp(int N, int[] array) {
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = N / 2; i < N - 1; i++) {
				if (array[i] < array[i + 1]) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false;
				}
			}
		}
		return array;

	}
}
