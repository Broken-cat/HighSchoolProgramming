
import java.util.*;


class Level1 {

	static public String BastShoe(String command) {
		
		String result = resString.getString();
		char[] tmp = command.toCharArray();
		int number = Integer.parseInt(String.valueOf(tmp[0]));
		
		if (command.length() > 1)
			result = command.substring(2);
		switch (number) {
		case 1:
			try {
				if (resString.NumOp.peek() == 4) {
					resString.clearStacks();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			if(!resString.getString().equals(""))
				resString.stack.push(resString.getString());
			resString.NumOp.push(number);
			String com = command.substring(2);
			String s = addString(com);
			resString.addString(s);		
			resString.stack.push(resString.getString());
			return resString.getString();
		case 2:
			try {
				if (resString.NumOp.peek() == 4) {
					resString.clearStacks();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			resString.NumOp.push(number);
			if(resString.stack.empty())resString.stack.push(resString.getString());
			int N = Integer.parseInt(command.substring(2));
			int tt = resString.getString().length();
			if (N >= tt) {
				resString.setString("");
				return resString.getString();
			}
			resString.deleteN(N);
			resString.stack.push(resString.getString());
			return resString.getString();
		case 3:
			try {
				int I = Integer.parseInt(command.substring(2));
				if (I > resString.getString().length()) {
					return "";
				}
				return resString.showI(resString.getString(), I);
			} catch (Exception e) {
				// TODO: handle exception
				return "";
			}
		case 4:
				resString.NumOp.push(number);
			try {
				int pos = resString.stack.size();
				if(resString.stack.peek().equals(resString.getString())) {
					resString.UndoStack.push(resString.stack.peek());
					resString.stack.pop();
				}
				resString.setString(resString.Undo());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return resString.getString();
		case 5:
			resString.NumOp.push(number);
			try {
				if(resString.UndoStack.peek().equals(resString.getString())) {
					resString.stack.push(resString.UndoStack.peek());
					resString.UndoStack.pop();
				}
				resString.setString(resString.Redo());
			} catch (Exception e) {
				// TODO: handle exception
			}
			return resString.getString();
			
		}
		return "";
	}

	static public String addString(String s) {
		return s;
	}

}

class resString {
	static boolean canUndo = false;
	static String result = "";
	static Stack<String> stack = new Stack<>();;
	static Stack<String> UndoStack = new Stack<>();;
	static Stack<Integer> NumOp = new Stack<>();;

	static public void setString(String com) {
		result = com;
	}

	static public void addString(String com) {
		result += com;
	}

	static public String getString() {
		return result;
	}

	static public String showI(String s, int I) {
		if (I > s.length())
			return "";
		else {
			char[] tmp = s.toCharArray();
			String tmpString = "";
			tmpString += tmp[I];
			return tmpString;
		}

	}

	static public String Redo() {
		result = UndoStack.pop();
		stack.push(result);
		return result;
	}

	static public String Undo() {
		result = stack.pop();
		UndoStack.push(result);
		return result;
	}
	
	static public void clearStacks() {
		stack.clear();
		UndoStack.clear();
		NumOp.clear();
	}

	static public void deleteN(int N) {
		String tmp = "";
		char[] t = getString().toCharArray();
		for (int i = 0; i < t.length - N; i++) {
			tmp += t[i];
		}
		result = "";
		addString(tmp);
	}
}
