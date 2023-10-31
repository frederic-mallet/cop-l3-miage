package v4;

import common.Time;

/**
 * Version purement itérative (linéaire)
 */
public class Fibonacci {
	static int fibonacci(int n) {
		int a = 0;
		int b = 1;
		for (int i = n; i > 0; i--) {
			int tmp = a + b;
			a = b;
			b = tmp;
		}
		return a;
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
