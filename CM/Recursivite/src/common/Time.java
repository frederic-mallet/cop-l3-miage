package common;

public class Time {
	static final public String nanoSecondsToTime(long nanoSeconds) {
		String str;
		int nano = (int)(nanoSeconds % 1000);
		long microseconds = nanoSeconds / 1000;
		
		str = String.format("%3d us %3d ns", microseconds % 1000, nano);
		
		long milliseconds = microseconds / 1000;		
		if (milliseconds == 0) return str;

		str = String.format("%3d ms %s", (milliseconds % 1000), str);
		long seconds = milliseconds / 1000;
		if (seconds == 0) return str;

		str = String.format("%3d s %s", (seconds % 60), str);
		long minutes = seconds / 60;
		if (minutes == 0) return str;
		
		str = String.format("%3d min %s", (minutes % 60), str);
		long heures = minutes / 60;	
		if (heures == 0) return str;
		
		str = heures +" h " + str;
		
		return str;
	}
}
