package uca.l3cop.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreedyCupid {
	public static void main(String[] args) {
		String text = "\t<!DOCTYPE html>\n<html><header><title>Title</title></header><body>Body</body></html>";
		
		test(text, ".*", ".*?");
		
		test(text, "<.*>", "<.*?>");

		test(text, "<.*>.*</.*>", "<.*?>.*?</.*?>");

		test(text, "<(.*)>(.*)</(.*)>", "<(.*?)>(.*?)</(.*?)>");

		String regexp = "<(.*?)>(.*)</(.*?)>";
		System.out.printf("\n*** MIX *** : \t%s\n", regexp);
		FindAndMatches(text, regexp);
	}

	private static void test(String text, String greedy, String reticent) {
		System.out.printf("\n*** GREEDY *** : \t%s\n", greedy);
		FindAndMatches(text, greedy);

		System.out.printf("\n*** RETICENT *** : \t%s\n", reticent);
		FindAndMatches(text, reticent);
	}
	private static void FindAndMatches(String text, String regexp) {
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(text);
		System.out.println("Find in:");
		while (matcher.find()) {
			System.out.printf("\t[%2d, %2d[ | %s\n", matcher.start(), matcher.end(), matcher.group());
				for (int i=1; i<=matcher.groupCount(); i++) {
					System.out.printf("\t\t%d [%2d, %2d[ %s\n", i, matcher.start(i), matcher.end(i), matcher.group(i));
				}
		}
		System.out.println();
		System.out.printf("Matches=%b [%2d, %2d[\n", matcher.matches(), matcher.regionStart(), matcher.regionEnd());
	}
}
