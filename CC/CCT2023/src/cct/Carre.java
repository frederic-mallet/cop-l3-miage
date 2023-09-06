package cct;

public class Carre extends Rectangle {
	boolean equals(Carre c) { 
		System.out.println("Carre.equals(Carre)");
		return false; 
	}
	boolean equals(Rectangle r) { 
		System.out.println("Carre.equals(Rectangle)");		
		return false; 
	}
	public boolean equals(Object o) { 
		System.out.println("Carre.equals(Object)");
		return false; 
	}
}
