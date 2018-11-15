package myMath;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.function.Predicate;
//import javax.swing.plaf.synth.SynthStyle;
//import org.omg.Messaging.SyncScopeHelper;
import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Ortal and Tomer
 *
 */
public class Polynom implements Polynom_able{
	private ArrayList<Monom> Poly;
	private final Monom_Comperator SortPow = new Monom_Comperator();
	/**Copy contractor
	 */
	public Polynom (Polynom p) {
		this.Poly = new ArrayList<>();
		Iterator<Monom> a = p.iteretor();
		while(a.hasNext()) {
			this.Poly.add(a.next());
		}
	}
	/**Default contractor
	 */
	public Polynom () {
		this.Poly = new ArrayList<>();
	}

	@Override
	/**
	 * @param x
	 * @return the x value for f(x)
	 */
	public double f(double x) {
		Iterator<Monom> a = iteretor();
		double sum = 0;
		while(a.hasNext()) {
			sum = sum +(a.next().f(x));
		}
		return sum;
	}

	@Override
	/** @param p1 polynom of monoms
	 * adding polynoms to a polynom and sorting by power 
	 */
	public void add(Polynom_able p1) {

		Iterator<Monom> b = p1.iteretor();

		while(b.hasNext()) {
			this.add(b.next());
		}
		removeZero();
	}

	@Override
	/**@param m1 monom
	 * adding monom to a this polynom and sorting by power
	 */
	public void add(Monom m1) {
		Iterator<Monom> a = iteretor();
		if(!a.hasNext()) {
			this.Poly.add(m1);
		}
		else {
			while(a.hasNext()) {
				Monom temp = a.next();
				if(temp.get_power() == m1.get_power()) {

					a.remove();
					this.Poly.add(m1.add(temp));
					this.Poly.sort(SortPow);


					removeZero();
					return;
				}
				else if (!a.hasNext()) {
					this.Poly.add(m1);
					this.Poly.sort(SortPow);
					removeZero();
					return;
				}
			}
		}
	}

	@Override
	/**@param p1 polynom
	 * substract polynoms and sorting by power
	 */
	public void substract(Polynom_able p1) {
		Iterator<Monom> b = p1.iteretor();
		Monom Negative  = new Monom(-1,0);
		if(this.equals(p1)) {
			System.out.println("The answer is 0");
			return;
		}
		else while(b.hasNext()) {
			this.add(b.next().multiply(Negative));
		}
		removeZero();
		System.out.println("The answer is: " + this.Poly.toString());

	}

	@Override
	/**@param p1 polynom
	 * multiply two polynoms
	 */
	public void multiply(Polynom_able p1) {
		Iterator<Monom> a = iteretor();

		Polynom p2 = new Polynom();

		while(a.hasNext()) {
			Iterator<Monom> b = p1.iteretor();
			Monom temp = a.next();

			while(b.hasNext()) {	
				p2.add(temp.multiply(b.next()));
			}
		}
		p2.removeZero();
		this.Poly = p2.Poly;
		System.out.println("The multipication is : " + p2.toString());

	}

	@Override
	/**@param p1 polynom
	 *@return true if the polynoms are the same
	 */
	public boolean equals(Polynom_able p1) {
		Iterator<Monom> a =iteretor();
		Iterator<Monom> b =p1.iteretor();

		while(a.hasNext() && b.hasNext() ) {
			Monom a1 = a.next();
			Monom b1 = b.next();
			if(a1.get_coefficient() != b1.get_coefficient()) {
				return false;
			}
			else if(a1.get_power() != b1.get_power()) {
				return false;
			}
		}
		return true;
	}
	/** remove Monom with coefficient 0 
	 */
	public void removeZero() {
		Iterator<Monom> a = iteretor();
		while ( a.hasNext()) {
			if(a.next().get_coefficient() == 0) {
				a.remove();
			}
		}
	}

	@Override
	/**check if the polynom is a zero polynom (confficients == 0)
	 */
	public boolean isZero() {
		Iterator<Monom> a = iteretor();
		while(a.hasNext()) {
			if(a.next().get_coefficient() != 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	/**@param x0 first edge
	 * param x1 last edge
	 * param eps positive number of steps
	 * @return where the function cuts the x axis
	 */
	public double root(double x0, double x1, double eps) {

		double midx = (x0+x1)/2;
		double midy=f(midx);
		if(f(x0)>0) {
			double temp=x1;
			x1=x0;
			x0=temp;		
		}

		if((f(x0)*f(x1)<0)) { 

			while(Math.abs(midy)>=eps){

				if(f(midx)<0) {
					x0=midx;
					midx=(x0+x1)/2;
					midy=f(midx);								
				}
				else  {
					x1=midx;
					midx=(x0+x1)/2; 
					midy=f(midx);
				}
			}
		}
		return midx;
	}

	@Override
	/**deep copy of polynom
	 */
	public Polynom_able copy() {
		Polynom temp = new Polynom();
		Iterator<Monom> a = iteretor();
		while(a.hasNext()) {
			temp.add(a.next());
		}
		return temp;
	}

	@Override
	/**derivative this polynom
	 */
	public Polynom_able derivative() {
		Iterator<Monom> a = iteretor();
		Polynom d = new Polynom();
		while(a.hasNext()) {
			Monom temp = a.next();
			d.add(temp.derivative());
		}
		d.removeZero();

		return d;

	}

	@Override
	/**@param x0 first edge
	 *@param x1 last edge
	 *@param eps is the approximation 
	 *@return the area between the edges above the x axis
	 */
	public double area(double x0, double x1, double eps) {
		double sum =0;

		while(x0<x1) {
			while(x0 < x1 && this.f(x0)>=0) {

				double a = this.f(x0+eps);
				sum = sum + a*eps;
				x0 = x0 +eps;
			}
			x0 = x0 +eps;
		}
		return sum;
	}

	/**@param x0 first edge
	 *@param x1 last edge
	 *@param eps is the approximation 
	 *@return the area between the edges under the x axis
	 */
	public double areaUnder(double x0, double x1, double eps) {
		double sum =0;
		while(x0<x1) {
			while(x0 < x1 && this.f(x0)<=0) {
				double a = this.f(x0+eps);
				sum = sum + a*eps;
				x0 = x0 +eps;
			}
			x0 = x0 +eps;
		}

		return -1*sum;
	}

	@Override
	public Iterator<Monom> iteretor() {
		Iterator<Monom> It = this.Poly.iterator();
		return It;

	}

	public String toString() {
		String ans = "[";
		Iterator<Monom> it = this.iteretor();

		while(it.hasNext()) {
			Monom m1 = it.next();
			ans = ans + m1;
			if(it.hasNext()) {
				ans =ans + "+";
			}
		}
		ans = ans + "]";
		return ans.replaceAll("\\+-", "-");
	}
	/**@param String str
	 
	 *@return a Polynom  
	 */
	public Polynom (String str){
		this.Poly = new ArrayList<>();
		str.toLowerCase();
		str.replaceAll(" ", "");
		str= str.replaceAll("-", "+-");
		String [] arr_monom=str.split("\\+");
		int i;
		if(arr_monom[0].equals(""))
		{
			i=1;
		}
		else
			i=0;
		for (int j=i;j<arr_monom.length;j++)
		{
			Monom a=new Monom(arr_monom[j]);
			this.add(a);
		}
	}

}
