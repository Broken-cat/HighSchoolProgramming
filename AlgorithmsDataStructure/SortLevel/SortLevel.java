

public class SortLevel {

	public static void SelectionSortStep(int array[], int i) {
		int temp = array[i];
		int min = findMin(array, i);
		array[i] = array[min];
		array[min] = temp;
	}

	public static int findMin(int array[], int from) {
		int min = array[from];
		for (int i = from; i < array.length; i++) {
			if (array[min] > array[i])
				min = i;
		}
		return min;
	}

	public static boolean BubbleSortStep(int array[]) {
		boolean result = false;
		for (int i = 0; i < array.length; i += 2) {
			if (array[i] > array[i + 1]) {
				result = true;
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
		}
		return result;
	}

	public static void InsertionSortStep(int[] array, int step, int i) {
			for(int k = i+step; k < array.length; k+=step) {
				int key = array[k];
				int ind = k-step;
				while (ind >= 0 && array[ind] > key && ind >= i) {
					array[ind+step] = array[ind];
					ind-=step;
				}
				array[ind+step]=key;
			}
	}
	
	public static ArrayList KnuthSequence( int array_size ) {
		ArrayList sequence = new ArrayList();
		int n = 1;
		sequence.add(n);
		while (3*n+1 < array_size) {
			n = 3 * n + 1;
			sequence.add(0, n);
		}
		return sequence;
	}
	
	public static void ShellSort(int array_size, int array[]) {
		ArrayList<Integer> list = KnuthSequence(array_size);
		for(int i : list) {
			for(int k = 0; k < i; k++) {
				InsertionSortStep(array, i, k);
			}
		}
	}

	public static void swap(int i, int j, int array[]) {
		if (array[i] < array[j]) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
}
