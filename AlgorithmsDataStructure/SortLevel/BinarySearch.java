package BinarySearch;

public class BinarySearch {
	public int Left, Right;
	private int[] numbers;
	public int processing;
	
	public BinarySearch(int arr[]) {
		numbers = arr;
		Left = 0;
		Right = arr.length-1;
		processing = 0;
	}
	
	public void Step( int N) {
		if(processing != 0)return;
		int middle = (Right+Left)/2;
		if(numbers[middle] == N)processing = 1;
		if(numbers[middle] > N) 
			Right = middle-1;
		if(numbers[middle] < N) 
			Left = middle+1;
		if(Left == Right || Left == Right-1) {
			if(numbers[Left] == N || numbers[Right] == N)processing = 1;
			else processing = -1;
			return;
		}
	}
	
	public int GetResult() {
		return processing;
	}
}
