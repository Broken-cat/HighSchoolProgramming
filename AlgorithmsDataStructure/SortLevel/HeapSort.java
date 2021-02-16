package SortLevel;


public class HeapSort {
	public Heap HeapObject;
	
	public HeapSort(int[] arr) {
		HeapObject = new Heap();
		int dep = getDepth(arr.length);
		HeapObject.MakeHeap(arr, dep);
	}
	
	public int getDepth(int len) {
		int temp = 0;
		int index = 0;
		while(temp < len) {
			temp += (int) Math.pow(2, index);
			index++;
		}
		return --index;
	}
	
	public int GetNextMax() {
		while(HeapObject.GetMax() != -1) {
		}
		return -1;
	}
}




class Heap {
	public int[] HeapArray;

	public Heap() {
		HeapArray = null;
	}

	public void MakeHeap(int[] a, int depth) {
		int heap_size = 0;
		for (int i = 0; i <= depth; i++)
			heap_size += (int) Math.pow(2, i);
		HeapArray = new int[heap_size];
		for (int i = 0; i < heap_size; i++)
			HeapArray[i] = -1;
		for (int i = 0; i < a.length; i++)
			Add(a[i]);
	}

	
	public int GetMax() {
		if (HeapArray[0] == -1)
			return -1;
		int i = -1;
		int res = HeapArray[0];
		try {
			while (HeapArray[i + 1] >= 0 && i < HeapArray.length)
				i++;
		} catch (Exception e) {
			// TODO: handle exception
		}

		HeapArray[0] = HeapArray[i];
		HeapArray[i] = -1;
		i = 0;
		int k;
		if (HeapArray[2 * i + 1] > HeapArray[2 * i + 2])
			k = 1;
		else
			k = 2;
		if (HeapArray[0] > HeapArray[1] && HeapArray[0] > HeapArray[2])
			return HeapArray[0];
		else
			recArray(HeapArray, i);
		return res;
		// вернуть значение корня и перестроить кучу
	}
	
	public void recArray(int[] heap, int i) {
		try {
			if (heap[2 * i + 1] > heap[2 * i + 2] && heap[2 * i + 1] > heap[i]) {
				swap(heap, i, 2 * i + 1);
				recArray(heap, 2 * i + 1);
			} else if (heap[2 * i + 2] > heap[2 * i + 1] && heap[2 * i + 2] > heap[i]) {
				swap(heap, i, 2 * i + 2);
				recArray(heap, 2 * i + 2);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean Add(int key) {
		int i = 0;
		while (HeapArray[i] >= 0 && i < HeapArray.length) {
			i++;
		}
		if (HeapArray[i] == HeapArray.length - 1 && HeapArray[i] >= 0)
			return false;
		if (HeapArray[i] < 0)
			HeapArray[i] = key;
		while (HeapArray[(i - 1) / 2] < HeapArray[i]) {
			swap(HeapArray, (i - 1) / 2, i);
			i = (i - 1) / 2;
		}
		return true;
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}