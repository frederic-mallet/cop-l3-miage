package cct.list;

class Cellule {
	int element;
	Cellule next;
	Cellule(int element, Cellule next) {
		super();
		this.element = element;
		this.next = next;
	}
	Cellule(int element) {
		this(element, null);
	}	
}
