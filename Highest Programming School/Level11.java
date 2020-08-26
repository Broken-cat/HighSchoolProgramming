
public class Level11 {

	static String BigMinus(String s1, String s2) {
		s1 = reverseString(s1);
		s2 = reverseString(s2);
		char[] firstSlag = s1.toCharArray();
		char[] secondSlag = s2.toCharArray();
		int fLen = firstSlag.length;
		int sLen = secondSlag.length;
		String tmp = "";
		if (s1.equals(s2))return "0";
		if(fLen > sLen) {
			for (int i = 0; i < sLen; i++) {
				int x = Character.getNumericValue(firstSlag[i]);
				int y = Character.getNumericValue(secondSlag[i]);
				
				if(x < y) {				
					tmp += String.valueOf((10+x)-y);
					try {
						firstSlag[++i]--;		
						i--;
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (x == y) {
					tmp += "0";
				} else if (x > y) tmp += String.valueOf(x-y);
			}
			for (int i = secondSlag.length; i < firstSlag.length; i++) {
				tmp+= firstSlag[i];
			}
		} 
		else if (fLen < sLen) {
			char[] temp = firstSlag;
			firstSlag = secondSlag;
			secondSlag = temp;
			for (int i = 0; i < fLen; i++) {			
				int x = Character.getNumericValue(firstSlag[i]);
				int y = Character.getNumericValue(secondSlag[i]);
				
				if(x < y) {				
					tmp += String.valueOf((10+x)-y);
					try {
						secondSlag[++i]--;		
						i--;
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else if (x == y) {
					tmp += "0";
				} else if (x > y) tmp += String.valueOf(x-y);
			}
			for (int i = secondSlag.length; i < firstSlag.length; i++) {
				tmp+= firstSlag[i];
			}
		} else if (fLen == sLen) {
			if(checkMore(s1, s2)) {
				for (int i = 0; i < secondSlag.length; i++) {
					int x = Character.getNumericValue(firstSlag[i]);
					int y = Character.getNumericValue(secondSlag[i]);
					
					if(x < y) {				
						tmp += String.valueOf((10+x)-y);
						try {
							firstSlag[++i]--;		
							i--;
						} catch (Exception e) {
							// TODO: handle exception
						}
					} else if (x == y) {
						tmp += "0";
					} else if (x > y) tmp += String.valueOf(x-y);
				}
			} else {
				for (int i = 0; i < fLen; i++) {
					int y = Character.getNumericValue(firstSlag[i]);
					int x = Character.getNumericValue(secondSlag[i]);
					
					if(x < y) {				
						tmp += String.valueOf((10+x)-y);
						try {
							secondSlag[++i]--;		
							i--;
						} catch (Exception e) {
							// TODO: handle exception
						}
					} else if (x == y) {
						tmp += "0";
					} else if (x > y) tmp += String.valueOf(x-y);
				}
				for (int i = secondSlag.length; i < firstSlag.length; i++) {
					tmp+= firstSlag[i];
				}
			}
		} 
		tmp = reverseString(tmp);
		char[] ch = tmp.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if(ch[i] == '0') {
				ch[i] = ' ';
				continue;
			}
			if(ch[i] != '0')break;
		}
		tmp = String.valueOf(ch);
		tmp = tmp.replaceAll(" ", "");
		return tmp;
	}
	
	static boolean checkMore(String s1, String s2) {
		char[] firstSlag = s1.toCharArray();
		char[] secondSlag = s2.toCharArray();
		for (int i = 0; i < firstSlag.length; i++) {
			if(firstSlag[i] > secondSlag[i])return true;
		}
		return false;
	}
	
	static String reverseString(String s) {
		String tmp = "";
		char[] chars = s.toCharArray();
		for (int i = chars.length-1; i >=0; i--) {
			tmp += chars[i];
		}
		return tmp;
	}
	
}
