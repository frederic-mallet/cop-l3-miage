package data.operation;

public class MeansMap implements IMap<Number, Double> {
	private int number = 0;
	private double sum = 0.0;
	
	@Override
	public Double map(Number src) {
		sum += src.doubleValue();
		number += 1;
		
		return sum/number;
	}

	public double getMeans() { return sum / number; }
}
