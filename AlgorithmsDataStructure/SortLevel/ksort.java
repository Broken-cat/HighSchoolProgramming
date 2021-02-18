public class BinarySearch {
	public int Left, Right;
	private int[] numbers;
	private int processing;
	
	public BinarySearch(int arr[]) {
		numbers = arr;
		Left = 0;
		Right = arr.length-1;
		processing = 0;
	}
	
	public void Step( int N) {
		if(processing != 0)return;
		int middle = (Right+Left)/2;
 		if(numbers[middle] == N) {
			processing = +1;
			return;
		}
		if((Left == Right && numbers[Right] != N) ||
				(Left == Right-1 && numbers[Right] != N)) {
			processing =  -1;
			return;
		}
		if(numbers[middle] > N) {
			Right = middle-1;
		} else {
			Left = middle+1;
		}
	}
	
	public int GetResult() {
		return processing;
	}
}
