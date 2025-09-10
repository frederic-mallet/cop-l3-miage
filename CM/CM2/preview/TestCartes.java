/**
 * CM2 : Compare enum and classes
 * 
 * Uses Preview Language Feature JP488 from JDK 24
 * https://openjdk.org/jeps/488
 * 
 * java --enable-preview TestCartes.java
 * 
 * @author fmallet
 */

void main() {
	Couleur c = Couleur.TREFLE;
	Valeur v = Valeur.AS;

	println(v + " " + c);
	
	println("L'" + Valeur.AS + " vaut " + Valeur.AS.maValeur());
	println("Le " + Valeur.ROI + " vaut " + Valeur.ROI.maValeur());
	print("L'AS vaut-il plus que le ROI ? \t");
	println(Valeur.AS.estSuperieureA(Valeur.ROI));
	
}
