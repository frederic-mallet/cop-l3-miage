package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TableDouble {	
	static public ITable<Double> readTableAsDouble(String fileName) {
		ArrayList<Double> elements = new ArrayList<>();
		int col = 0;
		int row = 0;
		try (Scanner sc = new Scanner(new File(fileName))) {
			while (sc.hasNext()) {
				String ligne = sc.next();
				String[] tokens = ligne.split(",");

				if (col == 0) col = tokens.length;
				else if(col != tokens.length) {
					throw new RuntimeException("TableAsArray: " + row + "," + col + " : inconsistent number of columns " + tokens.length);
				}
				for (String token : tokens) {
					try {
						elements.add(Double.parseDouble(token));
					} catch (NumberFormatException nfe) {
						System.out.println("Parse error reading doubles " + row + ", " + col + " : " + token);
						elements.add(Double.NaN); //replace error by NaN
					}
				}
				row++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return new TableAsArray<Double>(row, col, elements.toArray(new Double[0]));
	}
}
