package uca.l3poo.lec1;

/**
 * L3 Miage TP1
 * 
 * Une approche objet pour calculer la moyenne. Premier example.
 * 
 * @author fmallet
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
