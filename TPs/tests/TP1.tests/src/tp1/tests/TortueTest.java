package tp1.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import test.TestSignature;
import tp1.turtle.Tortue;

public class TortueTest {
	@Test
	public void testTurtle() {
		TestSignature test = new TestSignature(Tortue.class);
		test.publicConstructors(2);
		test.publicConstructor(); // default constructor
		test.publicConstructor(double.class, double.class, double.class); //x, y, angle
		
		Tortue t = new Tortue();
		assertEquals("initial x", 0.0, t.getX(), 1e-4);
		assertEquals("initial Y", 0.0, t.getY(), 1e-4);
		assertEquals("initial direction", 90.0, t.getDirection(), 1e-4);
	}
	
	double[] x = { 0.0, 10.0, 10.0, 0.0 };
	double[] y = { 10.0, 10.0, 0.0, 0.0 };
	@Test
	public void testSquare() {
		Tortue t = new Tortue();
		for (int i = 0; i < 4; i++) {
			t.avance(10);

			assertEquals("x " + i, x[i], t.getX(), 1e-4);
			assertEquals("y " + i, y[i], t.getY(), 1e-4);			
			
			t.droite(90);
		}
		assertEquals("x", 0.0, t.getX(), 1e-4);
		assertEquals("Y", 0.0, t.getY(), 1e-4);
		assertEquals("direction", 90, t.getDirection());
	}
}
