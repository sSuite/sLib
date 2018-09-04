package com.github.ssuite.slib.utility;

import java.util.HashMap;
import java.util.Set;

public class MonospaceUtility {
	
	private static final int DEFAULT_WIDTH = 6;
	public static final int DEFAULT_CLIENT_WIDTH = 320;
	public static final int DEFAULT_MONOSPACE_WIDTH = 60;
	@SuppressWarnings("serial")
	private static HashMap<Integer, String> charWidths = new HashMap<Integer, String>() {
		{
			put(2, "!,.:;i|");
			put(3, "'`l");
			put(4, " I[]t");
			put(5, "\"()*<>fk{}");
			put(7, "@~");
		}
	};
	
	/**
	 * Creates a String which contains full sequences of the specified string no
	 * greater than the specified width.
	 *
	 * @param string    the string to repeat
	 * @param width     the target width
	 * @param monospace whether or not the target output has a monospaced font
	 * @return the repeated string
	 */
	public static String repeatStringToWidth(String string, int width, boolean monospace) {
		int count = width / getStringWidth(string, monospace);
		
		return StringUtility.repeat(string, count);
	}
	
	/**
	 * Gets the pixel width of a string.
	 *
	 * @param string    the string
	 * @param monospace whether or not the target output has a monospaced font
	 * @return the pixel width of the string
	 */
	public static int getStringWidth(String string, boolean monospace) {
		int width = 0;
		// The section symbol followed by a non-style character results in a
		// 6-width character in the client only
		String temporary = string.replaceAll("�([0-9A-Fa-fK-Ok-oRr])", "");
		if (monospace) {
			width = string.length();
		} else {
			temporary = temporary.replaceAll("�.", "0");
			
			for (int i = 0; i < temporary.length(); i++) {
				width += getCharacterWidth(string.charAt(i));
			}
		}
		
		return width;
	}
	
	/**
	 * Fills a string to the specified width with a filler string.
	 *
	 * @param stringToFill the string to fill
	 * @param fillerString the filler string
	 * @param width        the target width
	 * @param monospace    whether or not the target output has a monospaced font
	 * @return the filled string
	 */
	public static String fillToWidthWithString(String stringToFill, String fillerString, int width, boolean monospace) {
		int remainingWidth = width - getStringWidth(stringToFill, monospace);
		
		if (remainingWidth > 0) {
			stringToFill += StringUtility.repeat(fillerString,
					monospace ? remainingWidth : remainingWidth / getStringWidth(fillerString, monospace));
		}
		
		return stringToFill;
	}
	
	/**
	 * Gets the pixel width of a character.
	 *
	 * @param character the character
	 * @return the pixel width of the character
	 */
	public static int getCharacterWidth(char character) {
		int width = DEFAULT_WIDTH;
		Set<Integer> charWidthKeys = charWidths.keySet();
		
		for (int key : charWidthKeys) {
			if (charWidths.get(key).indexOf(character) >= 0) {
				width = key;
			}
		}
		
		return width;
	}
	
}
