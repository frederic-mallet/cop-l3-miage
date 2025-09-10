package uca.l3poo.lec2.complexe;

/**
 * CM2 - Les constructeurs et utilisation de this.
 * 
 * @author fmallet
 */
class Complexe {
	double reelle, imaginaire;
	
	Complexe(double reelle, double imaginaire) {
		this.reelle = reelle;
		this.imaginaire = imaginaire;
	}
	
	double norme() {
		return reelle * reelle + imaginaire * imaginaire;
	}
	
	public static void main(String[] args) {
		Complexe c1 = new Complexe(0, 1);
		System.out.println("Norme : " + c1.norme());
	}
}
