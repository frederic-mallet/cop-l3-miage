package tests.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import complexity.Complexity;
import test.TestSignature;
import tp2.entiers.RechercheSequentielle;

public class RechercheSequentielleTest {
	private Random generateur = new Random();

	@Test
	public void testRechercheSequentielle() {
		TestSignature test = new TestSignature(RechercheSequentielle.class);
		
		test.publicConstructors(1);
		test.publicConstructor(int[].class);
	}

	@Test
	public void testFindN() {
		int [] tab = new RechercheTableauxTest().generateTab(100, 1000, -10000, 10000);

		RechercheSequentielle r = new RechercheSequentielle(tab);
		assertEquals(-1, r.findN(200));

		int pos = generateur.nextInt(tab.length);
		int ind = r.findN(tab[pos]);
		assertTrue(ind <= pos);
	}

	@Test
	public void testCountNsinT() {
		int [] tab = new RechercheTableauxTest().generateTab(100, 1000, -100, 100);
		RechercheSequentielle r = new RechercheSequentielle(tab);
		assertEquals(0, r.countNs(200));

		int pos = generateur.nextInt(tab.length);
		assertTrue(r.countNs(tab[pos]) >= 1);

		tab = new int[1000];
		for (int i=0; i < 1000; i++)
			tab[i] = i%2==0?42:10;
		r = new RechercheSequentielle(tab);
		assertEquals(500, r.countNs(42));
		assertEquals(500, r.countNs(10));
	}

	@Test
	public void testFindAllNsinT() {
		for (int i = 0; i < 10; i++) {
			int [] tab = new RechercheTableauxTest().generateTab(100, 1000, -10000, 10000);
			RechercheSequentielle r = new RechercheSequentielle(tab);
			int rand = generateur.nextInt(tab.length);
			int [] res = r.findAllNs(tab[rand]);
			assertEquals(res.length, r.countNs(tab[rand]));
			for (int v : res) {
				assertEquals(tab[rand], tab[v]);
			}
		}
	}
	

	@Test
	public void testComplexityFindWhenNotThere() {
		System.out.print("Testing complexity find when not there (Object) : expect linear");
		Complexity.LOG = false;
		double [] v = Complexity.eval(
				taille -> {	
					int [] tab = new RechercheTableauxTest().generateTab(taille, taille, -10000, 10000);
					return new RechercheSequentielle(tab);
				}, 
				r -> { r.findN(20000); }, 
				5, 10); // 10^5 -> 10^10
		System.out.println("\t-> t(N)=N^" + v[v.length-1]);
		assertTrue(v[v.length - 1] < 1.1); // Expect a linear complexity, tolerates 10%
//		System.out.println(Arrays.toString(v));
		//assertEquals(1.0, v, 0.16); // Expect a linear complexity
	}
	

	@Test
	public void testComplexityCount() {
		System.out.print("Testing complexity count (Object) : expect linear");
		Complexity.LOG = false;
		double [] v = Complexity.eval(
				taille -> {	
					int [] tab = new RechercheTableauxTest().generateTab(taille, taille, -100, 100);
					return new RechercheSequentielle(tab);
				}, 
				r -> { r.countNs(42); }, 
				5, 10); // 10^5 -> 10^10
		System.out.println("\t-> t(N)=N^" + v[v.length-1]);
		assertTrue(v[v.length - 1] < 1.1); // Expect a linear complexity, tolerates 10%
//		System.out.println(Arrays.toString(v));
		//assertEquals(1.0, v, 0.16); // Expect a linear complexity
	}
}
