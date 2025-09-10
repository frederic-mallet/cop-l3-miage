package uca.l3poo.lec2.cartes.v1;

/**
 * CM2 : compare class and enum
 * 
 * @author fmallet
 */
class Couleur {
	int couleur;
	
	Couleur(int couleur) {
		this.couleur = couleur;
	}
	
	static final Couleur 
			TREFLE  = new Couleur(1),
			PIQUE   = new Couleur(2),
			COEUR   = new Couleur(3),
			CARREAU = new Couleur(4);
	
	// example of if (no else)
	String nom() {
		if (couleur == 1) return "Trèfle";
		if (couleur == 2) return "Pique";
		if (couleur == 3) return "Coeur";
		if (couleur == 4) return "Carreau";
		return "Erreur!";
	}
}
