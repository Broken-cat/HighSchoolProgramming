

public class Level1 {
		static int turn = 0;
	static int k = 0;
	static boolean isGreen = false;

	static int Unmanned(int L, int N, int[][] track) {

		for (int i = 0; i < L; i++) {
			turn++;
			try {
		
				if (i + 1 == track[k][0] && k < N ) {
					track[k][0] = 0;
					turn = Itterate(track[k], turn);
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return turn;
	}

	static int Itterate(int[] arr, int time) {
		arr = makeArr(arr, time);
		for (int i = 0; i < arr[1]+1; i++) {
			if (isGreen == false) {
				if (arr[1] != 1) {
					arr[1]--;
					turn++;
				} else {
					isGreen = true;
					arr[1] = arr[2];
					arr[2]--;
					turn++;
				}
			} else if (isGreen == true && arr[0] == 0) {
				k++;
				return turn;
			} else {
				if (arr[2] != 1)
					arr[2]--;
				else {
					isGreen = false;
					arr[2] = arr[1];
					arr[1]--;
				}
			}
		}
		k++;
		return turn;
	}

	static int[] makeArr(int arr[], int time) {
		if(arr[1] == 0 || arr[1] == 1)isGreen = true;
		for (int i = 0; i < time; i++) {
			
			if (isGreen == false) {
				if (arr[1] != 1) {
					arr[1]--;
				} else {
					isGreen = true;
					arr[1] = arr[2];
					arr[2]--;
				}
			} else {
				if (arr[2] != 1)
					arr[2]--;
				else {
					isGreen = false;
					arr[2] = arr[1];
					arr[1]--;
				}
			}
			if (isGreen == true && arr[0] == 0 && i == time - 1)
				return arr;
		}
		
		return arr;
	}
}
