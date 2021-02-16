

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

	
	public static void QuickSort( int[] array, int left, int right ) {
		System.out.println(++count);
		if(left < right){
			int N = ArrayChunk(array, left, right);
			System.out.println(Arrays.toString(array) + " " + left + " " + right);
			QuickSort(array, left, N-1);
			QuickSort(array, N+1, right);
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
		 if(N != k) { 
		if(N < k) 
			L=++N;
		if(N > k)
			R=--N;
		}
		result.add(L);
		result.add(R);
		return result;
	}
	
	static ArrayList temp = new ArrayList();
	public static ArrayList MergeSort(ArrayList arr) {
		ArrayList result = new ArrayList();
		if(temp.size() == 1) {
			result.add(arr.get(0));
			return result;
		}
		int arr2[] = new int[arr.size()];
		for(int i = 0; i < arr.size(); i++)
			arr2[i] = (int)arr.get(i);
		int len = arr2.length;
		divideRec(arr2, temp);
		for(int i = 0; 0 < temp.size(); i+=2) {
			 int[] tempArr = takeMinAndMakeem((int[])temp.get(i), (int[])temp.get(i+1));
			if(tempArr.length == len) {
				for(int j = 0; j < len; j++)
					result.add(tempArr[j]);
				break;
			}
			temp.add(tempArr);
		}
		return result;
		
	}
	
	public static void divideRec(int arr[], ArrayList list) {
		int[] L =new int [(arr.length+1)/2], R = new int[arr.length/2];
		if(arr.length != 1)	{
			System.arraycopy(arr, 0, L, 0, (arr.length+1)/2);
			System.arraycopy(arr, (arr.length+1)/2, R, 0, arr.length/2);
			divideRec(L, list);
			divideRec(R, list);
		} else {
			list.add(arr);
		}
	}
	
	public static  int[] takeMinAndMakeem(int[] ar1, int[] ar2) {
		int[] res = new int [ar1.length + ar2.length];
		int[] tmp = new int[ar1.length + ar2.length];
		System.arraycopy(ar1, 0, tmp, 0, ar1.length);
		int index = 0;
		ArrayList<Integer> left = new ArrayList<Integer>();
		for(int i = 0; i < ar1.length; i++)
			left.add(ar1[i]);
		ArrayList<Integer> right = new ArrayList<Integer>();
		for(int i = 0; i < ar2.length; i++)
			right.add(ar2[i]);
		while(left.size() != 0 && right.size() != 0) {
			if(left.get(0) <= right.get(0)) {
				res[index] = (left.get(0));
				left.remove(0);
				index++;
			} else {
				res[index] = (right.get(0));
				right.remove(0);
				index++;
			}
		}	
		if(left.size() == 0 && right.size() != 0) {
			for(int j = 0; j < right.size(); j++) {
				res[index] = (right.get(j));
				index++;
			}
		}
		if(left.size() != 0 && right.size() == 0) {
			for(int j = 0; j < left.size(); j++) {
				res[index] = (left.get(j));
				index++;
			}
		}
		return res;
	}
	
	
	
	public static int factTail(int n, int a) {
		System.out.println(a + " " + n);
		if(n < 0)return 0;
		if(n == 0)return 1;
		if(n == 1)return a;
		return factTail(n-1, n*a);
	}
	
	public static int fact (int n) {
		if (n == 0)
			return 1;
		return n * fact(n-1);
	}
	
}
