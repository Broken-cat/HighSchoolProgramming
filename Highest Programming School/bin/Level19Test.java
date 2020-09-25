
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
		int[] tmpPr = new int[result.length];
		tmpPr = takePrices(result);
		result = reverseAndSort(result, tmpPr);

		return result;
	}

	static String[] reverseAndSort(String[] items, int[] prices) {

		for (int i = 0; i < items.length; i++) {
			items[i] = reverse(items[i]);
		}
		items = sort(items, prices);

		for (int i = 0; i < items.length; i++) {
			items[i] = reverse(items[i]);
		}

		return items;
	}

	static String[] sort(String[] item, int[] prices) {
		int len = item.length;

		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (prices[j] < prices[j + 1]) {
					int tmp = prices[j];
					prices[j] = prices[j + 1];
					prices[j + 1] = tmp;
					String st = item[j];
					item[j] = item[j + 1];
					item[j + 1] = st;
				}
			}
		}
		return item;
	}

	static String reverse(String tmp) {
		char[] array = tmp.toCharArray();
		String result = "";
		for (int i = array.length - 1; i >= 0; i--) {
			result = result + array[i];
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
		t: for (int i = 0; i < prices.length; i++) {
			char[] tmp = data[i].toCharArray();
			for (int j = tmp.length - 1; j > 0; j--) {
				if (tmp[j] == ' ') {
					prices[i] = Integer.parseInt(data[i].substring(j + 1));
					continue t;
				}
			}

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
				if (j != ind & tmp.equals(goods[j])) {
					k++;
					i++;
				}
			}
		}
		k = goods.length - k;
		return k;
	}

}
