package tp2.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import tp2.vecteur.Vecteur;

/**
 * Test Polygon TP2
 * @author fmallet
 *
 */
public class PolygoneTest {
	private Random gen = new Random();
	/**
	 * Verify that the polygon does not change when the input array of points change
	 */
	@Test
	public void testNotModified() {
		Vecteur[] points = new Vecteur[gen.nextInt(7) + 3];
		for (int i = 0; i < points.length; i++) {
			points[i] = new Vecteur(gen.nextDouble() * 20, gen.nextDouble() * 20);
		}
		Polygone poly = new Polygone(points);
		double p = poly.perimetre();
		Vecteur zero = new Vecteur(0.0, 0.0);
		Arrays.fill(points, zero);
		
		double newP = poly.perimetre();
		assertEquals(p, newP, 1e-4); // the perimetre should not change when changing the points
	}
	
	/**
	 * Check that the dimension is assigned correctly
	 */
	@Test
	public void testDim() {
		int dim = gen.nextInt(7) + 3; 
		// build a regular polygon with dim sides of length 10 (equilateral triangle)
		Polygone poly = RegularPolygonBuilder.mkRegularPolygon(dim, 10);
		// expect to find dim points
		assertEquals(dim, poly.numberOfPoints());
	}
	
	@Test
	public void testBarycentre() {
		// build a regular polygon with 4 sides of length 10 (a square)
		Polygone poly = RegularPolygonBuilder.mkRegularPolygon(4, 10);
		Vecteur b = poly.barycentre();
		// expect the barycentre to be in the middle
		assertEquals(5.0, b.get(0), 1e-4);
		assertEquals(5.0, b.get(1), 1e-4);
	}
	
	@Test
	public void testPerimeter() {
		// for different sizes of polygon
		for (int i = 3; i < 10; i++) {
			// build a regular polygon with i sides of length 10
			Polygone poly = RegularPolygonBuilder.mkRegularPolygon(i, 10);
			double p = poly.perimetre();
			// expect the perimetre to be i * 10
			assertEquals(10 * i, p, 1e-4);
		}
	}
	
	@Test
	public void testTriangulation() {
		// for different sizes of polygon
		for (int i = 3; i < 10; i++) {
			// build a regular polygon with i sides of length 10
			Polygone poly = RegularPolygonBuilder.mkRegularPolygon(i, 10);
			Polygone[] triangles = poly.triangulation();
			// expect size to be i-2
			assertEquals(i - 2, triangles.length);
			Polygone before = null;
			for (Polygone t : triangles) {
				assertNotNull(t);
				assertTrue(t != before); // None of them should be identical to the previous one
				before = t;
			}
		}		
	}
}
