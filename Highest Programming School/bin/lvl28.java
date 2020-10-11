package lvl28;

import java.util.Arrays;

public class lvl28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Keymaker(8));
	}
	static String Keymaker(int k) {
		int[] doors = new int[k];
		for(int i = 1; i <= k; i++) {
			openDoors(doors, i);
			int o = 0;
			for(int j =0;j < k;j++) {
				if(doors[j]==1)o++;
			}
			System.out.println(Arrays.toString(doors) + " " + o + " n: " + i);
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
