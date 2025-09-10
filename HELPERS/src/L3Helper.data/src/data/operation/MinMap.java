package data.operation;

public class MinMap<SRC extends Comparable<SRC>> implements IMap<SRC, SRC> {
	private SRC min = null;

	@Override
	public SRC map(SRC src) {
			if (min == null || src.compareTo(min) < 0) {
				this.min = src;
			}
			return this.min;
	}
	
	public SRC getMin() {
		return min;
	}

}
