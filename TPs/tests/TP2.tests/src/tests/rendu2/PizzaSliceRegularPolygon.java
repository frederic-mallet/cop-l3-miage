package tests.rendu2;

import java.awt.Color;
import java.awt.Graphics;

import frame.AWTHelper;
import frame.FrameHelper;
import tp2.vecteur.Vecteur;

public class PizzaSliceRegularPolygon {
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
	// when t in [0,half[ use slope1, when t in [half, period[ use slope2
	private static int function(int t, int half, int period, int slope1, int slope2) {
		t = t % period;
		if (t < half) return t * slope1;
		return half * slope1 + (t - half) * slope2;
	}
	public static void main(String[] args) {
		int nbTriangles = 20;
		int period = nbTriangles * 2 - 1;
		// build a polygon with nbTriangles points and inside the rectangle of width 150 and height 100
		tp2.Polygone[] t = ExtractTrianglesPolygoneRegulier.extract(nbTriangles, 150, 100);
		Color[] c = AWTHelper.genColor(nbTriangles, nbTriangles, 1); // mainly blue

		new FrameHelper(350, 250, true).animate((g,step) -> {
//			drawPolygone(g, poly, Color.black);
			final int min = function(step, nbTriangles - 1, period, 0, 1);
			final int max = 1 + function(step, nbTriangles - 1, period, 1, 0);
			for (int i = min; i < max ; i++) {
				int nbColor = function(i, nbTriangles - 1, period, 1, -1);
				fillPolygone(g, new Polygone(t[i]), 
						c[nbColor]);
			}
			return false;
		}, 500);
	}
}
