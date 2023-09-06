package cct.list;

import java.util.Iterator;

public class TestListe {
	public static void main(String[] args) {
//		Liste l = new Liste();
		Liste l = new Liste(3, 7, 2, 4);
		
		System.out.println("liste = " + l);	
		System.out.println("\tTaille : " + l.size());
		
		System.out.println("Adding 8");
		l.add(8);
		System.out.println("liste = " + l);	
		System.out.println("\tTaille : " + l.size());
		
		System.out.println("Removing first");
		l.removeFirst();
		System.out.println("liste = " + l);	
		System.out.println("\tTaille : " + l.size());	
		
		System.out.println("Contains 4 ? " + l.contains(4));
		System.out.println("Contains -2 ? " + l.contains(-2));
		
		Liste rev = l.reverse();
		System.out.println("rev = " + rev);
		System.out.println("liste =" + l);
		
		l.concat(rev);
		System.out.println(l);	
		System.out.println("\tTaille : " + l.size());
		
		System.out.println("Removing first on reverse");
		rev.removeFirst();
		System.out.println("rev = " + rev);
		System.out.println("liste = " + l);
		
		Iterator<Integer> it = l.iterator();
		System.out.println("Removing with iterator");		
		it.remove();
		System.out.println("liste = " + l);		
		it.next();
		it.next();
		it.remove();
		System.out.println("liste = " + l);		
	}
}
