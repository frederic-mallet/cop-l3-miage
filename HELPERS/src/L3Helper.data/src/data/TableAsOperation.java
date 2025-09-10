package data;

import data.operation.IOperation;

final class TableAsOperation<DST> implements ITable<DST> {
	private ITable<?> [] tables;
	private IOperation<DST> op;
	private int rows = 0, cols = 0;
	
	TableAsOperation(IOperation<DST> op, ITable<?> ...tables) {
		super();
		assert(tables.length > 0);
		// compute max of rows and cols
		// assumes null where there is no object, let the operation decide what to do with Null
		for (ITable<?> t : tables) {
			if (t.getNbRows() > rows) rows = t.getNbRows();
			if (t.getNbCols() > cols) cols = t.getNbCols();
		}
		this.tables = tables;
		this.op = op;
	}

	@Override
	public int getNbRows() {
		return rows;
	}

	@Override
	public int getNbCols() {
		return cols;
	}

	@Override
	public DST get(int row, int col) {
		Object[] inputs = new Object[tables.length];
		for (int i = 0; i < tables.length; i++) {
			inputs[i] = tables[i].get(row, col);
		}
		return op.compute(inputs);
	}
	
	@Override
	public String toString() {
		return ToString();
	}	
}
