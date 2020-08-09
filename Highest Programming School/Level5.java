
public class Level1 {

	static int[] SynchronizingTables(int N, int[] ids, int[] salary) {
		int[] tmpIdx = new int[N];
		for (int i = 0; i < N; i++) {
			tmpIdx[i] = ids[i];
		}
		sortDown(N, tmpIdx);
		sortDown(N, salary);
		while(!isEquals(tmpIdx, ids)) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(tmpIdx[j] == ids[i]) {
						int tmp = tmpIdx[j];
						int tmp2 = salary[j];
						tmpIdx[j] = tmpIdx[i];
						salary[j] = salary[i];
						tmpIdx[i] = tmp;
						salary[i] = tmp2;
					}
				}
			}
		}
		return salary;
	}
	
	static boolean isEquals(int[] ar1, int[] ar2) {
		for (int i = 0; i < ar2.length; i++) {
			if(ar1[i] != ar2[i])return false;
		}
		return true;
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
}
