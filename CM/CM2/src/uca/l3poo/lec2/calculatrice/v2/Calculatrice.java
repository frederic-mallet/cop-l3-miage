package uca.l3poo.lec2.calculatrice.v2;

/**
 * CM2 : explique la différence entre fonction et méthodes, 
 * méthodes d'instances et de classe
 * 
 * v2 : méthodes de classes mais on ne peut pas distinguer 2 calculatrices
 * -> mauvaise pratique
 * 
 * @author fmallet
 */
class Calculatrice {
	static double add(double v1, double v2) {
		return v1+v2;
	}
	static double mul(double v1, double v2) {
		return v1*v2;
	}
	static double inv(double v) {
		return 1/v;
	}
	static final double PI = 3.1415; // PI est identique sur toutes les instances de Calculatrice
	
	public static void main(String[] args) {
		System.out.println(Calculatrice.add(12, 5));
		System.out.println(Calculatrice.add(Calculatrice.PI, 5));
	}	  
}