

class Level1 {
	static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
		boolean isFound = false;
		if (H2 > H1 | W2 > W1)return false;
		int[][] Map = convertToArr(H1, W1, S1);
		int[][] Find = convertToArr(H2, W2, S2);

		try {
			got: for (int i = 0; i < H1; i++) {
				for (int j = 0; j < W1; j++) { // searching map
					int k = 0;
					if (Map[i][j] == Find[0][0]) { // if map - first elem of Find
						int posX = i;
						int posY = j;
						outer: for (int r = 0; r < H2; r++) {
							for (int l = 0; l < W2; l++) {
								if (Map[posX + r][posY + l] != Find[r][l])
									continue got;
							}
						}
						return true;
					}

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	static public int[][] convertToArr(int h, int w, String s) {

		
		int[][] arr = new int[h][w];

		s = s.replaceAll("\\s+", "");
		char[] chrs = s.toCharArray();

		int k = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				arr[i][j] = Character.getNumericValue(chrs[k]);
				k++;
			}
		}
		return arr;
	}
}
