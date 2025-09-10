package uca.l3poo.lec2.cartes.v3;

class TestCartes {

	public static void main(String[] args) {
		Couleur c = Couleur.TREFLE;
		Valeur v = Valeur.AS;
		
		System.out.println(v + " " + c);
		
		System.out.println("Le " + Valeur.AS + " vaut " + Valeur.AS.maValeur());
		System.out.println("Le " + Valeur.ROI + " vaut " + Valeur.ROI.maValeur());
		System.out.print("L'AS vaut-il plus que le ROI ? \t");
		System.out.println(Valeur.AS.estSuperieureA(Valeur.ROI));
		
//		Valeur.AS = new Valeur(1); // interdit par le final
		
		// final n'empêche pas la modification !! 
		Valeur.AS.ordre = 1; 
		System.out.println("Le " + Valeur.AS + " vaut " + Valeur.AS.maValeur());
		System.out.println("Le " + Valeur.ROI + " vaut " + Valeur.ROI.maValeur());
		System.out.print("L'AS vaut-il plus que le ROI ? \t");
		System.out.println(Valeur.AS.estSuperieureA(Valeur.ROI));
		
	}
	
}
