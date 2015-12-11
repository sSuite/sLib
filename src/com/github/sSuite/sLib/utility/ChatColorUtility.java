package com.github.sSuite.sLib.utility;

import org.bukkit.ChatColor;

public class ChatColorUtility {

	private static final ChatColor[] chatColors = {ChatColor.DARK_AQUA, ChatColor.DARK_BLUE, ChatColor.DARK_GRAY,
			ChatColor.DARK_GREEN, ChatColor.DARK_PURPLE, ChatColor.DARK_RED, ChatColor.AQUA, ChatColor.BLACK,
			ChatColor.BLUE, ChatColor.GOLD, ChatColor.GRAY, ChatColor.GREEN, ChatColor.LIGHT_PURPLE, ChatColor.RED,
			ChatColor.WHITE, ChatColor.YELLOW, ChatColor.BOLD, ChatColor.ITALIC, ChatColor.STRIKETHROUGH,
			ChatColor.UNDERLINE, ChatColor.RESET, ChatColor.MAGIC};
	// IMPORTANT - DARK COLORS MUST BE FIRST
	private static final String[] stringColors = {"darkaqua", "darkblue", "darkgray", "darkgreen", "darkpurple",
			"darkred", "aqua", "black", "blue", "gold", "gray", "green", "purple", "red", "white", "yellow", "bold",
			"italic", "strikethrough", "underline", "reset", "magic"};

	/**
	 * Replaces any plain-text color with the actual ChatColor.
	 *
	 * @param string
	 *            - the string to perform color replacements on
	 * @return the string with colors
	 */
	public static String replaceColorPlain(String string) {
		return replaceColor("", string);
	}

	/**
	 * Replaces all color codes delimited by the <code>delimiter</code> with the
	 * actual ChatColor.
	 *
	 * @param delimiter
	 *            - the symbol to use as the delimiter
	 * @param string
	 *            - the string to replace color codes in
	 * @return the string with colors
	 */
	public static String replaceColor(String delimiter, String string) {
		for (int i = 0; i < chatColors.length; i++) {
			string = string.replace(delimiter + stringColors[i] + delimiter, chatColors[i].toString());
		}
		return string;
	}

}
