package com.github.ssuite.slib.utility;

public class StringUtility {
	
	/**
	 * Checks whether a string is safe for using in yaml files.
	 *
	 * @param string the string to check
	 * @return whether or not the string is yaml safe
	 */
	public static boolean yamlSafe(String string) {
		return string.matches("([A-Za-z0-9-_])+");
	}
	
	/**
	 * Repeats a string.
	 *
	 * @param string the string to repeat
	 * @param times  the number of times to repeat the string
	 * @return the repeated string
	 */
	public static String repeat(String string, int times) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < times; i++) {
			stringBuilder.append(string);
		}
		return stringBuilder.toString();
	}
	
}
