package com.github.sSuite.sLib.utility;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelpUtility {

	public static String createHeader(String title, boolean monospace) {
		int maxWidth = MonospaceUtility.DEFAULT_CHAT_WIDTH;

		maxWidth -= MonospaceUtility.getStringWidth(title, monospace);

		return ChatColor.GREEN + MonospaceUtility.repeatStringToWidth("-", maxWidth / 2, monospace) + ChatColor.RESET
				+ title + ChatColor.GREEN + MonospaceUtility.repeatStringToWidth("-", maxWidth / 2, monospace);
	}

	public static String createHeader(String title, int dashCount) {
		return ChatColor.GREEN + StringUtility.repeat("-", dashCount) + ChatColor.RESET + title + ChatColor.GREEN
				+ StringUtility.repeat("-", dashCount);
	}

	public static String createCommand(String command, String usage) {
		return ChatColor.GOLD + command + ChatColor.RESET + " - " + usage;
	}

	public static String createCommand(String command, String usage, CommandSender sender, String permission) {
		if (sender instanceof Player) {
			return createCommand(command, usage, ((Player) sender).hasPermission(permission));
		}

		return createCommand(command, usage, true);
	}

	public static String createCommand(String command, String usage, Player player, String permission) {
		return createCommand(command, usage, player.hasPermission(permission));
	}

	public static String createCommand(String command, String usage, boolean hasPermission) {
		// return ChatColor.GOLD + command + ChatColor.RESET + " - " +
		// (hasPermission ? "" : ChatColor.RED) + usage;
		return hasPermission ? ChatColor.GOLD + command + ChatColor.RESET + " - " + usage : "";
	}

}
