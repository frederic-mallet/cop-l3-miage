package data;

import java.util.Iterator;

class TableColumnIterator<TYPE> implements Iterator<data.ITable<TYPE>> {
	private int current = 0;
	private ITable<TYPE> iTable;
	
	TableColumnIterator(ITable<TYPE> iTable) {
		this.iTable = iTable;
	}

	@Override
	public boolean hasNext() {
		return current < iTable.getNbCols();
	}

	@Override
	public ITable<TYPE> next() {
		return TableUtils.columns(iTable, current, ++current);
	}

}
