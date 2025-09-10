package uca.l3poo.lec2.complexe.surcharge;

/**
 * CM2 - Les constructeurs et utilisation de this.
 * Exemple de surcharge du constructeur
 * 
 * @author fmallet
 */
class Complexe {
	double reelle, imaginaire;
	
	// Constructeur Complexe(double, double)
	Complexe(double reelle, double imaginaire) {
		this.reelle = reelle;
		this.imaginaire = imaginaire;
	}
	
	// Constructeur Complexe(double)
	Complexe(double reelle) {
		this(reelle, 0.0); // appel du constructeur Complexe(double, double)
	}
	
	double norme() {
		return reelle * reelle + imaginaire * imaginaire;
	}
	
	public static void main(String[] args) {
		Complexe c1 = new Complexe(0, 1); // appel du constructeur Complexe(double, double)
		System.out.println("Norme c1 : " + c1.norme());
		
		Complexe c2 = new Complexe(6); // appel du constructeur Complexe(double)
		System.out.println("Norme c2 : " + c2.norme());
		
		// Interdit : pas de constructeur par défaut quand il y a des constructeurs explicites
//		Complexe c3 = new Complexe(); 
		
	}
}
