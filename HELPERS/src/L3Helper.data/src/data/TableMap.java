package data;

import data.operation.IMap;

final class TableMap<SRC,DST> implements ITable<DST> {
	private ITable<? extends SRC> src;
	
	private IMap<SRC, DST> op;
	
	TableMap(ITable<? extends SRC> tableSrc, IMap<SRC, DST> op) {
		super();
		
		this.src = tableSrc;
		this.op = op;
	}

	@Override
	public int getNbRows() {
		return src.getNbRows();
	}

	@Override
	public int getNbCols() {
		return src.getNbCols();
	}

	@Override
	public DST get(int row, int col) {
		return op.map(src.get(row, col));
	}
	
	@Override
	public String toString() {
		return ToString();
	}	
}
