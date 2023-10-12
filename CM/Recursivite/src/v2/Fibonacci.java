package v2;

import java.util.Arrays;

import common.Time;

public class Fibonacci {
	static int[] tab;
	static int fibTab(int n) {
		tab = new int[n + 1];
		Arrays.fill(tab, -1);
		tab[0] = 0;
		tab[1] = 1;
		return fibTab2(n);
	}
	private static int fibTab2(int n) {
		if (tab[n] >= 0) return tab[n];
		return tab[n] = fibTab2(n-1) + fibTab2(n-2);
	}
	public static void main(String[] args) {
		for(int i = 5; i <= 50; i += 5) {
			long avant = System.nanoTime();
			fibTab(i);
			long apres = System.nanoTime();
			System.out.println(Time.nanoSecondsToTime(apres - avant));
		}
	}
}
