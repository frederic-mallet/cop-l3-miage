package data;

import java.util.Iterator;

public interface ITable<TYPE> extends Iterable<TYPE> {
	/** @return number of rows in the table */
	int getNbRows();
	/** @return number of columns in the table */
	int getNbCols();
	
	/** @return element in rows row and column col. */
	TYPE get(int row, int col);
	
	
	default public Iterator<TYPE> iterator() {
		return new TableIterator<TYPE>(this);
	}
	
	default public String ToString() {
		MyFormat format = new MyFormat(7);
		StringBuffer sb = new StringBuffer();
		sb.append(getNbRows()).append('x').append(getNbCols()).append(" [\n" );
		for (int row = 0; row < getNbRows(); row++) {
			for (int col = 0; col < getNbCols(); col++) {
				TYPE t = get(row, col);
				if (t==null) sb.append(format.format("-")); else sb.append(format.format(t));
				sb.append(' ');
			}
			sb.append('\n');
		}
		sb.append(']');
		return sb.toString();
	}
	
	default public Iterator<ITable<TYPE>> columnIterator() {
		return new TableColumnIterator<TYPE>(this);
	}
}
