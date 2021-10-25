package tp2.tests;

import tp2.vecteur.Vecteur;

/**
 * This is a facade to adapt to the choices of students
 * 
 * @author fmallet
 *
 */
public class Polygone {
	private tp2.Polygone inner;
	Polygone(tp2.Polygone inner){ 
		this.inner = inner;
	}
	public Polygone(Vecteur... points) {
		inner = new tp2.Polygone(points);
	}
	public Vecteur get(int i) {
		return inner.getPoint(i);
	}
	public int numberOfPoints() {
		return inner.numberOfPoints();
	}
	public Polygone[] triangulation() {
		tp2.Polygone[] t = ExtractTriangles.extract(inner);
		Polygone[] res = new Polygone[t.length];
		for (int i=0; i < res.length; i++) {
			res[i] = new Polygone(t[i].getPoint(0), t[i].getPoint(1), t[i].getPoint(2));
		}
		return res;
	}
	public double perimetre() {
		return inner.perimetre();
	}
	public Vecteur barycentre() {
		return inner.barycentre();
	}
}
