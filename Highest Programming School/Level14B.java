
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
				if(svetophors[k].isGreen()) {
					time++;
					k++;
					continue;
				} else {
					time = svetophors[k].Wait(svetophors[k].getredTime());
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
		if (isGreen == false) {
			if (redTime != step) {
				step++;
			} else {
				isGreen = true;
				step = 0;
			}
		} else {
			if (greenTime != step) {
				step++;
			} else {
				isGreen = false;
				step = 0;
			}
		}
	}

	public int Wait(int time) {
		int k = 0;
		while (time != 0) {
			time--;
			k++;
		}
		return k;
	}

}
