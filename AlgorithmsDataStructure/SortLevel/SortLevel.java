
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
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		
	}
	
	public static void QuickSort( int[] array, int left, int right ) {
		if(left < right){
			int N = ArrayChunk(array, left, right);
			QuickSort(array, left, N-1);
			QuickSort(array, N+1, right);
		}
	}
	
	static int count = 0;
	public static void QuickSortTailOptimization( int[] array, int left, int right ) {
		++count;
		while(left < right){
			int N = ArrayChunk(array, left, right);
			if(left - N < right - N) {
				QuickSortTailOptimization(array, left, N-1);
				left = N+1;
			} else {
				QuickSortTailOptimization(array, N+1, right);
				right = N-1;
			}
			
		}
	}

	
	public static int ArrayChunk( int[] M , int left, int right) {
		int middle = (left+right)/2;
		
		int N = M[middle];
		int i1 = left;
		int i2 = right;
		while(true) {
			
			while(M[i1] < N) {
				i1++;
			}
			while(M[i2] > N) {
				i2--;
			}

			if(i1 == i2-1 && M[i1] > M[i2]) { 
				swap(i1, i2, M);
				N = M[middle];
				i1 = 0;
				i2 = right;
				continue;
				
			}
			if(i1 == i2 || (i1==i2-1 && M[i1] < M[i2])) {
				return i2;
			}
			swap(i1, i2, M);
			if(M[i1] == N)middle = i1;
			if(M[i2] == N)middle = i2;
		}	
	}
	
		
	public static ArrayList KthOrderStatisticsStep( int[] Array, int L, int R, int k ) {
		ArrayList result = new ArrayList<>();
		int N = ArrayChunk(Array, L, R);
		while(N != k) { 
			N = ArrayChunk(Array, L, R);
		if(N < k) 
			L++;
		if(N > k)
			R--;
		}
		result.add(L);
		result.add(R);
		return result;
	}
	
}
