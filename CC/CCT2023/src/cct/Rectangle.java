package cct;

public class Rectangle {
	boolean equals(Rectangle r) { 
		System.out.println("Rectangle.equals(Rectangle)");		
		return false; 
	}
	public boolean equals(Object o) { 
		System.out.println("Rectangle.equals(Object)");
		return false; 
	}
}
