
public class Level3 {

	
	
	// N x M - размеры
	// even elem of array - coords of высадки по N
	// odd elem of array - coords of высадки по M
	
	
	static int ConquestCampaign(int N, int M, int L, int[] battalion) {
		int[][] array = new int[N][M];

		for (int i = 0; i < battalion.length; i += 2) {
			array[battalion[i] - 1][battalion[i + 1] - 1] = 2;
		}
		
		
		int days = 1;
		while (!isTaken(array)) {
			takePoints(array);
			ownPoints(array);
			days++;
		}

		return days;

	}

	static int[][] ownPoints(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 1)
					array[i][j] = 2;
			}
		}
		return array;
	}

	static boolean isTaken(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	static int[][] takePoints(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 2) {
					try {
						array[i + 1][j] = checkDown(i, j, array);
					} catch (Exception e) {
						// TODO: handle exception

					}
					try {
						array[i - 1][j] = checkUp(i, j, array);
					} catch (Exception e) {
						// TODO: handle exception

					}
					try {
						array[i][j - 1] = checkLeft(i, j, array);
					} catch (Exception e) {
						// TODO: handle exception

					}
					try {
						array[i][j + 1] = checkRight(i, j, array);
					} catch (Exception e) {
						// TODO: handle exception

					}

				}
			}
		}
		return array;
	}

	static int checkUp(int x, int y, int[][] array) {
		if (array[x-1][y] == 2)
			return 2;
		if (x - 1 >= 0)
			return 1;
		return 0;
	}

	static int checkDown(int x, int y, int[][] array) {
		if (array[x+1][y] == 2)
			return 2;
		if (x + 1 <= array.length)
			return 1;
		return 0;
	}

	static int checkLeft(int x, int y, int[][] array) {
		if (array[x][y - 1] == 2)
			return 2;
		if (y - 1 >= 0)
			return 1;
		return 0;
	}

	static int checkRight(int x, int y, int[][] array) {
		if (array[x][y+1] == 2)
			return 2;
		if (y + 1 <= array.length)
			return 1;
		return 0;
	}
}
