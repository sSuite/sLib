package com.github.ssuite.slib.utility;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelpUtility {

	/**
	 * Sends a centered header to the sender.
	 *
	 * @param title
	 *            - the title of the header
	 * @param sender
	 *            - the sender
	 */
	public static void sendHeader(String title, CommandSender sender) {
		sender.sendMessage(createHeader(title, !(sender instanceof Player)));
	}

	/**
	 * Creates a centered header for the sender.
	 *
	 * @param title
	 *            - the title of the header
	 * @param sender
	 *            - the sender
	 * @return the header
	 */
	public static String createHeader(String title, CommandSender sender) {
		return createHeader(title, !(sender instanceof Player));
	}

	/**
	 * Creates a centered header for the sender.
	 *
	 * @param title
	 *            - the title of the header
	 * @param monospace
	 *            - whether or not the target output has a monospaced font
	 * @return the header
	 */
	public static String createHeader(String title, boolean monospace) {
		int maxWidth = monospace ? MonospaceUtility.DEFAULT_MONOSPACE_WIDTH : MonospaceUtility.DEFAULT_CLIENT_WIDTH;

		maxWidth -= MonospaceUtility.getStringWidth(title, monospace);

		return ChatColor.GREEN + MonospaceUtility.repeatStringToWidth("-", maxWidth / 2, monospace) + ChatColor.RESET
				+ title + ChatColor.GREEN + MonospaceUtility.repeatStringToWidth("-", maxWidth / 2, monospace);
	}

	/**
	 * Creates a centered header with <code>dashCount</code> dashes on each side
	 * of the title.
	 *
	 * @param title
	 *            - the title of the header
	 * @param dashCount
	 *            - the number of dashes on each side
	 * @return the header
	 */
	public static String createHeader(String title, int dashCount) {
		return ChatColor.GREEN + StringUtility.repeat("-", dashCount) + ChatColor.RESET + title + ChatColor.GREEN
				+ StringUtility.repeat("-", dashCount);
	}

	/**
	 * Sends a formatted command string to the sender if the sender has the
	 * specified permission.
	 *
	 * @param command
	 *            - the command
	 * @param usage
	 *            - the command usage
	 * @param sender
	 *            - the sender
	 * @param permission
	 *            - the permission to check
	 */
	public static void sendCommand(String command, String usage, CommandSender sender, String permission) {
		if (!(sender instanceof Player) || sender instanceof Player && sender.hasPermission(permission)) {
			sender.sendMessage(createCommand(command, usage));
		}
	}

	/**
	 * Sends a formatted command string to the sender.
	 *
	 * @param command
	 *            - the command
	 * @param usage
	 *            - the command usage
	 * @param sender
	 *            - the sender
	 */
	public static void sendCommand(String command, String usage, CommandSender sender) {
		sender.sendMessage(createCommand(command, usage));
	}

	/**
	 * Creates a permission-based formatted command string for the sender.
	 *
	 * @param command
	 *            - the command
	 * @param usage
	 *            - the command usage
	 * @param sender
	 *            - the sender
	 * @param permission
	 *            - the permission to check
	 * @return the formatted command string
	 */
	public static String createCommand(String command, String usage, CommandSender sender, String permission) {
		if (sender instanceof Player) {
			return createCommand(command, usage, sender.hasPermission(permission));
		}

		return createCommand(command, usage, true);
	}

	/**
	 * Creates a permission-based formatted command string for the player.
	 *
	 * @param command
	 *            - the command
	 * @param usage
	 *            - the command usage
	 * @param player
	 *            - the player
	 * @param permission
	 *            - the permission to check
	 * @return the formatted command string
	 */
	public static String createCommand(String command, String usage, Player player, String permission) {
		return createCommand(command, usage, player.hasPermission(permission));
	}

	/**
	 * Creates a permission-based formatted command string.
	 *
	 * @param command
	 *            - the command
	 * @param usage
	 *            - the command usage
	 * @param hasPermission
	 *            - whether or not the user has permission
	 * @return the formatted command string
	 */
	public static String createCommand(String command, String usage, boolean hasPermission) {
		return formatCommand(command) + (hasPermission ? "" : ChatColor.RED) + usage;
	}

	/**
	 * Creates a formatted command string.
	 *
	 * @param command
	 *            - the command
	 * @param usage
	 *            - the command usage
	 * @return the formatted command string
	 */
	public static String createCommand(String command, String usage) {
		return formatCommand(command) + usage;
	}

	/**
	 * Formats the static half of the command string.
	 *
	 * @param command
	 *            - the command
	 * @return the static half of the command string
	 */
	private static String formatCommand(String command) {
		return ChatColor.GOLD + command + ChatColor.RESET + " - ";
	}

}
