
public class Level1 {

	static int startX = 0;
	static int startY = 0;

	static int[][] numberLock = { { 6, 1, 9 }, { 5, 2, 8 }, { 4, 3, 7 } };

	static String PatternUnlock(int N, int[] hits) {
		
		int startInt = hits[0];

		double length = 0;

		outer: for (int i = 0; i < numberLock.length; i++) {
			for (int j = 0; j < numberLock[i].length; j++) {
				if (startInt == numberLock[i][j]) {
					searchingInt = numberLock[i][j];
					startX = i;
					startY = j;
					break outer;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			length += checkLeft(hits[i], startX, startY, numberLock);
			length += checkRight(hits[i], startX, startY, numberLock);
			length += checkUp(hits[i], startX, startY, numberLock);
			length += checkDown(hits[i], startX, startY, numberLock);
			length += checkLeftUP(hits[i], startX, startY, numberLock);
			length += checkLeftDown(hits[i], startX, startY, numberLock);
			length += checkRightUP(hits[i], startX, startY, numberLock);
			length += checkRightDown(hits[i], startX, startY, numberLock);
		}

		
		return round(String.valueOf(length));
	}

	static String round(String tmp) {
		String result = "";
		char[] chars = tmp.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(tryParseInt(String.valueOf(chars[i])) && chars[i] != '0') result += String.valueOf(chars[i]);	
			
		}

		char[] chars2 = new char[6];
		chars = result.toCharArray();
		try {
			for (int i = 0; i < chars2.length; i++) {
				chars2[i] = chars[i];			
			}
			if( chars[6] >= 5) {
				int k = chars[5];
				chars2[5] = (char) ++k;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		result = String.copyValueOf(chars2);
		return result;
	}

	static boolean tryParseInt(String k) {
		try {
			Integer.parseInt(k);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	static double checkLeft(int k, int x, int y, int[][] arr) {
		try {

			if (arr[x][y - 1] == k) {
				startY--;
				return 1;

			}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;
	}

	static double checkRight(int k, int x, int y, int[][] arr) {
		try {

			if (arr[x][y + 1] == k) {
				startY++;
				return 1;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;

	}

	static double checkUp(int k, int x, int y, int[][] arr) {
		try {

			if (arr[x - 1][y] == k) {
				startX--;
				return 1;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;
	}

	static double checkDown(int k, int x, int y, int[][] arr) {
		try {

			if (arr[x + 1][y] == k) {
				startX++;
				return 1;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;
	}

	static double checkLeftUP(int k, int x, int y, int[][] arr) {
		try {

			if (arr[x - 1][y - 1] == k) {
				startX--;
				startY--;
				return 1.4142135623730951;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;
	}

	static double checkLeftDown(int k, int x, int y, int[][] arr) {
		try {

			if (arr[x + 1][y - 1] == k) {
				startX++;
				startY--;
				return 1.4142135623730951;

			}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;
	}

	static double checkRightUP(int k, int x, int y, int[][] arr) {
		try {

			if (arr[x - 1][y + 1] == k) {
				startX--;
				startY++;
				return 1.4142135623730951;

			}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;
	}

	static double checkRightDown(int k, int x, int y, int[][] arr) {
		try {

			if (arr[x + 1][y + 1] == k) {
				startX++;
				startY++;
				return 1.4142135623730951;

			}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 0;
	}
	
}
