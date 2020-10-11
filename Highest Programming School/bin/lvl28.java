public class Level1 {

	
	static String Keymaker(int k) {
		int[] doors = new int[k];
		for(int i = 1; i <= k; i++) {
			openDoors(doors, i);
		}
		String res = "";
		for(int i = 0; i <k; i++) {
			if(doors[i] == 1)res += 1;
			else res += 0;
		}
		return res;
	}
	
	static void openDoors(int[] d, int n) {
		for(int i = 1; i <= d.length;i++) {
			if(i%n==0) {
				if(d[i-1] == 1)d[i-1] = 0;
				else d[i-1] = 1;
			}
		}
		
	}

}
