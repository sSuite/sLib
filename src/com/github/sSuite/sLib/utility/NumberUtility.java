package com.github.sSuite.sLib.utility;

public class NumberUtility {

	/**
	 * Rounds the number to the nearest whole number.
	 * 
	 * @param number
	 *            - the number
	 * @return the rounded number
	 */
	public static double roundDouble(double number) {
		return roundDouble(number, 0);
	}

	/**
	 * Rounds the number to the specified places.
	 * 
	 * @param number
	 *            - the number
	 * @param places
	 *            - the number of places
	 * @return the rounded number
	 */
	public static double roundDouble(double number, int places) {
		number = Math.floor(number * Math.pow(10, places) + 0.5) / Math.pow(10, places);
		String numberString = "" + number;
		if (places > 0) {
			// Escape the magic character "." with "%"
			if (!numberString.contains(".")) {
				numberString = numberString + ".";
			}
			int decimalPosition = numberString.indexOf(".") + 1;
			int decimals = numberString.length() - decimalPosition;
			numberString = numberString + StringUtility.repeat("0", places - decimals);
		}
		return Double.parseDouble(numberString);
	}

	/**
	 * @param number
	 *            - the number
	 * @return the rounded number
	 */
	public static String roundString(double number) {
		return roundString(number, 0);
	}

	/**
	 * @param number
	 *            - the number
	 * @param places
	 *            - the number of places
	 * @return the rounded number
	 */
	public static String roundString(double number, int places) {
		number = Math.floor(number * Math.pow(10, places) + 0.5) / Math.pow(10, places);
		String numberString = "" + number;
		if (places > 0) {
			// Escape the magic character "." with "%"
			if (!numberString.contains(".")) {
				numberString = numberString + ".";
			}
			int decimalPosition = numberString.indexOf(".") + 1;
			int decimals = numberString.length() - decimalPosition;
			numberString = numberString + StringUtility.repeat("0", places - decimals);
		}
		return numberString;
	}

}
