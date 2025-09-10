package data.operation;

public class Number2Double<SRC extends Number> implements IMap<SRC, Double> {
	@Override
	public Double map(SRC src) {
		return src.doubleValue();
	}

}
