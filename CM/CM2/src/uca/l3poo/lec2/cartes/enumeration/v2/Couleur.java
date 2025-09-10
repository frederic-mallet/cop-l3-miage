package uca.l3poo.lec2.cartes.enumeration.v2;

/**
 * CM2 : compare class and enum
 * compare to v1
 * 
 * @author fmallet
 */
enum Couleur {
	TREFLE(true), CARREAU(false), COEUR (false), PIQUE (true);
	
	Couleur(boolean estNoire) {
		this.estNoire = estNoire;
	}

	private boolean estNoire;
	
	boolean estNoire() {
		return this.estNoire;
	}
	boolean estRouge() {
		return ! this.estNoire;
	}
}
