package uca.l3poo.lec2.cartes.v3;

class Couleur {
	String couleur;
	
	Couleur(String couleur) {
		this.couleur = couleur;
	}
	
	static final Couleur 
			TREFLE  = new Couleur("Trèfle"),
			PIQUE   = new Couleur("Pique"),
			COEUR   = new Couleur("Coeur"),
			CARREAU = new Couleur("Carreau");
	
	public String toString() {
		return this.couleur;
	}
}
