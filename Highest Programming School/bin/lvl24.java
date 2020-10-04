import java.util.Arrays;

public class Level1 {
	
	static String[] s;
	
	public static void setS(String[] ss) {
		s  = ss;
	}
	
	public static String[] getS() {
		return s;
	}
	
	static void MatrixTurn(String Matrix[], int M, int N, int T) {
		setS(Matrix);	
		for (int tick = 0; tick < T; tick++) {
		int tmpN = N;
		int tmpM = M;
		Matrix = getS();
		String MatrixString = "";
		for (int i = 0; i < Matrix.length; i++) {
					MatrixString += Matrix[i];
		}
	
			char[] chars = MatrixString.toCharArray();
			String[][] MatrixMxN = new String[tmpM][tmpN];
			int count = 0;
			for (int i = 0; i < tmpM; i++) {
				for (int j = 0; j < tmpN; j++) {
					MatrixMxN[i][j] = String.valueOf(chars[count]);
					count++;
				}
			}
		
			int row = 0, col = 0;

			String prev;
			String curr;

			while (row < tmpM && col < tmpN) {

				if (row  == tmpN || col == tmpM)
					break;

				prev = MatrixMxN[row + 1][col];

				for (int i = col; i < tmpN; i++) {
					curr = MatrixMxN[row][i];
					MatrixMxN[row][i] = prev;
					prev = curr;
				}
				row++;

				for (int i = row; i < tmpM; i++) {
					curr = MatrixMxN[i][tmpN - 1];
					MatrixMxN[i][tmpN - 1] = prev;
					prev = curr;
				}
				tmpN--;

				if (row < tmpM) {
					for (int i = tmpN - 1; i >= col; i--) {
						curr = MatrixMxN[tmpM - 1][i];
						MatrixMxN[tmpM - 1][i] = prev;
						prev = curr;
					}
				}
				tmpM--;

				if (col < tmpN) {
					for (int i = tmpM - 1; i >= row; i--) {
						curr = MatrixMxN[i][col];
						MatrixMxN[i][col] = prev;
						prev = curr;
					}
				}
				col++;

			}
			
		
		 count = 0;
		String[] result = new String[Matrix.length];
		String tmp = "";
		for (int i = 0; i < MatrixMxN.length; i++) {
			for (int j = 0; j < MatrixMxN[i].length; j++) {
				tmp += MatrixMxN[i][j];
				count++;
			}
			result[i] = tmp;
			tmp = "";
		}
		setS(result);
		Matrix = getS();
		
		}
	}
}
