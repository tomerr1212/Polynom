package myMath;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MonomTest {

	@Test
	void testF() {
		Monom m=new Monom(3,2);
		double y=m.f(2);
		assertEquals(12, y);
	}

	@Test
	void testAdd() {
		Monom m1=new Monom(2,4);
		Monom m2=new Monom(1,4);
		Monom m3 = m1.add(m2);
		Monom ans = new Monom (3,4);
		assertTrue(ans.equals(m3));
	}

	@Test
	void testMultiply() {
		Monom m1=new Monom(2,4);
		Monom m2=new Monom(1,3);
		Monom m3 = m1.multiply(m2);
		Monom ans = new Monom (2,7);
		assertTrue(ans.equals(m3));
	}

	@Test
	void testDerivative() {
		Monom m=new Monom(4,6);
		Monom ans = new Monom (24,5);
		assertTrue(ans.equals(m.derivative()));
	}

	@Test
	void testEqualsMonom() {
		Monom m1=new Monom(2,4);
		Monom m2=new Monom(2,4);
		assertEquals(m2.get_coefficient(), m1.get_coefficient());
		assertEquals(m2.get_power(), m1.get_power());
	}

	@Test
	void testToString() {
		Monom m1 = new Monom (3,2);
		Monom m2 =new Monom ("3x^2");
		assertTrue(m1.equals(m2));
	}

}
