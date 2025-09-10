package data.operation;

public class MaxMap<TYPE extends Comparable<TYPE>> implements IMap<TYPE, TYPE> {
	private TYPE max = null;
	
	@Override
	public TYPE map(TYPE src) {
			if (max == null || src.compareTo(max) > 0) {
				this.max = src;
			}
			return this.max;
	}
	
	public TYPE getMax() {
		return max;
	}
}
