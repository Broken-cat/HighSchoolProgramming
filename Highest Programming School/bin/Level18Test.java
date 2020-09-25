
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
