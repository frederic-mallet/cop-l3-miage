package uca.l3poo.lec2.complexe.pardefaut;

/**
 * CM2 - Les constructeurs et utilisation de this.
 * Exemple de constructeur par défaut
 * 
 * @author fmallet
 */
class Complexe {
	double reelle, imaginaire;
	
	double norme() {
		return reelle * reelle + imaginaire * imaginaire;
	}
	
	public static void main(String[] args) {
		Complexe c = new Complexe(); // appel du constructeur par défaut Complexe()
		System.out.println("Norme c1 : " + c.norme());		
	}
}
