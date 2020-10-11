package lvl27;

import java.util.Arrays;

public class lvl27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] f = { 2,7,5,6,3,10};
		System.out.println(Football(f, f.length));
	}

	static boolean Football(int F[], int N) {
		int[] tmp = new int[N];
		for (int i = 0; i < N; i++)
			tmp[i] = F[i];
		int end = 0;
		int start = 0;
		int len = 0;
		boolean tryToRev = false;
		go: for (int i = 0; i < N - 1; i++) {
			if (F[i] > F[i + 1]) {
				len++;
				tryToRev = true;
				start = i;
				for (int j = start; j < N - 1; j++) {
					if (F[j] > F[j + 1]) {
						len++;
						end = j + 1;
					}
				}
				break go;
			}
		}
		if (tryToRev) {
			if (reverse(tmp, start, end, len)) {
				System.out.println(Arrays.toString(F));
				return true;
			}
		} 
		return false;
	}
	
	static boolean swap(int[] f) {
		int N = f.length;
		int min = f[0];
		int max = f[0];
		for(int i = 0; i < N; i++) {
			if(f[i] < min)min = f[i];
			if(f[i] > max)max = f[i];
		}
		
		return false;
	}

	static boolean reverse(int[] f, int start, int end, int len) {
		int[] tmp = new int[len];
		for (int i = 0; i < len; i++) {
			tmp[i] = f[start + i];
		}

		for (int i = 0; i < len / 2; i++) {
			int tmpVal = f[start + i];
			f[start + i] = f[end - i];
			f[end - i] = tmpVal;
		}

		for (int i = 0; i < f.length - 1; i++) {
			if (f[i] > f[i + 1])
				return false;
		}
		return true;
	}

	
	static boolean isVozr(int[] f) {
		for (int i = 0; i < f.length - 1; i++) {
			if (f[i] >= f[i + 1])
				return false;
		}
		return true;
	}
}
