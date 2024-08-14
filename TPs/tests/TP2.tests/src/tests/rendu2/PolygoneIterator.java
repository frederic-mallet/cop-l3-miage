package tests.rendu2;

import java.util.Iterator;

import tp2.vecteur.Vecteur;

class PolygoneIterator implements Iterator<Vecteur> {
	private Polygone polygon;
	private int current = 0;
	PolygoneIterator(Polygone polygon) {
		this.polygon = polygon;
	}

	@Override
	public boolean hasNext() {
		return current < polygon.numberOfPoints();
	}

	@Override
	public Vecteur next() {
		return polygon.get(current++);
	}

}
