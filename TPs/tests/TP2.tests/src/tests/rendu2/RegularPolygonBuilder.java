package tests.rendu2;

import tp1.turtle.Tortue;
import tp2.vecteur.Vecteur;

public class RegularPolygonBuilder {
	/**
	 * Regular polygon with a given number of points and a side length
	 * @param nbOfPoints in the polygon
	 * @param length of each side
	 */
	public static Polygone mkRegularPolygon(int nbOfPoints, int length) {
		assert(nbOfPoints >= 3);
		Vecteur[] points = new Vecteur[nbOfPoints];
		Tortue lea = new Tortue();
		double angle = 360.0 / nbOfPoints;
		for (int i = 0; i < nbOfPoints; i++) {
			points[i] = new Vecteur(lea.getX(), lea.getY());
			lea.avance(length);
			lea.droite(angle);
		}
		assert(0 == (int)lea.getX() && 0 == (int)lea.getY());
		return new Polygone(points);
	}
}
