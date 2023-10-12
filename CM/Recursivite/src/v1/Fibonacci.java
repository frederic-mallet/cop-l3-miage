package v1;

import common.Time;

public class Fibonacci {
	static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
	
	public static void main(String[] args) {
		for(int i = 5; i <= 50; i += 5) {
			long avant = System.nanoTime();
			fib(i);
			long apres = System.nanoTime();
			System.out.println(Time.nanoSecondsToTime(apres - avant));
		}
	}
}
