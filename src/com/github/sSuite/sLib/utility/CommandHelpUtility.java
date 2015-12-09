package com.github.sSuite.sLib.utility;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelpUtility {

	public static void sendHeader(String title, CommandSender sender) {
		sender.sendMessage(createHeader(title, !(sender instanceof Player)));
	}

	public static String createHeader(String title, CommandSender sender) {
		return createHeader(title, !(sender instanceof Player));
	}

	public static String createHeader(String title, boolean monospace) {
		int maxWidth = monospace ? MonospaceUtility.DEFAULT_MONOSPACE_CHAT_WIDTH
				: MonospaceUtility.DEFAULT_CLIENT_CHAT_WIDTH;

		maxWidth -= MonospaceUtility.getStringWidth(title, monospace);

		return ChatColor.GREEN + MonospaceUtility.repeatStringToWidth("-", maxWidth / 2, monospace) + ChatColor.RESET
				+ title + ChatColor.GREEN + MonospaceUtility.repeatStringToWidth("-", maxWidth / 2, monospace);
	}

	public static String createHeader(String title, int dashCount) {
		return ChatColor.GREEN + StringUtility.repeat("-", dashCount) + ChatColor.RESET + title + ChatColor.GREEN
				+ StringUtility.repeat("-", dashCount);
	}

	public static void sendCommand(String command, String usage, CommandSender sender, String permission) {
		if (!(sender instanceof Player) || (sender instanceof Player && sender.hasPermission(permission))) {
			sender.sendMessage(createCommand(command, usage));
		}
	}

	public static String createCommand(String command, String usage) {
		return ChatColor.GOLD + command + ChatColor.RESET + " - " + usage;
	}

	public static String createCommand(String command, String usage, CommandSender sender, String permission) {
		if (sender instanceof Player) {
			return createCommand(command, usage, sender.hasPermission(permission));
		}

		return createCommand(command, usage, true);
	}

	public static String createCommand(String command, String usage, Player player, String permission) {
		return createCommand(command, usage, player.hasPermission(permission));
	}

	public static String createCommand(String command, String usage, boolean hasPermission) {
		return ChatColor.GOLD + command + ChatColor.RESET + " - " + (hasPermission ? "" : ChatColor.RED) + usage;
	}

}
