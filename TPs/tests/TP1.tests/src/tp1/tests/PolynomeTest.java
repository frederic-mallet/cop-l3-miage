package tp1.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import test.TestSignature;
import tp1.poly.Polynome;

public class PolynomeTest {
	
	@Test
	public void testPolynome() {
		TestSignature test = new TestSignature(Polynome.class);
		test.publicConstructors(1);
		test.publicConstructor(double.class, double.class, double.class);		
	}
	
	@Test
	public void testRacine1() {
		Polynome p = new Polynome(1, 1, 1);
		assertEquals(Double.NaN, p.racineReelle1(), 1e-5);
		assertEquals(Double.NaN, p.racineReelle2(), 1e-5);
	}
	
	@Test
	public void testRacine2() {
		Polynome p = new Polynome(1, 0, 0);
		assertEquals(0, p.racineReelle1(), 1e-5);
		assertEquals(0, p.racineReelle2(), 1e-5);
	}
	
	@Test
	public void testRacine3() {
		Polynome p = new Polynome(1, 0, -1);
		assertEquals(1, p.racineReelle1(), 1e-5);
		assertEquals(-1, p.racineReelle2(), 1e-5);
	}
	
	
	@Test
	public void testEval() {
		Polynome p = new Polynome(1, 0, -1);
		for (double d = -10; d < 10; d += 0.1) {
			double v = d*d - 1;
			assertEquals(v, p.eval(d), 1e-5);
		}
	}
}
