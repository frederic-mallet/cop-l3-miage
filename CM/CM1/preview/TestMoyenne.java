/**
 * L3 Miage TP1
 * 
 * Preview Language Feature : Moyenne, JDK 24
 * 
 * @author fmallet
 * @see Moyenne
 */

 class Moyenne {
	int sommeTotaleDesNotes = 0 ;
	int nombreDeNotes = 0 ;

	void ajouteNote (int note) {
		sommeTotaleDesNotes += note;
		nombreDeNotes += 1;
	}

	double calculeMoyenne() {
		return ((double)sommeTotaleDesNotes) / nombreDeNotes ;
	}
}

Moyenne m = new Moyenne();
void main() {
	{ // test sans notes
		var moyenne = m.calculeMoyenne();
		println("Moyenne:"+moyenne);
	}

	m.ajouteNote(18);
	m.ajouteNote(12);
	m.ajouteNote(4);

	{ // test avec notes
		var moyenne = m.calculeMoyenne();
		println("Moyenne:"+moyenne);
	}
}
