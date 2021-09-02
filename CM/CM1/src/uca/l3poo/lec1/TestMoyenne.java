package uca.l3poo.lec1;

/**
 * L3 Miage TP1
 * 
 * Test la classe Moyenne
 * 
 * Devrait être dans un autre package, mais visibilité package
 * de la classe ne le permet pas sauf à déplacer dans un autre projet
 * 
 * @author fmallet
 * @see Moyenne
 */
class TestMoyenne {
	public static void main(String[] args) {
		Moyenne m = new Moyenne();
		{ // test sans notes
			double moyenne = m.calculeMoyenne();
			System.out.println("Moyenne:"+moyenne);
		}

		m.ajouteNote(18);
		m.ajouteNote(12);
		m.ajouteNote(4);

		{ // test avec notes
			double moyenne = m.calculeMoyenne();
			System.out.println("Moyenne:"+moyenne);
		}
	}
}
