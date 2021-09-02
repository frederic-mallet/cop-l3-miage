package tp1.tests;

import java.awt.Color;
import java.awt.Graphics;

import frame.FrameHelper;
import tp1.Bezier;
import tp1.vecteur.Vecteur;

public class DessineBezier {
	// dessine la courbe de bezier 
	public static void dessine(Graphics g, Bezier cB, boolean showPosition) {
		DessineVecteur dV = new DessineVecteur(Color.black);
		
		if (showPosition) {
		//Affiche les 4 points que va suivre la courbe de bezier
			dV.dessine(g, cB.getBegin(), true);
			dV.dessine(g, cB.getControl1(), true);
			dV.dessine(g, cB.getControl2(), true);
			dV.dessine(g, cB.getEnd(), true);
		}
		
		// Génération des points de la courbe de bezier
		for(double t = 0; t <= 1; t += 0.02) {
			dV.dessine(g, cB.eval(t), false);
		}	    
	}

	public static void trace(Bezier courbe) {
		new frame.FrameHelper(300, 300, true).draw(g -> { //Création de la fenêtre => taille non dynamique
			dessine(g, courbe, true);
			FrameHelper.print(g, "Courbe de Bezier " , -50,120);  
			DessineVecteur.SINGLETON.line(g, courbe.getBegin(), courbe.getControl1());
			DessineVecteur.SINGLETON.line(g, courbe.getEnd(), courbe.getControl2());
		});
	}
	public static void main(String[] args) {
		Bezier bezier = new Bezier(new Vecteur(-70,-50),
				new Vecteur(-100,80), new Vecteur(100,100), new Vecteur(80,-50));
		trace(bezier);
	}
}