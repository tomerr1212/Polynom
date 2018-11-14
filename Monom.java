package myMath;

//import javax.management.RuntimeErrorException;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Ortal and Tomer
 *
 */
public class Monom implements function{

	public Monom(double a, int b){
		if(b < 0) {
			return;		
		}
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	public double get_coefficient() {
		return _coefficient;
	}
	public int get_power() {
		return _power;
	}

	public double f(double x) {
		return this._coefficient*(Math.pow(x, this._power));
	}
	public Monom add (Monom m) {
		if (this._power != m._power)  return null;
		return new Monom(m._coefficient + this._coefficient, m._power);
	}
	public Monom multiply (Monom m) {
		return new Monom(this._coefficient*m._coefficient, this._power+m._power);
	}
	public Monom derivative () {
		if(this._power == 0) {
			return new Monom(0, this._power-1);
		}
		return new Monom(this._coefficient*this._power, this._power -1);
	}
	public boolean equals(Monom ot) {
		if(this.get_coefficient() != ot.get_coefficient()) {
			return false;
		}
		if(this.get_power() != ot.get_power()) {
			return false;
		}
		return true;
	}

	public String toString() {
		if(this._power == 0) {
			return this._coefficient +" ";
		}
		return ""+this._coefficient + "x^" + this._power;
	}

	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		this._power = p;
	}

	private double _coefficient; // 
	private int _power; 

	public Monom(String st){
		if(st == null) {
			throw new RuntimeException("The String is empty try again");
		}

		st.toLowerCase();
		st.replaceAll(" ", "");

		for (int i = 0; i < st.length(); i++) {
			if((st.charAt(i)>= '0' && st.charAt(i) <= '9')) {
				
			}
			else if(st.charAt(i)!= 'x' && st.charAt(i) != '.' && st.charAt(i)!= '+'&& st.charAt(i) != '-' && st.charAt(i) != '^' ) {
				throw new RuntimeException("The String contains wrong charcters");
			}	
		}

		String k1 = "x^";
		String k2 = "x";


		if(!st.contains(k1) && !st.contains(k2)) {
			_coefficient = Double.parseDouble(st);
			_power = 0;
		}	

		else if(st.contains(k2)&&!st.contains(k1)) {
			String coeff ="";
			coeff=coeff+st.substring(0,st.length()-1);
			double a = Double.parseDouble(coeff);
			_coefficient = a;
			_power = 1;
		}
		else if(st.contains(k1)) {
			String coeff = "";
			String pow = "";
			coeff = coeff+ st.substring(0, st.indexOf(k2));
			pow = pow+st.substring(st.indexOf(k2)+2, st.length());
			double a = Double.parseDouble(coeff);
			int b = Integer.parseInt(pow);

			_coefficient = a;
			_power = b;
		}

	}

}