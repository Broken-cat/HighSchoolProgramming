import java.util.*;

public class Level1 {


	static String[] TreeOfLife(int H, int W, int N, String[] tree) {
		String treeString = "";
		for (int i = 0; i < tree.length; i++) {
			treeString += tree[i];
		}
		char[] chars = treeString.toCharArray();
		String[][] treeHxW = new String[H][W];
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (chars[count] == '.')
					treeHxW[i][j] = "0";
				if (chars[count] == '+')
					treeHxW[i][j] = "1";
				count++;
			}
		}

		boolean isEven = false;
		Stack<Integer> stackX = new Stack<Integer>();
		Stack<Integer> stackY = new Stack<Integer>();

		for (int years = 0; years < N; years++) {
	
			for (int i = 0; i < treeHxW.length; i++) {
				for (int j = 0; j < treeHxW[i].length; j++) {
				
					if (Integer.parseInt(treeHxW[i][j]) >= 3) {
						stackX.push(i);
						stackY.push(j);
						stackX.push(i);stackY.push(j + 1);
						stackX.push(i);stackY.push(j - 1);
						stackX.push(i+1);stackY.push(j);
						stackX.push(i-1);stackY.push(j);
					}

					int y;
					try {
						y = Integer.parseInt(treeHxW[i][j]);
					} catch (Exception e) {
						// TODO: handle exception
						y = 0;
					}

					treeHxW[i][j] = String.valueOf(++y);

				}
			}
			if (!isEven) {
				while (!stackX.isEmpty()) {
					
					int x = stackX.pop();
					int y = stackY.pop();
					try {
						treeHxW[x][y] = "0";
					} catch (Exception e) {
						// TODO: handle exception
					//	System.out.println("ex");
					}

				}
			}

			if (!isEven)
				isEven = true;
			else
				(isEven) = false;
		}
		count = 0;
		String[] result = new String[H*W];
		for(int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(treeHxW[i][j].equals("0"))treeHxW[i][j] = ".";
				else treeHxW[i][j] = "+";
				result[count] = treeHxW[i][j];
				count++;
			}
		}
		return result;
	}

}
