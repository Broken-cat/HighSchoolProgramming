
public class Level1 {
	
	/* Первые попытки решения задачи оказались неудачными, так как подзабыл, как 
	работает рекурсия и пытался запихнуть всё в один метод.
	Для решения задачи решил разбить на подзадачи: вычисление факториала
	и нахождения первой цифры.	
	/*
	
	static int squirrel(int N) {
		return Character.getNumericValue(String.valueOf(N).charAt(0));
	}
	
	static int fac(int N) {
		if (N ==0 ) return 1;		
		return N = N * (fac(N - 1));
	}
}
