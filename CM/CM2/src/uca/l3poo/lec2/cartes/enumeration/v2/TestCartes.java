package uca.l3poo.lec2.cartes.enumeration.v2;

/**
 * CM2 : compare class and enum
 * compare to v1
 * 
 * @author fmallet
 */
class TestCartes {

	public static void main(String[] args) {
		Couleur c = Couleur.TREFLE;
		Valeur v = Valeur.AS;
		
		System.out.println(v + " " + c);
		
		System.out.println(c + " est une couleur noire ? " + c.estNoire());
		System.out.println(c + " est une couleur rouge ? " + c.estRouge());
		
	}
	
}
