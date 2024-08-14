package tests.rendu2;

import tp2.vecteur.Vecteur;
import tp2.Polygone;

class ExtractTrianglesPolygoneRegulier {
	static Polygone[] extract(int nbCote, double rayonX, double rayonY) {
		Polygone[] res = new Polygone[nbCote];
		double delta = Math.PI * 2 / nbCote;
		double angle = - delta / 2; 
		
		Vecteur centre = new Vecteur(0.0, 0.0);
		Vecteur previous = new Vecteur(rayonX * Math.cos(angle), rayonY * Math.sin(angle));
		for (int i = 0; i < res.length; i++) {
			angle += delta;
			Vecteur current = new Vecteur(
					rayonX * Math.cos(angle),
					rayonY * Math.sin(angle)
					);
			res[i] = new Polygone(centre, previous, current);
			previous = current;
		}
		return res;
	}
}
