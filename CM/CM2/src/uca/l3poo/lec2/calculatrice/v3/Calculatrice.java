package uca.l3poo.lec2.calculatrice.v3;
/**
 * CM2 : explique la différence entre fonction et méthodes, 
 * méthodes d'instances et de classe
 * 
 * v3 : méthodes d'instances et attribut de classe
 * 
 * @author fmallet
 */
class Calculatrice {
	// accumule les calculs successifs
	// il est distinct dans toutes les instances
	double accumulateur;
	
	void add(double v) {
		accumulateur += v;
	}
	void mul(double v) {
		accumulateur *= v;
	}
	void inv() {
		accumulateur = 1/accumulateur;
	}
	static final double PI = 3.1415;
	
	public static void main(String[] args) {
		Calculatrice c1 = new Calculatrice();
		Calculatrice c2 = new Calculatrice();
		
		c1.add(12);
		c1.add(Calculatrice.PI);
		
		System.out.println("c1 : " + c1.accumulateur);
		System.out.println("c2 : " + c2.accumulateur);
	}	 
}
