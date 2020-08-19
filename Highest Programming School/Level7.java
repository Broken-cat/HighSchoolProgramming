
public class Level1 {

	
	static int[] WordSearch(int len, String s, String subs) {

		s = s.replaceAll("[\\s]{2,}", " ");
		String[] words = takeWords(s, len);
		int g = count(words, len);
		
		String[] N_words = lines(words, g, len);
		
		int[] res = new int[g];

		for (int j = 0; j < N_words.length; j++) {
			res[j] = matchWords(N_words[j], subs);
		}

		return res;
	}
	
	static int matchWords(String line, String sub) {
		String[] tmp = line.split(" ");
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i].equals(sub))return 1;
		}
		return 0;
	}
	
	
	static String[] lines(String[] arr, int g, int len) {
		String[] tmp = new String[g];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = "";
		}
		
		int summ = 0;
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
		
			if(summ + arr[i].length() > len) {
				summ = 0;
				k++;
				i--;
			} else {
				summ += (arr[i].length()+1);
				tmp[k] += arr[i] + " ";				
			}
		}
		
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = tmp[i].replaceFirst("\\s++$", "");
		}
		
		return tmp;	
	}
	
	static int count(String[] arr, int len) {
	
		int summ = 0;
		int k = 1;
		for (int i = 0; i < arr.length; i++) {
		
			if(summ + arr[i].length() > len) {
				System.out.println();
				k++;
				summ = 0;
				i--;
			} else {
				summ += (arr[i].length()+1);
				System.out.print(arr[i] + " ");
			
				
			}
		}
			return k;
	}
	


	static String[] takeWords(String arr, int len) {
		String tmp = "";
		char[] splitWords = arr.toCharArray();

		int k = 0;
		for (int i = 0; i < splitWords.length; i++) {
			tmp += splitWords[i];
			k++;
			if (!String.valueOf(splitWords[i]).equals(" ")) {
				if (k == len) {
					tmp += " ";
					k = 0;
				}
			} else {
				k = 0;
			}
		}
		tmp = tmp.replaceAll("[\\s]{2,}", " ");
		String[] words = tmp.split(" ");
		return words;
	}
}
