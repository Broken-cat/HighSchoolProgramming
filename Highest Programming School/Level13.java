
public class Level1 {
	static int[] UFO(int N, int[] data, boolean octal) {
		int[] res = new int[N];
		if (octal) {
			for (int i = 0; i < res.length; i++) {
				res[i] = convert8(data[i]);
			}
		} else {
			for (int i = 0; i < res.length; i++) {
				res[i] = convert16(data[i]);
			}
		}
		return res;

	}

	static int convert16(int k) {
		char[] chars = String.valueOf(k).toCharArray();
		int len = chars.length;
		int[] intChars = new int[len];
		for (int i = 0; i < chars.length; i++) {
			intChars[i] = Character.getNumericValue(chars[i]);
		}
		int res = 0;
		for (int i = 0; i < intChars.length; i++) {
			res += intChars[i] * exp(16, len - i - 1);
		}
		return res;
	}

	static int convert8(int k) {
		char[] chars = String.valueOf(k).toCharArray();
		int len = chars.length;
		int[] intChars = new int[len];
		for (int i = 0; i < chars.length; i++) {
			intChars[i] = Character.getNumericValue(chars[i]);
		}
		int res = 0;
		for (int i = 0; i < intChars.length; i++) {
			res += intChars[i] * exp(8, len - i - 1);
		}
		return res;

	}

	static int exp(int k, int n) {
		int result = 1;
		for (int i = 0; i < n; i++)
			result *= k;
		return result;
	}
}
