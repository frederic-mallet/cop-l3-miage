package v2;

import java.util.Arrays;

import common.Time;

/**
 * Version plus compliquée que la version présentée en cours
 * mais garde les valeurs d'un appel à l'autre.
 */
public class Fibonacci {
	// Init with Fibonacci(0) and Fibonacci(1)
	// Not null, to make sure Arrays.copyOf works all the time
	static int[] tab = {0, 1}; 
	
	static int fibonacci(int n) {
		if (n >= tab.length)
			tab = Arrays.copyOf(tab, n+1); // keep the values already computed, and fill with 0
		
		return fibTab(n);
	}
	private static int fibTab(int n) {
		if (n == 0) return 0;
		if (tab[n] > 0) return tab[n];
		return tab[n] = fibTab(n-1) + fibTab(n-2);
	}
	public static void main(String[] args) {
		for(int i = 5; i <= 50; i += 5) {
			long avant = System.nanoTime();
			fibonacci(i);
			long apres = System.nanoTime();
			System.out.println(Time.nanoSecondsToTime(apres - avant));
		}
	}
}
