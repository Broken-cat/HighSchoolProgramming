public class ksort {

	public String[] items;
	public int size;
	
	public ksort() {
		size = 8*99;
		items = new String[size];
	}
	
	public int index(String s ) {
		int firstChar = hashFun(String.valueOf(s.charAt(0)));
		firstChar -= 97;
		if(firstChar < 0 || firstChar > 7)return -1;
		int numbers = Integer.parseInt(String.valueOf(s.charAt(1)).concat(String.valueOf(s.charAt(2))));
		firstChar =firstChar*100+numbers;
		if(firstChar < 0 || firstChar > 791)return -1;
		return firstChar;
	}
	
	
	public boolean add(String s) {
		int ind = index(s);
		try {
			items[ind] = s;
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	

	public int hashFun(String value) {
		byte[] bytes = value.getBytes();
		int sum = 0;
		for (int i = 0; i < bytes.length; i++) {
			sum += bytes[i];
		}
		return sum % size;
	}
}
