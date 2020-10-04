import java.util.Arrays;

public class Level1 {
	public static void setS(String[] ss) {
		s = ss;
	}

	public static String[] getS() {
		return s;
	}

	
	
	static String[] turn(String Matrix[], int M, int N) {
		Matrix = getS();
		String MatrixString = "";
		for (int i = 0; i < Matrix.length; i++) {
					MatrixString += Matrix[i];
		}
	
			char[] chars = MatrixString.toCharArray();
			String[][] MatrixMxN = new String[M][N];
			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					MatrixMxN[i][j] = String.valueOf(chars[count]);
					count++;
				}
			}
		
			int row = 0, col = 0;

			String prev;
			String curr;

			while (row < M && col < N) {

				if (row  == N || col == M)
					break;

				prev = MatrixMxN[row + 1][col];

				for (int i = col; i < N; i++) {
					curr = MatrixMxN[row][i];
					MatrixMxN[row][i] = prev;
					prev = curr;
				}
				row++;

				for (int i = row; i < M; i++) {
					curr = MatrixMxN[i][N - 1];
					MatrixMxN[i][N - 1] = prev;
					prev = curr;
				}
				N--;

				if (row < M) {
					for (int i = N - 1; i >= col; i--) {
						curr = MatrixMxN[M - 1][i];
						MatrixMxN[M - 1][i] = prev;
						prev = curr;
					}
				}
				M--;

				if (col < N) {
					for (int i = M - 1; i >= row; i--) {
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
		return result;
		}
	
	

	static void MatrixTurn(String Matrix[], int M, int N, int T) {
		setS(Matrix);
		for(int i = 0; i < T; i++)Matrix = turn(Matrix, M, N);
	}
}
