package data;

import java.util.Iterator;

class TableIterator<TYPE> implements Iterator<TYPE> {
	private ITable<TYPE> reference;
	private int row, col;
	
	TableIterator(ITable<TYPE> reference) {
		super();
		this.reference = reference;
		this.row = 0;
		this.col = 0;
	}

	@Override
	public boolean hasNext() {
		return row < reference.getNbRows() && col < reference.getNbCols();
	}

	@Override
	public TYPE next() {
		TYPE element = reference.get(row, col);
		col++; 
		if (col == reference.getNbCols()) {
			col = 0; 
			row++;
		}
		return element;
	}
}
