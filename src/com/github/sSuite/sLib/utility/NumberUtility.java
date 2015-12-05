package com.github.sSuite.sLib.utility;

public class NumberUtility {

	/**
	 * @param number
	 * @return
	 */
	public static double round(double number) {
		return round(number, 0);
	}

	/**
	 * @param number
	 * @param places
	 * @return
	 */
	public static double round(double number, int places) {
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

}
