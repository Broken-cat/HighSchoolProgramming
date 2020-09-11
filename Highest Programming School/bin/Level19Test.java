

import java.util.*;



class Level1 {

	static String[] ShopOLAP(int N, String[] items) {
		Arrays.sort(items);

		int[] prices = takePrices(items);
		String[] tmpitms = new String[items.length];	
		for (int i = 0; i < tmpitms.length; i++) {
			tmpitms[i] = takeItems(items[i]);
		}
		int k = takeN(tmpitms);
		
		String[] result = new String[k];
		
		int indx = 0;
		for (int i = 0; i < tmpitms.length; i++) {
			String tmp = tmpitms[i];
			int pr = prices[i];
			for (int j = 0; j < items.length; j++) {
				if (j != i & tmp.equals(tmpitms[j])) {
					pr += prices[j];
					i++;
				}
			}
			result[indx] = tmpitms[i] + " " + String.valueOf(pr);
			indx++;
		}

		return result;
	}






	static String takeItems(String data) {
		char[] chrs = data.toCharArray();
		String res = "";
		for (int i = 0; i < chrs.length; i++) {
			if (chrs[i] == ' ')
				break;
			res += chrs[i];
		}
		return res;
	}

	static int[] takePrices(String[] data) {
		int[] prices = new int[data.length];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = Integer.parseInt(data[i].substring(data[i].length() - 1));
		}
		return prices;
	}

	static int takeN(String[] goods) {
		int k = 0;
		int count = 0;
		for (int i = 0; i < goods.length; i++) {
			int ind = i;
			String tmp = goods[i];
			count = i;
			for (int j = count; j < goods.length; j++) {
				if (j != ind & tmp.equals(goods[j]))
					k++;
			}
		}
		k = goods.length - k;
		return k;
	}

}
