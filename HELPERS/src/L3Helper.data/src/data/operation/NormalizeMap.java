package data.operation;

public class NormalizeMap implements IMap<Number, Double> {
	private double means, std;
	
	public NormalizeMap(double means, double std) {
		this.means = means;
		this.std = std;
	}

	@Override
	public Double map(Number src) {
		return (src.doubleValue() - means)/std;
	}
}
