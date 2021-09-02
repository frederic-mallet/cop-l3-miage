package tp2.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({RechercheDichotomiqueIterativeTest.class, RechercheSequentielleTest.class,
	RechercheTableauxTest.class, Vecteur2DTest.class, VecteurTest.class, PolygoneTest.class,
	TortueTest.class})
public class AllTests {

}
