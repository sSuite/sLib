package com.github.sSuite.sLib;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class ErrorHandler {

	JavaPlugin plugin;
	public static Configuration cfg;
	private final String silent;
	private final String debug;

	public ErrorHandler(JavaPlugin p, Configuration cfg, String debug, String silent) {
		plugin = p;
		if (debug.equals("")) {
			this.debug = null;
		} else {
			this.debug = debug;
		}
		if (silent.equals("")) {
			this.silent = null;
		} else {
			this.silent = silent;
		}
		ErrorHandler.cfg = cfg;
	}

	public final void printStackTrace(Exception e) {
		if (!cfg.equals(null)) {
			if (!debug.equals(null)) {
				if (cfg.getBoolean(debug, true)) {
					if (!silent.equals(null)) {
						if (cfg.getBoolean(silent, false)) {
							e.printStackTrace();
						}
					} else {
						e.printStackTrace();
					}
				}
			} else if (!silent.equals(null)) {
				if (cfg.getBoolean(silent, false)) {
					e.printStackTrace();
				}
			} else {
				e.printStackTrace();
			}
		}
	}
}
