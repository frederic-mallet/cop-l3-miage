package uca.l3poo.lec2.calculatrice.v1;

/**
 * CM2 : explique la différence entre fonction et méthodes, 
 * méthodes d'instances et de classe
 *  
 *  v1 : méthodes d'instances, mais instance inutile 
 *  -> mauvaise pratique
 *  
 *  @author fmallet
 */
class Calculatrice {
	double add(double v1, double v2) {
		return v1+v2;
	}
	double mul(double v1, double v2) {
		return v1*v2;
	}
	double inv(double v) {
		return 1/v;
	}
	public static void main(String[] args) {
		Calculatrice c = new Calculatrice();
		System.out.println(c.add(12, 5));
	}	  
}
