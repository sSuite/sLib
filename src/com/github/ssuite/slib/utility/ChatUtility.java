package com.github.ssuite.slib.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import com.github.ssuite.slib.exception.UnsupportedVersionException;
import com.github.ssuite.slib.utility.chat.JSONChatUtility;
import com.github.ssuite.slib.utility.chat.JSONChatUtility_1_8_R1;
import com.github.ssuite.slib.utility.chat.JSONChatUtility_1_8_R3;
import com.github.ssuite.slib.utility.chat.JSONChatUtility_1_9_R1;

public class ChatUtility {

	private static final ChatColor[] chatColors = {ChatColor.DARK_AQUA, ChatColor.DARK_BLUE, ChatColor.DARK_GRAY,
			ChatColor.DARK_GREEN, ChatColor.DARK_PURPLE, ChatColor.DARK_RED, ChatColor.AQUA, ChatColor.BLACK,
			ChatColor.BLUE, ChatColor.GOLD, ChatColor.GRAY, ChatColor.GREEN, ChatColor.LIGHT_PURPLE, ChatColor.RED,
			ChatColor.WHITE, ChatColor.YELLOW, ChatColor.BOLD, ChatColor.ITALIC, ChatColor.STRIKETHROUGH,
			ChatColor.UNDERLINE, ChatColor.RESET, ChatColor.MAGIC};
	// IMPORTANT - DARK COLORS MUST BE FIRST
	private static final String[] stringColors = {"darkaqua", "darkblue", "darkgray", "darkgreen", "darkpurple",
			"darkred", "aqua", "black", "blue", "gold", "gray", "green", "purple", "red", "white", "yellow", "bold",
			"italic", "strikethrough", "underline", "reset", "magic"};

	private static JSONChatUtility jsonChatUtility = null;

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

	/**
	 * Sends the JSON formatted message to <code>player</code>.
	 *
	 * @param player
	 *            - the receiver of the message
	 * @param message
	 *            - the message
	 */
	public static void sendJSONMessage(Player player, String message) {
		if (jsonChatUtility == null) {
			String versionName = Bukkit.getServer().getClass().getPackage().getName();
			String version;
			try {
				version = versionName.replace(".", ",").split(",")[3];
			} catch (ArrayIndexOutOfBoundsException e) {
				// What?
				throw new UnsupportedVersionException("Unsupported version: " + versionName);
			}

			switch (version) {
				case "v1_9_R1":
					// 1.9 - 1.9.2 ++?
					jsonChatUtility = new JSONChatUtility_1_9_R1();
					break;
				case "v1_8_R3":
					// 1.8.4 - 1.8.8
					jsonChatUtility = new JSONChatUtility_1_8_R3();
					break;
				case "v1_8_R2":
					// 1.8.3
					jsonChatUtility = new JSONChatUtility_1_8_R3();
					break;
				case "v1_8_R1":
					// 1.8 - 1.8.2
					jsonChatUtility = new JSONChatUtility_1_8_R1();
					break;
				default:
					throw new UnsupportedVersionException("Unsupported version: " + versionName);
			}
		}

		jsonChatUtility.sendJSONMessage(player, message);
	}

}
