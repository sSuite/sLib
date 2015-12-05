package com.github.sSuite.sLib.utility;

import net.md_5.bungee.api.ChatColor;

public class CommandHelpUtility {

	public static String createHeader(String title, int dashCount) {
		return ChatColor.GREEN + StringUtility.repeat("-", dashCount) + title + " Help"
				+ StringUtility.repeat("-", dashCount);
	}

	public static String createCommand(String command, String usage) {
		return ChatColor.GOLD + command + ChatColor.RESET + " - " + usage;
	}

}
