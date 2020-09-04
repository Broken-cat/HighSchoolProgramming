
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
			
			if (i + 1 == svetophors[k].getTurn()) {
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

	public Svetophor(int a, int redLight, int greenLight) {
		// TODO Auto-generated constructor stub
		step = 0;
		turn = a;
		redTime = redLight;
		greenTime = greenLight;
		isGreen = false;
	}

	public int getredTime() {
		return redTime;
	}

	public int getTurn() {
		return turn;
	}

	public boolean isGreen() {
		return isGreen;
	}

	public void stepTime() {
		int g = redTime;
		int s = greenTime;
		if (isGreen == false) {
			if (redTime != 1) {
				redTime--;
			} else {
				redTime = g;
				isGreen = true;
				step = 0;
			}
		} else {
			if (greenTime != 1) {
				greenTime--;
			} else {
				greenTime = s;
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
