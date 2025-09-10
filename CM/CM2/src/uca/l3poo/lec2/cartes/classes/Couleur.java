package uca.l3poo.lec2.cartes.classes;

/**
 * CM2 : compare to enumeration and others (v1, v2, v3)
 * 
 * @author fmallet
 */
class Couleur {
	// private to avoid modification from outside the class
	private String couleur;
	
	// private to avoid creation of new instances from outside the class
	private Couleur(String couleur) {
		this.couleur = couleur;
	}
	
	static final Couleur 
			TREFLE  = new Couleur("Trèfle"),
			PIQUE   = new Couleur("Pique"),
			COEUR   = new Couleur("Coeur"),
			CARREAU = new Couleur("Carreau");
	
	// has to be public to override
	@Override
	public String toString() {
		return this.couleur;
	}
}
