
public class Level7 {

	
	
	static int[] WordSearch(int len, String s, String subs) {

		int k = 0;
		s = s.replaceAll("[\\s]{2,}", " ");
		String[] words = takeWords(s);

		int i = 0;
		while (i < words.length) {
			try {
				int summ = 0;
				while (summ < len) {

					if (summ < len) {
						summ += words[i].length();
						i++;
					} else {
						break;
					}

				}
				k++;
			} catch (Exception e) {
				// TODO: handle exception
				k++;
			}
		}
		String[] N_words = new String[k];
		int[] res = new int[k];

		for (int j = 0; j < N_words.length; j++) {
			if (words[j].equals(subs)) {
				res[j] = 1;
			} else {
				res[j] = 0;
			}
		}

		return res;
	}

	static String[] takeWords(String arr) {
		String[] words = arr.split(" ");
		return words;
	}
}
