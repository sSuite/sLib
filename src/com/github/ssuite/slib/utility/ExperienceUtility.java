package com.github.ssuite.slib.utility;

import org.bukkit.entity.Player;

public class ExperienceUtility {
	
	/**
	 * Calculates the total amount of experience points necessary to reach <code>level</code>.
	 *
	 * @param level the level
	 * @return the total amount of experience points
	 */
	public static int getExperienceFromLevel(int level) {
		if (level < 0) {
			throw new IllegalArgumentException("Level argument must be at least zero.");
		}
		
		if (level <= 16) {
			// Levels 0-16
			return (int) Math.ceil(Math.pow(level, 2) + 6 * level);
		} else if (level <= 31) {
			// Levels 17-31
			return (int) Math.ceil(2.5 * Math.pow(level, 2) - 40.5 * level + 360);
		} else {
			// Levels 32+
			return (int) Math.ceil(4.5 * Math.pow(level, 2) - 162.5 * level + 2220);
		}
	}
	
	/**
	 * Calculates the experience level of <code>experience</code>.
	 *
	 * @param experience the total amount of experience points
	 * @return the level
	 */
	public static int getLevelFromExperience(int experience) {
		if (experience < 0) {
			throw new IllegalArgumentException("Experience argument must be at least zero.");
		}
		
		if (experience < 394) {
			// 394 is the experience required for level 17
			return (int) Math.ceil(-3 + Math.sqrt(experience + 9));
		} else if (experience < 1628) {
			// 1628 is the experience required for level 32
			return (int) Math.ceil(8.1 + 0.1 * Math.sqrt(40 * experience - 7839));
		} else {
			return (int) Math.ceil(18.0556 + 0.0555556 * Math.sqrt(72 * experience - 54215));
		}
	}
	
	/**
	 * Calculates the total number of experience points <code>player</code> has.
	 *
	 * @param player the player
	 * @return the player's total experience
	 */
	public static int getTotalPlayerExperience(Player player) {
		int levelExperience = getExperienceFromLevel(player.getLevel());
		int experienceForNextLevel = getExperienceFromLevel(player.getLevel() + 1);
		int playerOverflowExperience = (int) Math.ceil((experienceForNextLevel - levelExperience) * player.getExp());
		return levelExperience + playerOverflowExperience;
	}
	
	/**
	 * Sets the total number of experience points for <code>player</code>.
	 *
	 * @param player     the player
	 * @param experience the total number of experience points
	 */
	public static void setTotalPlayerExperience(Player player, int experience) {
		player.setLevel(0);
		player.setExp(0);
		player.giveExp(experience);
	}
	
}
