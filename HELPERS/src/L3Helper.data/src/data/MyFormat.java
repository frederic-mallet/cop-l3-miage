package data;

import java.text.DecimalFormat;

public class MyFormat {
	private int length;
	
	MyFormat() { this(7); }
	MyFormat(int length) {
		super();
		this.length = length;
	}

	private static DecimalFormat exp = new DecimalFormat(" 0.##E0;-0.##E0");
	private static DecimalFormat sh = new DecimalFormat(" #0.0;-#0.0");

	String format(Object value) {
		String res;
		if (value == null) res = null;
		else if (value instanceof String) res = value.toString();
		else
			res = sh.format(value);
		
		if (res.length() > this.length) {
			res = exp.format(value);
		}
		while (res.length() < length) {
			res = " " + res;
		}
		return res;
	}
}
