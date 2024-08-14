package complexity;

public class Complexity {
	public static boolean LOG = true;
	/**
	 * @param <T> type of the structure to be tested (e.g., int[])
	 * @param builder used to build an object of type T 
	 * @param runner used to run a test on an object of type T
	 * @param min 10^min is the minimum size of the object under test, (min>0)
	 * @param max 10^max is the maximum size of the object under test (max >= min)
	 * @return log_10(complexity)
	 */
	public static <T> double[] eval(TestBuilder<T> builder, TestRunner<T> runner, int min, int max) {
		assert(min > 0);
		assert(max >= min);
		
		long[] durations = new long[max];
		double[] res = new double[max - min];
		int taille = (int)Math.pow(10, min);
		durations[min - 1] = 1; // to avoid log(0) = Infinity
		for (int exp = min; exp < max; exp++) {
			T o = builder.build(taille);
			
			long before = System.currentTimeMillis();
			runner.test(o);
			long after = System.currentTimeMillis();
			
			durations[exp] = after - before;
			
			if (durations[exp] <= 0) durations[exp] = 1; // to avoid undefined Log
			
			res[exp-min] = Math.log10(durations[exp]) - Math.log10(durations[exp - 1]);
			
			if (LOG) {
				System.out.println(taille + " " + durations[exp - 1] + " -> " + durations[exp] + " " + res);
			}
			taille *= 10;
		}
		return res;
	}

	/** When expecting log 
	 * @param <T> type of the structure to be tested (e.g., int[])
	 * @param builder used to build an object of type T 
	 * @param runner used to run a test on an object of type T
	 * @param min 10^min is the minimum size of the object under test, (min>0)
	 * @param max 10^max is the maximum size of the object under test (max >= min)
	 * @return log_10(complexity)
	 */
	public static <T> double evalLog(TestBuilder<T> builder, TestRunner<T> runner, int min, int max) {
		assert(min > 0);
		assert(max >= min);
		
		long[] durations = new long[max];
		double res = 0;
		int taille = (int)Math.pow(10, min);
		for (int exp = min; exp < max; exp++) {
			T o = builder.build(taille);
			long before = System.currentTimeMillis();
			runner.test(o);
			long after = System.currentTimeMillis();
			durations[exp] = after - before;
			res = durations[exp] - durations[exp - 1];
			if (LOG)
				System.out.println(taille + " " + durations[exp] + " " + res);
			taille *= 10;
		}
		return res;
	}

}
