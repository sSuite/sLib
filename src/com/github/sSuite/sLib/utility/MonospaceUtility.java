package com.github.sSuite.sLib.utility;

import java.util.HashMap;
import java.util.Set;

public class MonospaceUtility {

	private static final int DEFAULT_WIDTH = 6;
	public static final int DEFAULT_CLIENT_CHAT_WIDTH = 320;
	public static final int DEFAULT_MONOSPACE_CHAT_WIDTH = 60;
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

	public static String repeatStringToWidth(String string, int width, boolean monospace) {
		int count = width / getStringWidth(string, monospace);

		return StringUtility.repeat(string, count);
	}

	public static int getStringWidth(String string, boolean monospace) {
		int width = 0;
		// The section symbol followed by a non-style character results in a
		// 6-width character in the client only
		String temporary = string.replaceAll("§([0-9A-Fa-fK-Ok-oRr])", "");
		if (monospace) {
			temporary = temporary.replaceAll("§.", "0");
		}

		for (int i = 0; i < temporary.length(); i++) {
			width += getCharacterWidth(string.charAt(i));
		}

		return width;
	}

	public static String fillToWidthWithString(String stringToFill, String fillerString, int width, boolean monospace) {
		int currentWidth = getStringWidth(stringToFill, monospace);

		if (currentWidth < width) {
			stringToFill += StringUtility.repeat(fillerString,
					monospace ? width - currentWidth : width - currentWidth / getStringWidth(fillerString, monospace));
		}

		return stringToFill;
	}

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
