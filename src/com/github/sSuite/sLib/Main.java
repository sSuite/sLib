package com.github.sSuite.sLib;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Logger logger;

	@Override
	public void onEnable() {
		logger = getLogger();
	}

	@Override
	public void onDisable() {

	}
}
