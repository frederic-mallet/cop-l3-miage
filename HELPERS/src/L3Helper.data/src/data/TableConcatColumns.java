package data;

final class TableConcatColumns<TYPE> implements ITable<TYPE> {
	private ITable<? extends TYPE>[] tables;
	private int nbCols = 0, nbRows = 0;
	
	@SafeVarargs
	TableConcatColumns(ITable<? extends TYPE>... tables) {
		super();
		assert(tables.length > 1);
		// compute max of rows and sum of cols
		for (ITable<? extends TYPE> t : tables) {
			if (t.getNbRows() > nbRows) nbRows = t.getNbRows();
			nbCols += t.getNbCols();
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
			if (col < tables[i].getNbCols()) 
				return tables[i].get(row, col);
			col -= tables[i].getNbCols();
		}
		return null;
	}
	
	@Override
	public String toString() {
		return ToString();
	}
}
