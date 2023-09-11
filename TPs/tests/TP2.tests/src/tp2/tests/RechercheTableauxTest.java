package tp2.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import complexity.Complexity;
import tp2.entiers.statique.RechercheTableaux;

public class RechercheTableauxTest {
	private Random generateur = new Random();

	public int[] generateTab(int minLength, int maxLength, int minValue, int maxValue) {
		int[] val;
		if (minLength == maxLength) val = new int[minLength];
		else val = new int[generateur.nextInt(maxLength - minLength) + minLength];

		for (int i = 0; i < val.length; i++) {
			val[i] = generateur.nextInt(maxValue - minValue) + minValue;
		}
		return val;
	}

	@Test
	public void testFindNinT() {
		int [] tab = generateTab(100, 1000, -100, 100);

		assertEquals(-1, RechercheTableaux.findNinT(tab, 200));

		int pos = generateur.nextInt(tab.length);
		int ind = RechercheTableaux.findNinT(tab, tab[pos]);
		assertNotEquals("L'élément n'a pas été trouvé", ind, -1);
		assertEquals(tab[ind], tab[pos]);

		tab[pos] = 42;
		int p = RechercheTableaux.findNinT(tab, 42);
		assertNotEquals("L'élément n'a pas été trouvé", p, -1);
		assertEquals(tab[p], tab[pos]);
	}

	@Test
	public void testCountNsinT() {
		int [] tab = generateTab(100, 1000, -100, 100);
		assertEquals(0, RechercheTableaux.countNsinT(tab, 200));

		int pos = generateur.nextInt(tab.length);
		tab[pos] = 200;
		assertEquals(1, RechercheTableaux.countNsinT(tab, 200));

		tab = new int[1000];
		for (int i=0; i < 1000; i++)
			tab[i] = i%2==0?42:10;
		assertEquals(500, RechercheTableaux.countNsinT(tab, 42));
		assertEquals(500, RechercheTableaux.countNsinT(tab, 10));		
	}

	@Test
	public void testFindAllNsinT() {
		for (int i = 0; i < 10; i++) {
			int [] tab = generateTab(100, 1000, -10000, 10000);
			int rand = generateur.nextInt(tab.length);
			int [] res = RechercheTableaux.findAllNsinT(tab, tab[rand]);
			assertEquals(res.length, RechercheTableaux.countNsinT(tab, tab[rand]));
			for (int v : res) {
				assertEquals(tab[rand], tab[v]);
			}
		}
	}

	@Test
	public void testFindNinSortedT() {
		int [] tab = generateTab(100, 1000, -100, 100);
		Arrays.sort(tab);
		assertEquals(-1, RechercheTableaux.findNinSortedT(tab, 200));

		int pos = generateur.nextInt(tab.length);
		int ind = RechercheTableaux.findNinSortedT(tab, tab[pos]);
		assertNotEquals("L'élément n'a pas été trouvé", ind, -1);
		assertEquals(tab[ind], tab[pos]);		

		tab[pos] = 42;
		Arrays.sort(tab);
		int p = RechercheTableaux.findNinSortedT(tab, 42);
		assertNotEquals("L'élément n'a pas été trouvé", -1, p);
	}

	@Test
	public void testFindAllNsinSortedT() {
		for (int i = 0; i < 10; i++) {
			int [] tab = generateTab(100, 1000, -10000, 10000);
			Arrays.sort(tab);

			int rand = generateur.nextInt(tab.length);
			int [] res = RechercheTableaux.findAllNsinSortedT(tab, tab[rand]);
			assertEquals(res[1] - res[0] + 1, RechercheTableaux.countNsinT(tab, tab[rand]));
			for (int j = res[0]; j < res[1]; j++) {
				assertEquals(tab[rand], tab[j]);
			}
		}
	}

	@Test
	public void testComplexityFindWhenNotThere() {
		System.out.print("Testing complexity find when not there (static): expect linear ");
		Complexity.LOG = false;
		double v = Complexity.eval(
				taille -> {	return generateTab(taille, taille, -10000, 10000); }, 
				tab -> { RechercheTableaux.findNinT(tab, 100000); }, 
				4, 9); // 10^4 -> 10^9
		System.out.println("\t-> t(N)=N^" + v);
		assertEquals(1.0, v, 0.3); // Expect a linear complexity
	}
	

	@Test
	public void testComplexityCount() {
		System.out.print("Testing complexity count (static) : expect linear");
		Complexity.LOG = false;
		double v = Complexity.eval(
				taille -> {	return generateTab(taille, taille, -100, 100); }, 
				tab -> { RechercheTableaux.countNsinT(tab, 42); }, 
				4, 9); // 10^4 -> 10^9
		System.out.println("\t-> t(N)=N^" + v);
		assertTrue(v < 1.15); // Expect a linear complexity (tolerates 15%
	}
}
