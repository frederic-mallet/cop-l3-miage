package tp1.tests;

import java.awt.Color;
import java.awt.Graphics;

import frame.FrameHelper;
import tp1.vecteur.Vecteur;

class DessineVecteur {
	public static DessineVecteur SINGLETON = new DessineVecteur(Color.blue);
	private Color color;
	
	public DessineVecteur(Color color) {
		super();
		this.color = color;
	}
	
	public void line(Graphics g, Vecteur v1, Vecteur v2) {
		g.setColor(color);
		g.drawLine((int)v1.getX(), (int)v1.getY(), (int)v2.getX(), (int)v2.getY());		
	}
	public void dessine(Graphics g, Vecteur v, boolean showPosition) {
		g.setColor(color);
//		line(g, new Vecteur(0,0), v);		
		g.fillOval((int)v.getX() - 2, (int)v.getY() - 2, 4, 4);

		if (showPosition)
			FrameHelper.printCenterX(g, v.toString(), (int)v.getX(), (int)v.getY());
	}

	public static void main(String[] args) {
		new FrameHelper(200, 200, true).draw(g -> {
			Vecteur v = new Vecteur(30, 40);

			SINGLETON.dessine(g, v, true);			
			FrameHelper.print(g, "Length : " + v.length(), -100, 90);
		});
	}
}
