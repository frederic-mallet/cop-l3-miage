package tp2.tests;

import java.util.Iterator;

import tp2.vecteur.Vecteur;

class PolygoneIterable implements Iterable<Vecteur> {
	private Polygone polygon;
	PolygoneIterable(Polygone p) {
		this.polygon = p;
	}

	@Override
	public Iterator<Vecteur> iterator() {
		return new PolygoneIterator(polygon);
	}
}