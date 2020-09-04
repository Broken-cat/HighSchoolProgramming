

public class Level1 {
	static int turn = 0;
	static int k = 0;
	
	static boolean isGreen = false;

	static int Unmanned(int L, int N, int[][] track) {

		for (int i = 0; i < L; i++) {
			if (k < N) {
				if (track[k][0] != i+1)
					turn++;
				else {
					turn = makeArr(track[k], turn);
					turn++;
				}
			} else {
				turn++;
			}
		}

		return turn;
	}

	static int makeArr(int[] arr, int time) {
		isGreen = false;
		for (int i = 0; i < time+1; i++) {
			if (isGreen == false) {
				if (arr[1] != 0) {
					arr[1]--;
				} else {
					isGreen = true;
					arr[1] = arr[2];
					arr[2]--;
				}
			} else {
				if (arr[2] != 0) {
					arr[2]--;
				} else {
					isGreen = false;
					arr[2] = arr[1];
					arr[1]--;
				}

			}
		}
		if (isGreen == true) {
			k++;
			return turn;
		} else {
			while (arr[1] != 0) {
				turn++;
				arr[1]--;
			}
			k++;
			return turn;
		}

	}

	
}
