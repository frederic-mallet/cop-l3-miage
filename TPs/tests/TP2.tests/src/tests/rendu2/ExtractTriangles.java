package tests.rendu2;

import tp2.Polygone;

/**
 * Façade pour s'adapter à l'API des étudiants
 * 
 * @author fmallet
 *
 */
public class ExtractTriangles {

	public static Polygone[] extract(Polygone inner) {
		return tp2.ExtractTriangles.extract(inner);
	}

}
