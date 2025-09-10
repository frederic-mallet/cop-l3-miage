package data;

final class TableSlice<TYPE> implements ITable<TYPE> {
	private ITable<TYPE> reference;
	private int minRow, maxRow, minCol, maxCol;
	
	TableSlice(ITable<TYPE> reference, int minRow, int maxRow, int minCol, int maxCol) {
		super();
		assert(0 <= minRow && minRow < maxRow && maxRow <= reference.getNbRows());
		assert(0 <= minCol && minCol < maxCol && maxCol <= reference.getNbCols());
		
		this.reference = reference;
		this.minRow = minRow;
		this.maxRow = maxRow;
		this.minCol = minCol;
		this.maxCol = maxCol;
	}

	@Override
	public int getNbRows() {
		return maxRow - minRow;
	}

	@Override
	public int getNbCols() {
		return maxCol - minCol;
	}

	@Override
	public TYPE get(int row, int col) {
		return reference.get(row + minRow, col + minCol);
	}
	
	@Override
	public String toString() {
		return ToString();
	}	
}
