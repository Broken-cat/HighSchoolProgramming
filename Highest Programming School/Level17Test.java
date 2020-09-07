

class Level1  {
	static boolean LineAnalysis(String line) {
		int diference = 0;
		
		char[] chrs = line.toCharArray();
		for (int i = 1; i < chrs.length; i++) {
			if(chrs[i] == '.')diference++;
			else break;
		}
		
		int compare = 0;
		for (int i = 1; i < chrs.length; i++) {
			if(chrs[i] == '.')compare++;
			else {
				if(diference == compare) {
					compare = 0;
					continue;
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
}
