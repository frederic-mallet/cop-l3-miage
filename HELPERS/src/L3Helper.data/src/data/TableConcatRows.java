package data;

final class TableConcatRows<TYPE> implements ITable<TYPE> {
	private ITable<? extends TYPE>[] tables;
	private int nbCols = 0, nbRows = 0;
	
	@SafeVarargs
	TableConcatRows(ITable<? extends TYPE>... tables) {
		super();
		assert(tables.length > 1);
		// compute max of cols and sum of rows
		for (ITable<? extends TYPE> t : tables) {
			if (t.getNbCols() > nbCols) nbCols = t.getNbCols();
			nbRows += t.getNbRows();
		}
		
		this.tables = tables;
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
		for (int i = 0; i < tables.length; i++) {
			if (row < tables[i].getNbRows()) 
				return tables[i].get(row, col);
			row -= tables[i].getNbRows();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return ToString();
	}
}