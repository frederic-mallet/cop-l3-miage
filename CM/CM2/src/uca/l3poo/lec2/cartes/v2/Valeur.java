package uca.l3poo.lec2.cartes.v2;

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

	@Override
	public String toString() {
		switch (valeur) {
		case 7: case 8: case 9: case 10:
			return valeur + ""; // convert int to String
		case 11: 
			return "Valet";
		case 12:
			return "Dame";
		case 13:
			return "Roi";
		case 14:
			return "As";
		default: 
			return "Erreur!"; // pas très bonne solution.
		}
	}
}
