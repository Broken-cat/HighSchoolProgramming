package HashTable;

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
		if(isFilled())return -1;
		int indx = hashFun(value);
		if (slots[step+indx] == null || slots[step+indx].equals(value))
			return indx;
		else {
			try {
				if(step == 0)step = 1;
				else step *= 2;
				seekSlot(value);
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				step = 0;
				seekSlot(value);
			}
			return indx+step;
		}
	}

	public int put(String value) {
		step = 0;
		if(isFilled())
		return -1;
		else { 
			int indx = seekSlot(value);
			slots[indx] = value;
			return indx;
		}		
	}

	public int find(String value) 
		for(int i = 0; i < size;i++) 
			if(slots[i].equals(value))return i;
		return -1;
	}
	
	
}