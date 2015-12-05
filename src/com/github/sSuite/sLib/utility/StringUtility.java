package com.github.sSuite.sLib.utility;

public class StringUtility {

	/**
	 * Checks whether a string is safe for using in yaml files.
	 *
	 * @param string
	 * @return whether or not the string is yaml safe
	 */
	public static boolean yamlSafe(String string) {
		return string.matches("([A-Za-z0-9-_])+");
	}

	/**
	 * Repeats a string.
	 *
	 * @param string
	 * @param times
	 * @return
	 */
	public static String repeat(String string, int times) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < times; i++) {
			stringBuilder.append(string);
		}
		return stringBuilder.toString();
	}

}
