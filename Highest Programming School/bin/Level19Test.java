

class Level19 {

	static String[] ShopOLAP(int N, String[] items) {
		int[] prices = takePrices(items);
		String[] item = new String[items.length];

		for (int i = 0; i < item.length; i++) {
			item[i] = takeItems(items[i]);
		}


		int k = takeN(item);
		String[] delItms = deteleRepits(item, k);
		String[] result = new String[k];
		
		for (int i = 0; i < delItms.length; i++) {
			String res = delItms[i];
			String tmp = delItms[i];
			int pr = 0;
			for (int j = 0; j < items.length; j++) {
				if(tmp.equals(item[j])) {
					pr += prices[j];
				}
			}
			result[i] = res + " " + String.valueOf(pr);
		}
		
		result = reverseAndSort(result);
		return result;
	}

	
	static String[] reverseAndSort(String[] items) {
		for (int i = 0; i < items.length; i++) {
			items[i] = reverse(items[i]);
		}
		items = sort(items);
		
		for (int i = 0; i < items.length; i++) {
			items[i] = reverse(items[i]);
		}
		
		return items;
	}
	
	static String[] sort(String[] item) {
		int len = item.length;
		int[] prices = new int[len];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = Integer.parseInt(item[i].substring(item[i].length() - 1));
		}
		
		for (int i = 0; i < len-1; i++) {
			for (int j = 0; j < len-1-i; j++) {
				if(prices[j] < prices[j+1]) {
					int tmp = prices[j];
					prices[j] = prices[j+1];
					prices[j+1] = tmp;
					String st = item[j];
					item[j] = item[j+1];
					item[j+1] = st;
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
		return tmp;
	}
	
	
	static String[] deteleRepits(String[] goods, int k) {
		String[] result = new String[k];
		int indx = 0;
		g: for (int i = 0; i < goods.length; i++) {
			
			String tmp = goods[i];
			if (checkRepit(result, tmp)) {
				result[indx] = tmp;
				indx++;
			}else {
				
			}
		}
		return result;
	}

	static boolean checkRepit(String[] item, String itm) {
		for (int i = 0; i < item.length; i++)
			if (String.valueOf(item[i]).equals(itm))
				return false;
		return true;
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
