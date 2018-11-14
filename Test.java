package myMath;


//import javax.swing.plaf.synth.SynthStyle;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("######test######");
		test();
		
	}

	public static void test() {
//		
//		Monom m =new Monom("3");
//		System.out.println(m);
//		Polynom p1=new Polynom ("4x^1+5x^2");
		Polynom p2=new Polynom ("-1x^5-4+5x^2+5x^3");
//		System.out.println("the first polynom is:"+p1);
//		System.out.println("the second polynom is:"+p2);
//		p2.substract(p1);
//		System.out.println("the original first polynom is:"+p1);
//		System.out.println("the answer after substract:"+p2);
//
//
//		Polynom p3 = new Polynom();
//		Polynom p4 = new Polynom();
//		Polynom p5 = new Polynom();
//		Polynom p6 = new Polynom();
//		Monom a = new Monom(1,0);
//		Monom b = new Monom(4,2);
//		Monom c = new Monom(0,3);
//		Monom d = new Monom(-5,3);
//		Monom e = new Monom(0,2);
//		Monom f = new Monom(-0.5,2);
//		Monom g = new Monom(9,3);
//		Monom i = new Monom(8,5);
//		Monom j = new Monom(-1,4);
//		Monom k = new Monom(2,2);
//		Monom l = new Monom(-0.5,2);
//
//		//add Monoms
//		p3.add(g);
//		p3.add(i);
//		p4.add(j);
//		p4.add(k);
//		p4.add(l);
//		p5.add(a);
//		p5.add(b);
//		p5.add(c);
//		p6.add(d);
//		p6.add(e);
//		p6.add(f);
//		System.out.println("Polynom p3 = " + p3);
//		System.out.println("Polynom p4 = " + p4);
//		System.out.println("Polynom p5  = " + p5);
//		System.out.println("Polynom p6 = " + p6);
		
		//Root
		System.out.println("The x axis cut is on : " + p2.root(2, 5, 0.01));

//		//f(x)
//		System.out.println("The value in F(x) : " +p3.f(6));
//		System.out.println("The value in F(x) : " +p4.f(6));
//		System.out.println("The value in F(x) : " +p5.f(-10));
//		System.out.println("The value in F(x) : " +p6.f(80));
//		
//		//add Polynom
//		p5.add(p6);
//		System.out.println("The addition to the Polynom is: " + p5);
//
//		//Substract Polynom
//		p3.substract(p5);
//
//		//Multiply
//		p3.multiply(p4);
//
//		//Derivative
//		System.out.println("The derivative of p4: " + p4.derivative());		
//
//		//Area
//		System.out.println("The area is : " + p4.area(-0.2, 0.2, 1));
//		System.out.println("The area is : " + p4.area(-0.2, 0.2, 0.1));
//
//		//Is the Zero polynom
//		System.out.println("Is all monoms are 0? : " +p4.isZero());		
//		System.out.println(p4.toString());
	
		
	}
}
