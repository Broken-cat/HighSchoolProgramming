
public class Level1 {
	static String TheRabbitsFoot(String s, boolean encode) {
		if (encode)
			return codeString(s);
		return decodeString(s);
	}

	static String codeString(String s) {

		s = s.replaceAll(" ", "");
		int k = s.length();
		int r = sqrt(k);
		char[] sChar = s.toCharArray();
		String[][] matrix = new String[r][r];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = "";

			}
		}

		int x = 0;
		int y = 0;
		for (int i = 1; i < k + 1; i++) {
			matrix[y][x] = String.valueOf(sChar[i - 1]);
			x++;
			if (i % r == 0) {
				y++;
				x = 0;
			}

		}

		String res = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				res += matrix[j][i];
			}
			res += " ";
		}
		return res;
	}

	static String decodeString(String s) {
		s = s.replaceAll(" ", "");
		char[] sChar = s.toCharArray();
		String tmp = "";
		int k = sqrt(s.length());
		int ost = k - ((k * k) - s.length());
		String[][] matrix = new String[k][k];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = "";
			}
		}

		// fix it
		int x = 0;
		int y = 0;
		for (int i = 1; i < s.length() + 1; i++) {
			if (ost != 0) {
				matrix[y][x] = String.valueOf(sChar[i - 1]);
				x++;
				if (x == k) {
					ost--;
					y++;
					x = 0;
				}
			} else {
				matrix[y][x] = String.valueOf(sChar[i - 1]);
				x++;
				if (x == k) {
					matrix[y][--x] = "";
					x = 0;
					y++;
					matrix[y][x] = String.valueOf(sChar[i - 1]);
					x++;
				}

			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				tmp += matrix[j][i];
			}
		}

		return tmp;
	}

	// recursive
	static int sqrt(int k) {
		int a = 0;
		while (k > a * a) {
			a++;
		}
		return a;
	}

}
