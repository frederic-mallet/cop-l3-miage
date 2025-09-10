/**
 * CM2 : Compare enum and classes
 * 
 * Uses Preview Language Feature JP488 from JDK 24
 * https://openjdk.org/jeps/488
 * 
 * java --enable-preview TestCartes.java
 * 
 * @author fmallet
 */
class Valeur {
	
	private int valeur;

	private Valeur(int valeur) {
		this.valeur = valeur;
	}

	public static final Valeur 
		SEPT = new Valeur(7),
		HUIT = new Valeur(8),
		NEUF = new Valeur(9),
		DIX  = new Valeur(10),
		VALET = new Valeur(11),
		DAME = new Valeur(12),
		ROI = new Valeur(13),
		AS  = new Valeur(14);

	@Override
	public String toString() {
		switch (valeur) {
		case 11: 
			return "Valet";
		case 12:
			return "Dame";
		case 13:
			return "Roi";
		case 14:
			return "As";
		case int i when i >= 7 && i <= 10:
			return valeur + ""; // convert int to String
		default: 
			return "Erreur!"; // pas très bonne solution.
		}
	}
	
	boolean estSuperieureA(Valeur autre) {
		return this.valeur > autre.valeur;
	}
	
	// when -> no break
	int maValeur() {
		int v = 0;
		switch (valeur) {
		case 10 -> v = valeur;
		case 14 -> v = valeur - 3;
		case int i when i>10 && i<14 -> v = valeur - 9;
		case int i -> v = -2; //ERROR: anywhere else
		}
		return v;
	}	
}
