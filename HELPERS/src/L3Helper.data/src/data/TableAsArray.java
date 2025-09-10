package data;

import java.util.Arrays;

final class TableAsArray<TYPE> implements ITable<TYPE> {
	private TYPE[] elements;
	private int nbRows, nbCols;
	
	@SafeVarargs
	public TableAsArray(int nbRows, int nbCols, TYPE...elements) {
		assert(nbRows > 0);
		assert(nbCols > 0);
		assert(nbRows * nbCols <= elements.length);
		this.nbRows = nbRows;
		this.nbCols = nbCols;
		this.elements= Arrays.copyOf(elements, nbRows * nbCols);
	}
	
	@Override
	public int getNbRows() {
		return nbRows;
	}

	@Override
	public int getNbCols() {
		return nbCols;
	}

	@Override
	public TYPE get(int row, int col) {
		if (row < 0 || row >= nbRows) return null;
		if (col < 0 || col >= nbCols) return null;
		
		int pos = row * nbCols + col;
		return elements[pos];
	}

	@Override
	public String toString() {
		return ToString();
	}
}
