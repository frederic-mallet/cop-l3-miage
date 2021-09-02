package tp1.tests;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import frame.FrameHelper;
import tp1.Triangle;
import tp1.vecteur.Vecteur;

public class DessineTriangle {
	public static void fillTriangle(Graphics g, Triangle t, Color c) {
		int[] xPoints = {(int)t.v1.getX(), (int)t.v2.getX(), (int)t.v3.getX()}; 
		int[] yPoints = {(int)t.v1.getY(), (int)t.v2.getY(), (int)t.v3.getY()}; 
		g.setColor(c);
		g.fillPolygon(xPoints, yPoints, 3);
	}
	
	public static void drawTriangle(Graphics g, Triangle t, Color c) {
		DessineVecteur dv = new DessineVecteur(c);
		dv.line(g, t.v1, t.v2);
		dv.line(g, t.v2, t.v3);
		dv.line(g, t.v3, t.v1);		
	}
	public static void drawBissectrice(Graphics g, Triangle t, Color c) {
		DessineVecteur dvG = new DessineVecteur(c);
		dvG.line(g, t.v1, Vecteur.add(t.v2, t.v3).multK(.5));
		dvG.line(g, t.v2, Vecteur.add(t.v1, t.v3).multK(.5));
		dvG.line(g, t.v3, Vecteur.add(t.v1, t.v2).multK(.5));
	}
	
	public static void main(String[] args) {
		Random gen = new Random();
		int max = 50, min = -50;
		Vecteur v1 = new Vecteur(100+gen.nextInt(max-min)+min, gen.nextInt(max-min)+min);
		Vecteur v2 = new Vecteur(-100+gen.nextInt(max-min)+min, 100 + gen.nextInt(max-min)+min);
		Vecteur v3 = new Vecteur(-100+gen.nextInt(max-min)+min, -100 + gen.nextInt(max-min)+min);
		Triangle t = new Triangle(v1, v2, v3);	
		
		Vecteur barycentre = t.barycentre();
		double d1 = Vecteur.sub(t.v1, barycentre).length();
		double d2 = Vecteur.sub(t.v2, barycentre).length();
		double d3 = Vecteur.sub(t.v3, barycentre).length();
		System.out.println(t.v1 + ":" + t.v2 + ":" + t.v3 + ":" + barycentre + ":" + d1 + ":" + d2 + ":" + d3);
		new FrameHelper(300, 300, true).draw(g -> {
			drawTriangle(g, t, Color.black);
			DessineVecteur.SINGLETON.dessine(g, barycentre, false);
			drawBissectrice(g, t, Color.green);
		});

	}
}
