package data.tests;

import data.ITable;
import data.TableDouble;
import data.TableUtils;

public class ReadTests {
	public static void main(String[] args) {
		System.out.println("ex1data1.txt");
		ITable<Double> table1 = TableDouble.readTableAsDouble("res/ex1data1.txt");
		TableUtils.printProperties(table1);
//		System.out.println(table1.ToString());
		
		System.out.println("\nadd sum as last columns");
		TableUtils.printProperties(TableUtils.addColumns(table1, 0, 1));
		ITable<Double> normTable1 = TableUtils.normalizeColumns(table1);
//		System.out.println(normTable1.ToString());
		System.out.println("\nnormalize");
		TableUtils.printProperties(normTable1);

		System.out.println("\nex1data2.txt");
		ITable<Double> table2 = TableDouble.readTableAsDouble("res/ex1data2.txt");
		TableUtils.printProperties(table2);
//		System.out.println(table2.ToString());

		System.out.println("\nadd sum as last columns");
		TableUtils.printProperties(TableUtils.addColumns(table2, 0, 1, 2));
		ITable<Double> normTable2 = TableUtils.normalizeColumns(table2);
		System.out.println("\nnormalize");
		TableUtils.printProperties(normTable2);
		
		System.out.println(TableUtils.upAbove(TableUtils.columnsProperties(table1), TableUtils.columnsProperties(table2)));
	}
}