
class NativeDictionary<T> {
	public int size;
	public String[] slots;
	public T[] values;

	public NativeDictionary(int sz, Class clazz) {
		size = sz;
		slots = new String[size];
		values = (T[]) Array.newInstance(clazz, this.size);
	}

	public int hashFun(String value) {
		byte[] bytes = value.getBytes();
		int sum = 0;
		for (int i = 0; i < bytes.length; i++) {
			sum += bytes[i];
		}
		return sum % size;
	}

	public boolean isKey(String key) {
		try {
			for (int i = 0; i < size; i++) 
				if (slots[i] != null && slots[i].equals(key))
					return true;
		} catch (Exception e) {}

		return false;
	}

	public void put(String key, T value) {
		int indx = seekSlot(key);
		try {
			values[indx] = value;
			slots[indx] = key;
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public T get(String key) {
		int indx = seekSlot(key);
		try {
			if (slots[indx].equals(key))
				return values[indx];
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public boolean isFilled() {
		int i = 0;
		while (i < size) {
			if (slots[i] == null)
				return false;
			i++;
		}
		return true;
	}

	public int seekSlot(String value) {
		int indx = hashFun(value);
		try {
			if (slots[indx].equals(value))
				return indx;
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (isFilled())
			return -1;
		if (slots[indx] == null)
			return indx;
		else {
			int steps = 0;
			while (true) {
				steps++;
				indx = steps % (size);
				if (slots[indx] == null)
					break;
			}
			return indx;
		}
	}
}
