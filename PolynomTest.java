package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolynomTest {

	@Test
	void testF() {
		Polynom p = new Polynom("2x^3+1x^2-4");
		double y = p.f(2);
		assertEquals(16, y);
	}

	@Test
	void testAddPolynom_able() {
		Polynom p1 = new Polynom("2x^3+1x^2-4");
		Polynom p2 = new Polynom("2x^3+2x^1-6");
		p1.add(p2);
		Polynom ans = new Polynom("4x^3+1x^2+2x^1-10");
		assertTrue(ans.equals(p1));
	}

	@Test
	void testAddMonom() {
		Polynom p=new Polynom("2x^3+1x^2-4");
		Monom m=new Monom("2x^3");
		p.add(m);
		Polynom ans=new Polynom("4x^3+1x^2-4");
		assertTrue(ans.equals(p));
	}

	@Test
	void testSubstract() {
		Polynom p1 = new Polynom("2x^3+1x^2-4");
		Polynom p2 = new Polynom("2x^3+2x^1-6");
		p1.substract(p2);
		Polynom ans = new Polynom("1x^2-2x^1+2");
		assertTrue(ans.equals(p1));
	}

	@Test
	void testMultiply() {
		Polynom p1 = new Polynom("2x^3+1x^2-4");
		Polynom p2 = new Polynom("2x^3+2x^1-6");
		Polynom ans = new Polynom("4x^6+2x^5+4x^4-18x^3-6x^2-8x+24");
		p1.multiply(p2);
		assertTrue(ans.equals(p1));
	}

	@Test
	void testEqualsPolynom_able() {
		Polynom p1=new Polynom ("2x^3+1x^2-4") ;
		Polynom p2=new Polynom ("2x^3+1x^2-4") ;
		assertTrue(p1.equals(p2));
	}

	@Test
	void testRemoveZero() {
		Polynom p =new Polynom ("3x^3+2x^2+0x+0");
		Polynom ans = new Polynom("3x^3+2x^2");
		p.removeZero();
		assertTrue(ans.equals(p));
	}

	@Test
	void testIsZero() {
		Polynom p =new Polynom ("0x^4+0x^2+0x+0");
		assertTrue(p.isZero());	}

	@Test
	void testRoot() {		
		Polynom p =new Polynom ("0.2x^4-1.5x^3+3x^2-1x-5");
		assertEquals(-0.94, p.root(-2, 3, 0.01),0.01);	
	}

	@Test
	void testCopy() {
		Polynom p1 =new Polynom("3x^2+2x");
		Polynom_able p2 = p1.copy(); 
		assertTrue(p2.equals(p1));
	}

	@Test
	void testDerivative() {
		Polynom p =new Polynom ("5.0x^2+3.0x^1");
		Polynom ans =new Polynom ("10x^1+3.0");
		assertTrue(p.derivative().equals(ans));
	}

	@Test
	void testArea() {
		Polynom m = new Polynom("-1x^2+36");
		double ans =288;
		assertEquals(ans, m.area(-8, 7, 0.01),0.1);
	}
	@Test
	void testAreaUnder() {		
		Polynom m = new Polynom("0.2x^4-1.5x^3+3.0x^2-1x-5");
		double ans =25.18;
		assertEquals(ans, m.areaUnder(-2, 6, 0.01),0.1);
	}

	@Test
	void testToString() {
		Polynom p =new Polynom ("5.0x^2+3.0x^1");
		String ans ="[" + "5.0x^2+3.0x^1" + "]";
		System.out.println(ans.equals(p.toString()));
		
	}


}
