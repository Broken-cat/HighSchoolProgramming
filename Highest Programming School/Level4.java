
public class Level1 {

	
	static int[] MadMax(int N, int[] Tele) {
		sortDown(N, Tele);
		return sortUp(N, Tele);
	}


	
	static int[] sortDown(int N, int[] array) {
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < N - 1; i++) {
				if (array[i] > array[i+1]) {
	                temp = array[i];
	                array[i] = array[i+1];
	                array[i+1] = temp;
	                sorted = false;
	            }
			}
		}
		return array;
	}
	
	static int[] sortUp(int N, int[] array) {
		boolean sorted = false;
		int temp;
		while (!sorted) {
			sorted = true;
			for (int i = N/2; i < N - 1; i++) {
				if (array[i] < array[i+1]) {
	                temp = array[i];
	                array[i] = array[i+1];
	                array[i+1] = temp;
	                sorted = false;
	            }
			}
		}
		return array;
	
	}
}
