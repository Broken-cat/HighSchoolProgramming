
public class Level16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={400, 350, 300, 250, 200, 150, 100};
		System.out.print(LevelTestin.MaximumDiscount(7, arr));
	}

}

class LevelTestin {

	static int MaximumDiscount(int N, int[] price) {
		int summ = 0;
		for (int i = 0; i < price.length; i++) {
			if((i+1)%3==0)summ+=price[i];
			else continue;
		}
		
		return summ;
	}

	static int[] sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = 0; j < arr.length - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		return arr;
	}

}
