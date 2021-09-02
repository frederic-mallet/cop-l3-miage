package tp2.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import complexity.Complexity;
import test.TestSignature;
import tp2.entiers.RechercheDichotomiqueIterative;

public class RechercheDichotomiqueIterativeTest {
	private Random generateur = new Random();

	@Test
	public void testRechercheDichotomiqueIterative() {
		TestSignature test = new TestSignature(RechercheDichotomiqueIterative.class);
		
		test.publicConstructors(1);
		test.publicConstructor(int[].class);
	}

	@Test
	public void testCherche() {
		int [] tab = new RechercheTableauxTest().generateTab(100, 1000, -10000, 10000);

		RechercheDichotomiqueIterative r = new RechercheDichotomiqueIterative(tab);
		assertEquals(-1, r.findN(200));

		int pos = generateur.nextInt(tab.length);
		int ind = r.findN(r.get(pos));
		assertTrue(ind + ":" + pos, ind <= pos);
	}


	@Test
	public void testComplexityFindWhenNotThere() {
		System.out.print("Testing complexity find (Dichotomique) : expect log ");
		Complexity.LOG = false;
		double v = Complexity.evalLog(
				taille -> {	
					int [] tab = new RechercheTableauxTest().generateTab(taille, taille, -10000, 10000);
					return new RechercheDichotomiqueIterative(tab);
				}, 
				r -> { r.findN(200); }, 
				5, 9); // 10^5 -> 10^9
		System.out.println("\t-> dt=" + v);
		Complexity.LOG = false;
		assertTrue(v < 0.1); // Expect log
	}	
}
