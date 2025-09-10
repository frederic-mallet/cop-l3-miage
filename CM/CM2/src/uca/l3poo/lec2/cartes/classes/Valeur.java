package uca.l3poo.lec2.cartes.classes;

class Valeur {
	// private to avoid modification from outside the class
	private String nom;
	// private to avoid modification from outside the class
	private int ordre;

	// private to avoid creation of new instances from outside the class
	private Valeur(int ordre) {
		this(ordre, ordre + "");
	}

	// private to avoid creation of new instances from outside the class
	private Valeur(int ordre, String nom) {
		this.nom = nom;
		this.ordre = ordre;
	}

	public static final Valeur 
		SEPT = new Valeur(7),
		HUIT = new Valeur(8),
		NEUF = new Valeur(9),
		DIX  = new Valeur(10),
		VALET = new Valeur(11, "Valet"),
		DAME = new Valeur(12, "Dame"),
		ROI = new Valeur(13, "Roi"),
		AS  = new Valeur(14, "As");

	@Override
	public String toString() {
		return this.nom;
	}
	
	// exemple du break;
	int maValeur() {
		int v = 0;
		switch (ordre) {
		case 10 : v = ordre; break;
		case 11: case 12: case 13:
			v = ordre - 9; break;
		case 14:
			v = ordre - 3; break;
		}
		return v;
	}
	boolean estSuperieureA(Valeur autre) {
		return this.ordre > autre.ordre;
	}
}
