package tp1.tests;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import test.TestSignature;
import tp1.RegleDeTrois;

public class RegleDeTroisTest {
	private Random generateur = new Random();
	@Test
	public void testRegleDeTrois() {
		TestSignature test = new TestSignature(RegleDeTrois.class);
		test.publicConstructors(1);
		test.publicConstructor(double.class, double.class);
	}

	@Test
	public void testDe1Vers2() {
		int m1 = generateur.nextInt(1000) - 500;
		int m2 = generateur.nextInt(1000) - 500;
		RegleDeTrois rdt = new RegleDeTrois(m1, m2);
		assertEquals(m2, rdt.de1Vers2(m1), 1e-4);
		assertEquals(0, rdt.de1Vers2(0), 1e-4);
	}

	@Test
	public void testDe2Vers1() {
		int m1 = generateur.nextInt(1000) - 500;
		int m2 = generateur.nextInt(1000) - 500;
		RegleDeTrois rdt = new RegleDeTrois(m1, m2);
		assertEquals(m1, rdt.de2Vers1(m2), 1e-4);
		assertEquals(0, rdt.de2Vers1(0), 1e-4);
	}

}
