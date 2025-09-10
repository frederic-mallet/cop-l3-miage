package data.operation;

public class Addition implements IOperation<Double> {
	@Override
	public Double compute(Object... objects) {
		double res = 0.0;
		for (Object o : objects) {
			if (o instanceof Number)
				res += ((Number)o).doubleValue();
			else 
				return Double.NaN;
		}
		return res;
	}
}
