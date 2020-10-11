package lvl266;

public class lvl2666 {

	static int open = 0;
	static int close = 0;
	static String res = "";

	static void _printParenthesis(char str[], int pos, int n, int open, int close) 
	{ 
		if(close == n) 
		{ 
			// print the possible combinations 
			for(int i=0;i<str.length;i++) 
				res += str[i];
			res += " ";
			return; 
		} 
		else
		{ 
			if(open > close) { 
				str[pos] = ')'; 
				_printParenthesis(str, pos+1, n, open, close+1); 
			} 
			if(open < n) { 
				str[pos] = '('; 
				_printParenthesis(str, pos+1, n, open+1, close); 
			} 
		} 
	} 
	
	
	static String BalancedParentheses(int N) {
		char[] chrs = new char[2 * N];
		if(N > 0) 
			_printParenthesis(chrs, 0, N, open, close); 
		return res;
	}

	// driver program
	public static void main(String[] args) {
		System.out.println(BalancedParentheses(4));
	}
}
