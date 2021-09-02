package tp2.tests;

import java.awt.Color;
import java.awt.Graphics;

import frame.FrameHelper;
import tp2.vecteur.Vecteur;

public class DessinePolygone {
	private static int[] xPoints, yPoints;
	private static void buildPolygone(Polygone p) {
		xPoints = new int[p.numberOfPoints()];
		yPoints = new int[p.numberOfPoints()];
		int i = 0;
		for (Vecteur v : new PolygoneIterable(p)) {
			xPoints[i] = (int)v.get(0);
			yPoints[i] = (int)v.get(1);
			i++;
		}
	}
	public static void drawPolygone(Graphics g, Polygone p, Color c) {
		buildPolygone(p);
		g.setColor(c);
		g.drawPolygon(xPoints, yPoints, xPoints.length);
	}
	public static void fillPolygone(Graphics g, Polygone p, Color c) {
		buildPolygone(p);
		g.setColor(c);
		g.fillPolygon(xPoints, yPoints, xPoints.length);
	}
	public static void main(String[] args) {
		Polygone poly = RegularPolygonBuilder.mkRegularPolygon(10, 50);
		Color[] c = {Color.blue, Color.red, Color.green, Color.pink};
		Polygone[] t=poly.triangulation();

		new FrameHelper(350, 250, true).draw(g -> {
			drawPolygone(g, poly, Color.black);
			for (int i = 0; i < t.length; i++)
				fillPolygone(g, t[i], c[i%c.length]);
		});
	}
}
