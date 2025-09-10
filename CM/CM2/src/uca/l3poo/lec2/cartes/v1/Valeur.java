package uca.l3poo.lec2.cartes.v1;

/**
 * CM2 : compare class and enum
 * 
 * @author fmallet
 */
class Valeur {
	int valeur;

	Valeur(int valeur) {
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

	String nom() {
		if (valeur >= 7 && valeur <= 10)
			return valeur + ""; // convert int to String
		if (valeur == 11)
			return "Valet";
		if (valeur == 12)
			return "Dame";
		if (valeur == 13)
			return "Roi";
		if (valeur == 14)
			return "As";
		return "Erreur!"; // pas très bonne solution.
	}
}
