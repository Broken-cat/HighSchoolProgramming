
class aBST {
	public Integer Tree[]; // массив ключей

	public aBST(int depth) {
		// правильно рассчитайте размер массива для дерева глубины depth:
		int tree_size = 0;
		for (int i = 0; i < depth; i++)
			tree_size += (int) Math.pow(2, i);
		Tree = new Integer[tree_size];
		for (int i = 0; i < tree_size; i++)
			Tree[i] = null;
	}

	public Integer FindKeyIndex(int key) {
		// ищем в массиве индекс ключа
		int pos = 0;
		if (Tree[pos] == null)
			return 0;
		try {
			while (Tree[pos] != key) {
				if (Tree[pos] > key) {
					pos = pos * 2 + 1;
					continue;
				} else {
					pos = pos * 2 + 2;
					continue;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			return null;
		} catch (NullPointerException e) {
			// TODO: handle exception
			return -pos;
		}
		return pos;
	}

	public int AddKey(int key) {
		int pos = -FindKeyIndex(key);
		if (Tree[pos] == null) {
			Tree[pos] = key;
			return -1;
		}
		if (Tree[pos] == null)
			return pos;
		// добавляем ключ в массив
		return -1;
		// индекс добавленного/существующего ключа или -1 если не удалось
	}

}
