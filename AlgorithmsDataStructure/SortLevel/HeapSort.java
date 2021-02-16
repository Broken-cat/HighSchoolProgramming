
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

