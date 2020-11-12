

public class HashTable {
	public int size;
	public int step;
	public String[] slots;
	
	public HashTable(int sz, int stp) {
		size = sz;
		step = stp;
		slots = new String[size];
		for (int i = 0; i < size; i++)
			slots[i] = null;
	}

	public int hashFun(String value) {
		byte[] bytes = value.getBytes();
		int sum = 0;
		for (int i = 0; i < bytes.length; i++) {
			sum += bytes[i];
		}
		return sum % size;
	}

	public boolean isFilled() {
		int i = 0;
		while (i < size) {
			if(slots[i] == null)return false;
			i++;
		}
		return true;
	}

	public int seekSlot(String value) {
		if(isFilled())
			return -1;
		int indx = hashFun(value);
		if (slots[step+indx] == null || slots[step+indx].equals(value))
			return indx+step;
		else {
			step = 0;
			while(true) {
				step++;
				indx = step % size;
				if(slots[indx] == null)break;
			}
			return indx;
		}
	}
	

	public int put(String value) {
		step = 0;
			int indx = seekSlot(value);
			try {
				slots[indx] = value;
			} catch (Exception e) {
				// TODO: handle exception
			}
			return indx;
			
	}

	public int find(String value) {
		for(int i = 0; i < size;i++) 
			if(slots[i].equals(value))return i;
		return -1;
	}
	
	
}
