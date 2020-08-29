
public class Level1 {
	static String MassVote(int N, int[] Votes) {
		double summ = 0;
		for (int x : Votes)
			summ += x;
		double[] percents = new double[N];
		for (int i = 0; i < Votes.length; i++) {
			double tmp = (Votes[i] / summ) * 100;
			percents[i] = round(String.valueOf(tmp));
		}

		if (!checkNoWinners(percents))
			return "no winner";

		int ind = 0;
		double posWinner = 0;
		for (int i = 0; i < percents.length - 1; i++) {
			if (percents[i] > posWinner) {
				posWinner = percents[i];
				ind = i;
			}
		}
		if (percents[ind] > 50)
			return "majority winner " + (ind + 1);
		return "minority winner " + (ind + 1);
	}

	static boolean checkNoWinners(double[] array) {
		double max = 0;
		int ind = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > max) {
				max = array[i];
				ind = i;
			}
		}

		for (int i = 0; i < array.length; i++) {
			if (ind != i & max == array[i])
				return false;
		}
		return true;
	}

	static double round(String tmp) {
		tmp = String.format("%.3f", Double.parseDouble(tmp));
		double res = Double.parseDouble(tmp.replace(",", "."));
		return res;
	}
}
