package tp1.tests;

import static org.junit.Assert.assertEquals;

import java.util.Random;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;

import org.junit.Test;

import test.TestSignature;
import tp1.FeatureScaling;

public class FeatureScalingTest {
	@Test
	public void testAttributs() {	
		TestSignature test = new TestSignature(FeatureScaling.class);
		test.privateField("min");
		test.privateField("max");
		test.privateField("nombre");
		test.privateField("somme");
	}
	@Test
	public void testInit() {
		FeatureScaling fix = new FeatureScaling();
		assertEquals(Double.NaN, fix.moyenne(), 1e-3);
	}

	Random generateur = new Random();
	@Test
	public void testMoyenne() {
		int nb = generateur.nextInt(1000, 2000);
		FeatureScaling fix = new FeatureScaling();
		for (int i = 1; i <= nb; i++) {
			fix.lire(i);
		}
		assertEquals((nb+1)/2, fix.moyenne(), 1);
	}

	private int i = 0;
	@Test
	public void testNormalization() {
		FeatureScaling fix1 = new FeatureScaling();
		
		int nb = generateur.nextInt(1000, 2000);
		DoubleStream stream = generateur.doubles(nb, -1000, +1000);

		double tab[] = new double[nb];
		
		i = 0;

		stream.forEach(new DoubleConsumer() {
			
			@Override
			public void accept(double value) {
				fix1.lire(value);
				tab[i++] = value;
			}
		});
		
		// la moyenne
//		double mu = fix1.moyenne();
//		System.out.println(nb + ", " + mu + ", " + fix1.getMin() + " , " + fix1.getMax());
		
		FeatureScaling fix2 = new FeatureScaling();

//		double stdValeurs = 0;
//		double stdNormValeurs = 0;
		// on repasse les mêmes valeurs pour les normaliser et calculer la moyenne des valeurs normalisées.
		for (double valeur : tab) {
			double norm_valeur = fix1.normalize(valeur);
			fix2.lire(norm_valeur);
			
//			stdValeurs += (valeur - mu)*(valeur-mu);
//			stdNormValeurs = norm_valeur * norm_valeur; // la moyenne doit être 0
		}

		// Par définition de la normalisation, la moyenne des données normalisées doit être 0.0
		assertEquals(0.0, fix2.moyenne(), 1e-3);
		// par définition max-min des données normalisées doit être égal à 1
		assertEquals(1.0, (fix2.getMax() - fix2.getMin()), 1e-3);
//		System.out.println(stdValeurs + ", " + stdNormValeurs + ", " + fix2.getMin() + " , " + fix2.getMax());
	}
}
