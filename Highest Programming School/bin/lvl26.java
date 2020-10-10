
public class Level1 {

	
	static int k = 0;
	static String res = "";
	static String startString = "";
	static String makeS(int N, int k) {
		String tmp = "";
		for(int i = 0; i < N+k; i++)tmp += "(";
		for(int i = 0; i < N+k; i++)tmp += ")";
		return tmp;
	}
	static String BalancedParentheses(int N) {		
		String finalRes = "";		
		res = makeS(N,k);
		if(N == 1 && k == 0)return res;	
		if(N == 1 )return finalRes;
		
		if(N == N+k)finalRes += res + " ";
		int len = res.length();
		k++;
		
		for (int t = len-2; t >(N+k)/2 ; t--) {
			finalRes += replace(N-1, t,  res);
		}
		finalRes = finalRes.substring(0, finalRes.length()-1);
		return finalRes += BalancedParentheses(N-1);
	}
	
	
	
	static String replace(int i, int k, String str) {
		int len = str.length();
		if (k == len-1 || i == 0 || k == len/2-1)return "";
		char[] chrs = str.toCharArray();
		char tmp = chrs[i];
		chrs[i] = chrs[k];
		chrs[k] = tmp;
		str = String.valueOf(chrs);
		return  str + " ";
	}

	
	
}
