
public class Level1 {

	static int SumOfThe(int N, int[] data) {

		int tmp = data[N - 1];
		int summ = 0;
		for (int i = 0; i < data.length; i++) {
			if (i != N - 1) {
				summ += data[i];
			}
		}
		if (summ != tmp) {
			return SumOfThe(N - 1, data);
		}
		return tmp;

	}
}
