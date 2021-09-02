package tp2.tests;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import test.TestSignature;
import tp2.vecteur.Vecteur2D;

public class Vecteur2DTest {
	private Random generateur = new Random();
	
	static void testX(double expected, Vecteur2D v) {
		test("x", expected, v.getX());
	}
	static void testY(double expected, Vecteur2D v) {
		test("y", expected, v.getY());
	}
	static private void test(String dim, double expected, double actual) {
		assertEquals("wrong " + dim, expected, actual, 1e-4);		
	}
	@Test
	public void testVecteur2D() {
		TestSignature test = new TestSignature(Vecteur2D.class);
		test.publicConstructors(1);
		test.publicConstructor(double.class, double.class);
		
		Vecteur2D v = new Vecteur2D(3, 4);
		testX(3, v);
		testY(4, v);
	}

	@Test
	public void testLength() {
		Vecteur2D v = new Vecteur2D(3, 4);
		assertEquals(v.length(), 5, 1e-4);
	}

	private int generateRandomInteger(int min, int max) {
		return generateur.nextInt(max - min) + min;
	}
	private Vecteur2D generateRandomVecteur2D(int min, int max) {
		int x = generateRandomInteger(min * 10, max * 10);
		int y = generateRandomInteger(min * 10, max * 10);
		return new Vecteur2D(x / 10.0 , y / 10);
	}
	@Test
	public void testTranspose() {
		Vecteur2D v = generateRandomVecteur2D(-500, 500);
		Vecteur2D t = v.transpose();
		testX(v.getY(), t);
		testY(v.getX(), t);
	}

	@Test
	public void testOppose() {
		Vecteur2D v = generateRandomVecteur2D(-500, 500);
		Vecteur2D minusV = v.opposé();
		testX(-v.getX(), minusV);
		testY(-v.getY(), minusV);
	}
	
	@Test
	public void testMultK() {
		Vecteur2D v = generateRandomVecteur2D(-500, 500);
		int k = generateRandomInteger(-10, 10);
		Vecteur2D vk = v.multK(k);
		
		testX(v.getX() * k, vk);
		testY(v.getY() * k, vk);
	}

	@Test
	public void testAdd() {
		Vecteur2D v1 = generateRandomVecteur2D(-500, 500);
		Vecteur2D v2 = generateRandomVecteur2D(-500, 500);
		Vecteur2D v = Vecteur2D.add(v1, v2);
		testX(v1.getX() + v2.getX(), v);
		testY(v1.getY() + v2.getY(), v);
	}

	@Test
	public void testSub() {
		Vecteur2D v1 = generateRandomVecteur2D(-500, 500);
		Vecteur2D v2 = generateRandomVecteur2D(-500, 500);
		Vecteur2D v = Vecteur2D.sub(v1, v2);
		testX(v1.getX() - v2.getX(), v);
		testY(v1.getY() - v2.getY(), v);
	}

	@Test
	public void testProduitScalaire1() {
		Vecteur2D v = generateRandomVecteur2D(-500, 500);
		double p = Vecteur2D.produitScalaire(v, v);
		double sqrLength = v.length() * v.length();
		assertEquals("v.v=||v||^2", sqrLength, p, 1e-4);
	}

	@Test
	public void testProduitScalaire2() {
		Vecteur2D v = generateRandomVecteur2D(-500, 500);
		// rotate by 90 degrees
		Vecteur2D vR = new Vecteur2D(-v.getY(), v.getX());
		double p = Vecteur2D.produitScalaire(v, vR);
		assertEquals("v.vT = 0 iif v and vT are orthogonal", 0, p, 1e-4);
	}
	
	@Test
	public void testProduitVectoriel1() {
		Vecteur2D v = generateRandomVecteur2D(-500, 500);
		double p = Vecteur2D.produitVectoriel(v, v);
		assertEquals("v.v = 0", 0, p, 1e-4);
	}

	
	@Test
	public void testProduitVectoriel2() {
		Vecteur2D v = generateRandomVecteur2D(-500, 500);
//		if (v.getX() == 0 && v.getY() == 0) v.x = 1; // avoid length 0
		// rotate by 90 degrees
		Vecteur2D vR = new Vecteur2D(-v.getY(), v.getX());
		double p = Vecteur2D.produitVectoriel(v, vR) / v.length() / vR.length();
		assertEquals(1, p, 1e-4);
	}
	@Test
	public void testToString() {
		Vecteur2D v = new Vecteur2D(3, 4);
		String s = v.toString();
		assertEquals("<3.0, 4.0>", s);
	}
}
