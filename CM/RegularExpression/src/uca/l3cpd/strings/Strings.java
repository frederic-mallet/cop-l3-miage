package uca.l3cpd.strings;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Strings {
	private static void print(String sut, String del1, String del2) {
		String [] res = sut.split(del1);
		System.out.println("---- SPLIT ----");
		System.out.println(Arrays.toString(res));

		// ---- StringTokenizer
		System.out.println("---- StringTokenizer ----");
		StringTokenizer st = new StringTokenizer(sut, del2); 
		String sep = "[";
		for (Iterator<?> it = st.asIterator(); it.hasNext();) {
			System.out.print(sep);
			System.out.print(it.next());
			sep = ", ";
		}
		System.out.println("]");		
	}
	
	public static void main(String[] args) {
		print("boo:and:foo", ":", ":");
		print("boo:and:foo", "o", "o");
		print("ceci est un	test", "\\s", " \t\n\r\f");
	}
}
