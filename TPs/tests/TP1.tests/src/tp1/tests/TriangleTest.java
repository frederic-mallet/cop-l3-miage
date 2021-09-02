package tp1.tests;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import test.TestSignature;
import tp1.Triangle;
import tp1.vecteur.Vecteur;

public class TriangleTest {
	@Test
	public void testVecteur() {
		TestSignature test = new TestSignature(Triangle.class);
		test.publicConstructors(1);
		test.publicConstructor(Vecteur.class, Vecteur.class, Vecteur.class);		
	}
	
	@Test
	public void testPerimetre1() {
		Triangle triangle = new Triangle(new Vecteur(0, 0),
				new Vecteur(3, 0), new Vecteur(0, 4));
		assertEquals(3 + 4 + 5, triangle.perimetre(), 1e-4);
	}
	
	@Test
	public void testPerimetre2() {
		Random gen = new Random();
		int dx = gen.nextInt(20) - 10;
		int dy = gen.nextInt(20) - 10;
		Triangle triangle = new Triangle(new Vecteur(0 + dx, 0 + dy),
				new Vecteur(3 + dx, 0 + dy), new Vecteur(0 + dx, 4 + dy));
		assertEquals(3 + 4 + 5, triangle.perimetre(), 1e-4);
	}
	@Test
	public void testBarycentre() {
		Triangle t = genTriangle(-50, 50);
		Vecteur barycentre = t.barycentre();
		double d1 = Vecteur.sub(t.v1, barycentre).length();
		double d2 = Vecteur.sub(t.v2, barycentre).length();
		double d3 = Vecteur.sub(t.v3, barycentre).length();
		// calcule la longueur des médiatrices
		double m1 = Vecteur.sub(t.v1, Vecteur.add(t.v2, t.v3).multK(.5)).length();
		double m2 = Vecteur.sub(t.v2, Vecteur.add(t.v1, t.v3).multK(.5)).length();
		double m3 = Vecteur.sub(t.v3, Vecteur.add(t.v1, t.v2).multK(.5)).length();
		// le barycentre se trouve au 2/3 des médiatrices
		assertEquals(3.0/2.0, m1/d1, 1e-4);
		assertEquals(3.0/2.0, m2/d2, 1e-4);
		assertEquals(3.0/2.0, m3/d3, 1e-4);
	}
	
	static Triangle genTriangle(int min, int max) {
		Random gen = new Random();
		Vecteur v1 = new Vecteur(gen.nextInt(max-min)+min, gen.nextInt(max-min)+min);
		Vecteur v2 = new Vecteur(gen.nextInt(max-min)+min, gen.nextInt(max-min)+min);
		Vecteur v3 = new Vecteur(gen.nextInt(max-min)+min, gen.nextInt(max-min)+min);
		return new Triangle(v1, v2, v3);		
	}
}
