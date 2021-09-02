package frame;

import java.awt.Color;

public class AWTHelper {
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	/**
	 * Generates some colors that spread with nbRed variations on the red component,
	 * nbGreen variations on the green component nbBlue variations on the blue component
	 */
	public static Color[] genColor(int nbRed, int nbGreen, int nbBlue) {
		int nb = lcm(nbRed, lcm(nbGreen, nbBlue));
		int red = nb / nbRed;
		int green = nb / nbGreen;
		int blue = nb / nbBlue;
		
		Color[] res = new Color[nb];
		for (int i = 0; i < res.length; i++) {
			res[i] = new Color(
					(255 * (i / red   + 1) / (nbRed + 1)),
					(255 * (i / green + 1) / (nbGreen + 1)),
					(255 * (i / blue  + 1) / (nbBlue + 1)));
		}
		return res;
	}

}
