package myMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {

	@Override
	public int compare(Monom x1, Monom x2) {

		if(x1.get_power()>x2.get_power()) {
			return -1;
		}
		else if(x1.get_power() == x2.get_power()) {
			return 0;
		}
		else {
			return 1;
		}
	}

}
