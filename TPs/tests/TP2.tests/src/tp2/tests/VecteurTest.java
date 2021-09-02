package tp2.tests;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import test.TestSignature;
import tp2.vecteur.Vecteur;

public class VecteurTest {
	private Random generateur = new Random();

	private Vecteur generateVecteur(int minLength, int maxLength, int minValue, int maxValue) {
		double [] val;
		if (minLength == maxLength) val = new double[minLength];
		else val = new double[generateur.nextInt(maxLength - minLength) + minLength];
		
		for (int i = 0; i < val.length; i++) {
			val[i] = generateur.nextDouble() * (maxValue - minValue) + minValue;
		}
		return new Vecteur(val);
	}
	@Test
	public void testVecteurSig() {
		TestSignature test = new TestSignature(Vecteur.class);
		test.publicConstructors(2);
		test.publicConstructor(double[].class);
		test.publicConstructor(int.class, double[].class);
	}
	@Test
	public void testVecteurDoubleArray() {
		for (int i = 0; i < 100; i++)
			testVecteurDoubleArray(i);
	}
	private void testVecteurDoubleArray(int iteration) {
		double [] val = new double[generateur.nextInt(8) + 2];
		for (int i = 0; i < val.length; i++) {
			val[i] = generateur.nextDouble() * 200 - 100;
		}
		Vecteur v = new Vecteur(val);
		assertEquals(val.length, v.dimension());
		for (int i = 0; i < v.dimension(); i++)
			assertEquals(val[i], v.get(i), 1e-4);
	}

	@Test
	public void testVecteurIntDoubleArray() {
		for (int i = 0; i < 100; i++)
			testVecteurIntDoubleArray(i);
	}
	// Ensure vecteurs works also with double values, not just int typed as double
	private void testVecteurIntDoubleArray(int iteration) {
		int dim = generateur.nextInt(8) + 2;
		double [] val = new double[generateur.nextInt(10)];
		for (int i = 0; i < val.length; i++) {
			val[i] = generateur.nextDouble() * 200 - 100;
		}
		Vecteur v = new Vecteur(dim, val);
		assertEquals(dim, v.dimension());
		for (int i = 0; i < v.dimension(); i++)
			if (i < val.length)
				assertEquals(val[i], v.get(i), 1e-4);
			else
				assertEquals(0, v.get(i), 1e-4);
	}

	@Test
	public void testLength() {
		for (int i = 0; i < 10; i++) {
			Vecteur v1 = generateVecteur(2, 10, 0, 0);
			assertEquals(0, v1.length(), 1e-4);

			int dim = generateur.nextInt(8) + 2;
			double[] val = new double[dim];
			double v = generateur.nextDouble() * 200 - 100;
			val[generateur.nextInt(dim)] = v;
			Vecteur v2 = new Vecteur(val);
			assertEquals(Math.abs(v), v2.length(), 1e-4);
		}
		Vecteur v = new Vecteur(3.0, 4.0);
		assertEquals(v.length(), 5, 1e-4);
	}

	@Test
	public void testOpposé() {
		// adding a vecteur to its opposé should result in vecteur null
		for (int i = 0; i < 10; i++) {
			Vecteur v = generateVecteur(2, 10, -100, 100);
			Vecteur vo = v.opposé();
			assertEquals(v.dimension(), vo.dimension());

			Vecteur s = Vecteur.add(v, vo);
			for (int j = 0; j < v.dimension(); j++) {
				assertEquals(0.0, s.get(j), 1e-4);
			}
		}
	}

	@Test
	public void testTranspose() {
		for (int i = 0; i < 10; i++) {
			Vecteur v = generateVecteur(2, 2, -500, 500);
			Vecteur vt = v.transpose();
			assertEquals(v.dimension(), vt.dimension());
			assertEquals(v.get(1), vt.get(0), 1e-4);
			assertEquals(v.get(0), vt.get(1), 1e-4);
			Vecteur vtt = vt.transpose();
			assertEquals(v.dimension(), vtt.dimension());
			
			for (int j = 0; j < v.dimension(); j++) {
				assertEquals(v.get(j), vtt.get(j), 1e-4);
			}
		}
	}

	@Test
	public void testMultK() {
		for (int i = 0; i < 10; i++) {
			Vecteur v = generateVecteur(2, 10, -500, 500);
			double k = generateur.nextDouble() * 100 - 50;
			Vecteur vt = v.multK(k);
			assertEquals(v.dimension(), vt.dimension());
			
			for (int j = 0; j < v.dimension(); j++) {
				assertEquals(v.get(j) * k, vt.get(j), 1e-4);
			}
		}
	}

	@Test
	public void testAdd() {
		for (int i = 0; i < 10; i++) {
			Vecteur v1 = generateVecteur(2, 10, -500, 500);
			Vecteur v = Vecteur.add(v1, v1, v1);
			assertEquals(v.dimension(), v1.dimension());
			
			// multiplication
			for (int j = 0; j < v1.dimension(); j++) {
				assertEquals(v1.get(j) * 3, v.get(j), 1e-4);
			}
			
			Vecteur v2 = generateVecteur(v1.dimension(), v1.dimension(), -500, 500);
			Vecteur v12 = Vecteur.add(v1, v2);
			Vecteur v21 = Vecteur.add(v2, v1);
			// test commutativité
			for (int j = 0; j < v1.dimension(); j++) {
				assertEquals(v12.get(j), v21.get(j), 1e-4);
			}
			
			Vecteur v0 = generateVecteur(v1.dimension(), v1.dimension(), 0, 0);
			Vecteur v10 = Vecteur.add(v1, v0, v0, v0);
			// element neutre
			for (int j = 0; j < v1.dimension(); j++) {
				assertEquals(v1.get(j), v10.get(j), 1e-4);
			}
		}
	}

	@Test
	public void testSub() {
		for (int i = 0; i < 10; i++) {
			Vecteur v1 = generateVecteur(2, 10, -500, 500);
			Vecteur v = Vecteur.sub(v1, v1);
			assertEquals(v.dimension(), v1.dimension());
			
			for (int j = 0; j < v1.dimension(); j++) {
				assertEquals(0.0, v.get(j), 1e-4);
			}
			
			Vecteur v2 = generateVecteur(v1.dimension(), v1.dimension(), -500, 500);
			Vecteur v12 = Vecteur.sub(v1, v2);
			Vecteur v21 = Vecteur.sub(v2, v1);
			// test commutativité
			for (int j = 0; j < v1.dimension(); j++) {
				assertEquals(-v12.get(j), v21.get(j), 1e-4);
			}
			
			Vecteur v0 = generateVecteur(v1.dimension(), v1.dimension(), 0, 0);
			Vecteur v10 = Vecteur.sub(v1, v0, v0, v0);
			// element neutre
			for (int j = 0; j < v1.dimension(); j++) {
				assertEquals(v1.get(j), v10.get(j), 1e-4);
			}
		}
	}

	@Test
	public void testProduitScalaire1() {
		Vecteur v = generateVecteur(2, 10, -500, 500);
		double p = Vecteur.produitScalaire(v, v);
		double sqrLength = v.length() * v.length();
		assertEquals("v.v=||v||^2", sqrLength, p, 1e-4);
	}

	@Test
	public void testProduitScalaire2() {
		Vecteur v = generateVecteur(2, 2, -500, 500);
		// rotate by 90 degrees
		Vecteur vR = new Vecteur(-v.get(1), v.get(0));
		double p = Vecteur.produitScalaire(v, vR);
		assertEquals("v.vT = 0 iif v and vT are orthogonal", 0, p, 1e-4);
	}

	@Test
	public void testProduitScalaire3() {
		for (int i = 0; i < 10; i++) {
			Vecteur v1 = generateVecteur(2, 10, -500, 500);
			Vecteur v2 = generateVecteur(v1.dimension(), v1.dimension(), -500, 500);
			
			double p12 = Vecteur.produitScalaire(v1, v2);
			double p21 = Vecteur.produitScalaire(v1, v2);
 // 	commutativité
			assertEquals(p12, p21, 1e-4);
			
			// multiply by zero
			Vecteur _0 = generateVecteur(v1.dimension(), v1.dimension(), 0, 0);
			double p0 = Vecteur.produitScalaire(v1, _0);
			assertEquals(0.0, p0, 1e-4);
		}
	}

	@Test
	public void testProduitScalaire4() {
		for (int i = 0; i < 10; i++) {
			Vecteur v1 = generateVecteur(3, 3, -500, 500);
			Vecteur v2 = generateVecteur(3, 3, -500, 500);
						
			Vecteur v3 = Vecteur.produitVectoriel(v1, v2);
			
			assertEquals(0.0, Vecteur.produitScalaire(v1, v3), 1e-4);
			assertEquals(0.0, Vecteur.produitScalaire(v2, v3), 1e-4);
		}
	}

	@Test
	public void testProduitVectoriel1() {
		Vecteur v1 = new Vecteur(1.0, 0.0, 0.0);
		Vecteur v2 = new Vecteur(0.0, 1.0, 0.0);
					
		Vecteur v12 = Vecteur.produitVectoriel(v1, v2);
		assertEquals(0.0, v12.get(0), 1e-4);
		assertEquals(0.0, v12.get(1), 1e-4);
		assertEquals(1.0, v12.get(2), 1e-4);
		Vecteur v21 = Vecteur.produitVectoriel(v2, v1);
		assertEquals(0.0, v21.get(0), 1e-4);
		assertEquals(0.0, v21.get(1), 1e-4);
		assertEquals(-1.0, v21.get(2), 1e-4);
	}
}
