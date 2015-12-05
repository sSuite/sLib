package com.github.sSuite.sLib.utility;

import java.util.Collection;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import com.github.sSuite.sLib.exception.AmbiguousPlayerNameException;
import com.github.sSuite.sLib.exception.NoSuchPlayerException;

public class PlayerUtility {

	/**
	 * @param name
	 * @return
	 * @throws AmbiguousPlayerNameException
	 * @throws NoSuchPlayerException
	 */
	public static Player getOnlinePlayerByName(String name) throws AmbiguousPlayerNameException, NoSuchPlayerException {
		name = name.toLowerCase();
		Collection<? extends Player> playerList = Bukkit.getServer().getOnlinePlayers();
		Player match = null;
		int count = 0;

		for (Player player : playerList) {
			if (player.getName().toLowerCase().contains(name)) {
				count = count + 1;
				match = player;
			}
		}
		if (count > 1) {
			throw new AmbiguousPlayerNameException("The name " + name + " is ambiguous.");
		} else if (count < 1) {
			throw new NoSuchPlayerException("The player " + name + " could not be found.");
		}
		return match;
	}

	public static OfflinePlayer getOfflinePlayerByName(String name) {
		name = name.toLowerCase();
		OfflinePlayer[] playerList = Bukkit.getServer().getOfflinePlayers();

		for (OfflinePlayer player : playerList) {
			if (player.getName().toLowerCase().equalsIgnoreCase(name)) {
				return player;
			}
		}
		return null;
	}

}
