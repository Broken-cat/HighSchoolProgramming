
public class Level1 {

	
	static int odometer(int [] oksana) {
		int tmp = 0;
		for (int i = 0; i < oksana.length; i+=2) {
			if(i == 0 ){
				tmp += oksana[i]*(oksana[i+1]);
			} else {
				tmp += oksana[i] * (oksana[i+1] - oksana[i-1]);
			}			
		}
		return tmp;
	}
}
