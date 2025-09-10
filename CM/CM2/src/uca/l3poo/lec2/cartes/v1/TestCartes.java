package uca.l3poo.lec2.cartes.v1;

/**
 * CM2 : compare classes and enum
 * 
 * by default : display is <class-name>@<address>
 * 
 * @author fmallet
 */
class TestCartes {

	public static void main(String[] args) {
		Couleur c = Couleur.TREFLE;
		Valeur v = Valeur.AS;
		
		System.out.println(v + " " + c);
		System.out.println(v.nom() + " " + c.nom());
	}
	
}
