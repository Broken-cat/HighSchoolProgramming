
public class PowerSet {

	public int capacity;
	public String[] slots;
	private int count;

	public PowerSet() {
		count = 0;
		capacity = 16;
		makeArray(capacity);
	}

	public int size() {
		return count;
	}

	public void makeArray(int new_capacity) {
		if (new_capacity < 16)
			new_capacity = 16;
		try {
			slots = Arrays.copyOf(slots, new_capacity);
			capacity = new_capacity;
		} catch (Exception e) {
			// TODO: handle exception
			slots = new String[capacity];
			for (int i = 0; i < capacity; i++)
				slots[i] = null;
		}

	}

	public int hashFun(String value) {
		byte[] bytes = value.getBytes();
		int sum = 0;
		for (int i = 0; i < bytes.length; i++) {
			sum += bytes[i];
		}
		return sum % capacity;
	}

	public boolean isFilled() {
		int i = 0;
		while (i < capacity) {
			if (slots[i] == null)
				return false;
			i++;
		}
		return true;
	}

	public int seekSlot(String value) {
		if ((double) this.count / this.capacity > 0.7)
			makeArray(this.capacity * 2);
		int indx = hashFun(value);
		try {
			if (slots[indx].equals(value))
				return indx;
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (slots[indx] == null)
			return indx;
		else {
			int steps = 0;
			while (true) {
				steps++;
				indx = steps % (capacity);
				if (slots[indx] == null)
					break;
			}
			return indx;
		}
	}

	public void put(String value) {
		int indx = seekSlot(value);
		try {
			slots[indx] = value;
			count++;
		} catch (Exception e) { // TODO: handle exception
		}

	}

	public boolean get(String value) {
		try {
			for (int i = 0; i < capacity; i++)
				if (slots[i] != null && slots[i].equals(value))
					return true;
		} catch (Exception e) {
		}

		return false;
	}

	public boolean remove(String value) {
		try {
			for (int i = 0; i < capacity; i++)
				if (slots[i] != null && slots[i].equals(value)) {
					slots[i] = null;
					count--;
					return true;
				}
		} catch (Exception e) {
		}

		return false;
	}

	public PowerSet intersection(PowerSet set2) {
		for (int i = 0; i < this.capacity; i++) {
			if(this.slots[i] == null)continue;
			for(int j = 0; j < set2.capacity;j ++) {
				if(set2.slots[j] == null)continue;
				if(set2.slots[j].equals(this.slots[i]))
					this.slots[i] = null;
			}
		}
		this.display();
		return this;
	}

	public PowerSet union(PowerSet set2) {
		for (int i = 0; i < set2.capacity; i++)
			if (set2.slots[i] != null && !(this.slots[i] == set2.slots[i]))
				this.put(set2.slots[i]);
		this.display();
		return this;
	}

	public PowerSet difference(PowerSet set2) {
		for (int i = 0; i < this.capacity; i++) {
			for (int j = 0; j < set2.capacity; j++) {
				if (set2.slots[j] == this.slots[i])
					this.slots[i] = null;
			}
		}
		this.display();
		return this;
	}

	public boolean isSubset(PowerSet set2) {
		PowerSet res = this.union(set2);
		for (int i = 0; i < this.capacity; i++)
			if (res.slots[i] != this.slots[i])
				return false;
		return true;
	}

	public void display() {
		for (int i = 0; i < capacity; i++) {
			if (slots[i] == null)
				continue;
			System.out.print(slots[i] + " ");
		}
		System.out.println();
	}
}
