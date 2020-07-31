
public class Level1 {
	
	static int squirrel(int N) {
		if (N ==0 )return 1;
		return Character.getNumericValue(String.valueOf((N * (squirrel(N - 1)))).charAt(0)) ;
	}
}
