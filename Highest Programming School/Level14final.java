

public class Level1 {
	static int Unmanned(int L, int N, int[][] track) {
		int time = 0;
		int k = 0;
		Svetophor[] svetophors = new Svetophor[N];
		for (int i = 0; i < track.length; i++) {

			svetophors[i] = new Svetophor(track[i][0], track[i][1], track[i][2]);
		}

		for (int i = 0; i < L; i++) {
			for (Svetophor s : svetophors)
				s.stepTime();
			
			
			if (i+1 == svetophors[k].getTurn()) {	
				time++;
				if (svetophors[k].isGreen()) {				
					if(k < N-1)k++;
					continue;
				} else {

					time += svetophors[k].Wait();
					if(k < N-1)k++;
				
					
				}
			} else {
				time++;
			}
			
		}

		return time;
	}

}

class Svetophor {
	private int step;
	private int turn;
	private int redTime, greenTime;
	private boolean isGreen;
	private int greenTmp, redTmp;

	public Svetophor(int a, int redLight, int greenLight) {
		// TODO Auto-generated constructor stub
		step = 0;
		turn = a;
		redTime = redLight;
		greenTime = greenLight;
		isGreen = false;
		greenTmp = greenLight;
		redTmp = redLight;
	}

	public int getredTime() {
		return redTime;
	}
	
	public int getGreenTime() {
		return greenTime;
	}

	public int getTurn() {
		return turn;
	}

	public boolean isGreen() {
		return isGreen;
	}

	public void stepTime() {
		
		
		if (isGreen == false) {
			if (redTime != 0) {
				redTime--;

			} else {
				redTime = redTmp;
				redTime--;
				isGreen = true;
			}
		} else {
			if (greenTime != 0) {
				greenTime--;
			} else {
				greenTime = greenTmp;
				greenTime--;
				isGreen = false;
				step = 0;
			}
		}
	}

	public int Wait() {
		int k = 0;
		while (redTime != 0) {
			redTime--;
			k++;
		}
		return k;
	}


}

class Svetophor {
	private int step;
	private int turn;
	private int redTime, greenTime;
	private boolean isGreen;
	private int greenTmp, redTmp;

	public Svetophor(int a, int redLight, int greenLight) {
		// TODO Auto-generated constructor stub
		step = 0;
		turn = a;
		redTime = redLight;
		greenTime = greenLight;
		isGreen = false;
		greenTmp = greenLight;
		redTmp = redLight;
	}

	public int getredTime() {
		return redTime;
	}
	
	public int getGreenTime() {
		return greenTime;
	}

	public int getTurn() {
		return turn;
	}

	public boolean isGreen() {
		return isGreen;
	}

	public void stepTime() {
		
		
		if (isGreen == false) {
			if (redTime != 0) {
				redTime--;

			} else {
				redTime = redTmp;
				redTime--;
				isGreen = true;
			}
		} else {
			if (greenTime != 0) {
				greenTime--;
			} else {
				greenTime = greenTmp;
				greenTime--;
				isGreen = false;
				step = 0;
			}
		}
	}

	public int Wait() {
		int k = 0;
		while (redTime != 0) {
			redTime--;
			k++;
		}
		return k;
	}

}
