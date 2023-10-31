package v3;

import common.Time;

/**
 * On calcule en montant => linéaire
 * On a besoin des 2 dernières valeurs seulement
 */
public class Fibonacci {
	static int fibonacci(int n) {
		return fibonacci(0, 1, n);
	}
	
	private static int fibonacci(int a, int b, int n) {
		if (n == 0) return a;
		return fibonacci(b, a + b, n - 1);
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
