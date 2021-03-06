package com.github.ssuite.slib.utility;

import com.github.ssuite.slib.exception.AmbiguousPlayerNameException;
import com.github.ssuite.slib.exception.NoSuchPlayerException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Collection;

public class PlayerUtility {
	
	/**
	 * Gets an online player by their username.
	 *
	 * @param username the username
	 * @return the player
	 * @throws AmbiguousPlayerNameException when multiple players can be found by a partial name match
	 * @throws NoSuchPlayerException        if no players match
	 */
	public static Player getOnlinePlayerByName(String username)
			throws AmbiguousPlayerNameException, NoSuchPlayerException {
		username = username.toLowerCase();
		Collection<? extends Player> playerList = Bukkit.getServer().getOnlinePlayers();
		Player match = null;
		int count = 0;
		
		for (Player player : playerList) {
			String playerName = player.getName().toLowerCase();
			int minimumLength = Math.min(playerName.length(), username.length());
			if (playerName.substring(0, minimumLength).equalsIgnoreCase(username.substring(0, minimumLength))) {
				count = count + 1;
				match = player;
				if (playerName.equalsIgnoreCase(username)) {
					count = 1;
					break;
				}
			}
		}
		
		if (count > 1) {
			throw new AmbiguousPlayerNameException("The name " + username + " is ambiguous!",
					ChatColor.RED + "The name " + ChatColor.GOLD + username + ChatColor.RED + " is ambiguous!");
		} else if (count < 1) {
			throw new NoSuchPlayerException("The player " + username + " could not be found!",
					ChatColor.RED + "The player " + ChatColor.GOLD + username + ChatColor.RED + " could not be found!");
		}
		
		return match;
	}
	
	/**
	 * Gets an "offline" player by their username.
	 *
	 * @param username the username
	 * @return the offline player
	 */
	public static OfflinePlayer getOfflinePlayerByName(String username) {
		username = username.toLowerCase();
		OfflinePlayer[] playerList = Bukkit.getServer().getOfflinePlayers();
		
		for (OfflinePlayer player : playerList) {
			if (player.getName().toLowerCase().equalsIgnoreCase(username)) {
				return player;
			}
		}
		
		return null;
	}
	
}
