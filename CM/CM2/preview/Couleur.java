/**
 * CM2 : Compare enum and classes
 * 
 * @author fmallet
 */

class Couleur {
	private int couleur;
	
	private Couleur(int couleur) {
		this.couleur = couleur;
	}
	
	static public final Couleur 
			TREFLE  = new Couleur(1),
			PIQUE   = new Couleur(2),
			COEUR   = new Couleur(3),
			CARREAU = new Couleur(4);
	
	@Override	
	public String toString() {
		switch(couleur) {
		case 1 : return "Trèfle";
		case 2 : return "Pique";
		case 3 : return "Coeur";
		case 4 : return "Carreau";
		default: return "Erreur!";
		}
	}
}
