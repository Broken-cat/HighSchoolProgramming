import java.util.Arrays;

public class Level1 {
	

	
	static String replace(int i, String str, String prev) {
		str = str.substring(0,i) + prev + str.substring(i+1, str.length());
		return str;
	}

	static void MatrixTurn(String Matrix[], int M, int N, int T) {
		
		
		for (int tick = 0; tick < T; tick++) {
		int tmpN = N;
		int tmpM = M;	
		int row = 0, col = 0;

			char prev;
			char curr;

			while (row < tmpM && col < tmpN) {
				if (row  == tmpN || col == tmpM)
					break;

				prev = Matrix[row + 1].charAt(col);

				for (int i = col; i < tmpN; i++) {
					curr = Matrix[row].charAt(i);
					Matrix[row] = replace(i, Matrix[row], String.valueOf(prev));
					prev = curr;
			
				}
				row++;

				for (int i = row; i < tmpM; i++) {
					curr = Matrix[i].charAt(tmpN-1);
					Matrix[i] = replace(tmpN-1, Matrix[i], String.valueOf(prev));//Matrix[i].replace(t, prev);//[tmpN - 1] = prev;
					prev = curr;
				}
				tmpN--;

				if (row < tmpM) {
					for (int i = tmpN - 1; i >= col; i--) {
						curr = Matrix[tmpM - 1].charAt(i); //[i];
						Matrix[tmpM - 1] = replace(i, Matrix[tmpM-1], String.valueOf(prev)); //Matrix[tmpM-1].replace(t, prev);//[i] = prev;
						prev = curr;
					}
				}
				tmpM--;
				if (col < tmpN) {
					for (int i = tmpM - 1; i >= row; i--) {
						curr = Matrix[i].charAt(col);//[col];
						Matrix[i] = replace(col, Matrix[i], String.valueOf(prev));//Matrix[i].replace(t, prev); //[col] = prev;
						prev = curr;
					}
				}
				col++;
			}		
		
		
		}
	}
}
