package data;

import java.util.Iterator;

import data.operation.Addition;
import data.operation.IMap;
import data.operation.MaxMap;
import data.operation.MeansMap;
import data.operation.MinMap;
import data.operation.NormalizeMap;
import data.operation.Number2Double;

public class TableUtils {
	public static <TYPE> ITable<TYPE> slice(ITable<TYPE> table, int rowMin, int rowMax, int colMin, int colMax) {
		return new TableSlice<TYPE>(table, rowMin, rowMax, colMin, colMax);
	}
	
	public static <TYPE> ITable<TYPE> columns(ITable<TYPE> table, int colMin, int colMax) {
		if (colMin == 0 && colMax == table.getNbCols()) { // works also is nbCols==1
			return table;
		}
		return slice(table, 0, table.getNbRows(), colMin, colMax);
	}

	public static <TYPE> ITable<TYPE> rows(ITable<TYPE> table, int rowMin, int rowMax) {
		if (rowMin == 0 && rowMax == table.getNbRows()) {
			return table;
		}
		return slice(table, rowMin, rowMax, 0, table.getNbCols());
	}
	@SafeVarargs
	public static <TYPE> ITable<TYPE> sideBySide(ITable<? extends TYPE> ... tables) {
		return new TableConcatColumns<TYPE>(tables);
	}
	@SafeVarargs
	public static <TYPE> ITable<TYPE> upAbove(ITable<? extends TYPE> ... tables) {
		return new TableConcatRows<TYPE>(tables);
	}	
	public static ITable<? extends Number> addColumns(ITable<? extends Number> table, int ...columns) {
		@SuppressWarnings("unchecked")
		ITable<? extends Number>[] tables1 = new ITable[columns.length];		
		@SuppressWarnings("unchecked")
		ITable<? extends Number>[] tables2 = new ITable[columns.length + 1];
		for (int i=0; i < columns.length; i++) {
			tables1[i] = columns(table, columns[i], columns[i]+1);
			tables2[i] = columns(table, columns[i], columns[i]+1);
		}
		
		tables2[tables2.length-1] = new TableAsOperation<Double>(new Addition(), tables1); // at the end
		return sideBySide(tables2);
	}
	
	public static <SRC,DST> ITable<DST>  mapToEachColumn(ITable<? extends SRC> table, IMap<ITable<? extends SRC>, ITable<DST>> tableMap) {
		int numCols = table.getNbCols();
		if (numCols <= 1) return tableMap.map(table);
		
		return sideBySide(mapToEachColumn(columns(table, 0, numCols >> 1), tableMap), 
				mapToEachColumn(columns(table, numCols >> 1, numCols), tableMap));
	}
	public static <SRC,DST> ITable<DST> mapTo(ITable<? extends SRC> table, IMap<SRC, DST> map) {
		return new TableMap<SRC,DST>(table, map);
	}
	public static <SRC,DST> ITable<? extends DST> mapToColumns(ITable<? extends SRC> table, IMap<SRC, DST> map) {
		return mapToEachColumn(table, new IMap<ITable<? extends SRC>, ITable<DST>>() {
			@Override
			public ITable<DST> map(ITable<? extends SRC> src) {
				return mapTo(src, map);
			}
		});
	}
	
	public static <SRC,DST> DST red(ITable<? extends SRC> table, IMap<SRC, DST> map) {
		DST res = null;
		for (SRC src : table) {
			res = map.map(src);
		}
		return res;
	}
	public static ITable<Double> normalizeColumns(ITable<? extends Number> table) {
		return mapToEachColumn(table, new IMap<ITable<? extends Number>, ITable<Double>>() {
			@Override
			public ITable<Double> map(ITable<? extends Number> src) {
				return normalize(src);
			}
		});
	}
	public static ITable<Double> normalize(ITable<? extends Number> table) {
		double [] res = std(table);
		return mapTo(table, new NormalizeMap(res[1], res[2]));
	}
	public static double min(ITable<? extends Number> table) {
		ITable<Double> tableAsDouble = new TableMap<Number, Double>(table, new Number2Double<Number>());
		return red(tableAsDouble, new MinMap<>());
	}
	public static double max(ITable<? extends Number> table) {
		ITable<Double> tableAsDouble = new TableMap<Number, Double>(table, new Number2Double<Number>());
		return red(tableAsDouble, new MaxMap<>());
	}
	public static double means(ITable<? extends Number> table) {
		return red(table, new MeansMap());
	}
	/**
	 * @param table
	 * @return [number of elements, means of elements, standard deviation of elements]
	 */
	public static double[] std(ITable<? extends Number> table) {
		double res[] = { 0.0, means(table), 0.0 }; 
		
		for (Number n : table) {
			double val = (n.doubleValue() - res[1]); 
			res[2] += val * val;
			res[0] += 1;
		}
		
		res[2] = Math.sqrt(res[2] / res[0]);
		
		return res;
	}

	public static ITable<Double> properties(ITable<? extends Number> table) {
		Double[] properties = new Double[5];
		double[] std = std(table); 
		
		properties[0] = std[0];
		properties[1] = min(table);
		properties[2] = max(table);
		properties[3] = std[1]; // means
		properties[4] = std[2]; // standard deviation		
		
		return new TableAsArray<Double>(properties.length, 1, properties);
	}

	public static ITable<Double> columnsProperties(ITable<? extends Number> table) {
		return mapToEachColumn(table, new IMap<ITable<? extends Number>, ITable<Double>>() {
			@Override
			public ITable<Double> map(ITable<? extends Number> src) {
				return properties(src);
			}
		});
	}
	
	
	private static String[] PROPERTIES = { "Number", "Min", "Max", "Means", "Standard deviation" };
	public static void printProperties(ITable<? extends Number> table) {
		ITable<Double> properties = columnsProperties(table);
		Iterator<Double> it = properties.iterator();
		
		for (int row = 0; row < properties.getNbRows(); row++) {
			System.out.printf("%20s\t", PROPERTIES[row]);
			for (int col = 0; col < properties.getNbCols(); col++) {
				System.out.printf("%10.2f ", it.next());
			}
			System.out.println();
		}
	}
}
