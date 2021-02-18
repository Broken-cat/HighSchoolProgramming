package BinarySearch;

public class BinarySearch {
	public int Left, Right;
	private int[] numbers;
	private int len;
	
	public BinarySearch(int arr[]) {
		numbers = arr;
		Left = 0;
		Right = arr.length-1;
	}
	
	public int Step( int N) {
		if((Left == Right && numbers[Left] != N) ||
				(Left == Right-1 && numbers[Left] != N))return -1;
		if(numbers[(Right+Left)/2] == N)return 1;
		if(numbers[(Right+Left)/2] > N) {
			Right = Right/2;
		} else {
			Left += Right/2;
		}
		return 0;
	}
}
