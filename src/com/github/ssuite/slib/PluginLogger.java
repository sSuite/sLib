package com.github.ssuite.slib;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;

public class PluginLogger {
	
	// Each level does not imply any other!
	private enum LogLevel {
		DEBUG, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST;
	}
	
	@SuppressWarnings("unused")
	private JavaPlugin plugin;
	private Logger logger;
	private ArrayList<LogLevel> enabledLevels;
	private boolean silent = false;
	
	public PluginLogger(JavaPlugin plugin) {
		this.plugin = plugin;
		logger = plugin.getLogger();
		enabledLevels = new ArrayList<LogLevel>();
		enabledLevels.add(LogLevel.SEVERE);
		enabledLevels.add(LogLevel.WARNING);
		enabledLevels.add(LogLevel.INFO);
		enabledLevels.add(LogLevel.CONFIG);
		enabledLevels.add(LogLevel.FINE);
		enabledLevels.add(LogLevel.FINER);
		enabledLevels.add(LogLevel.FINEST);
	}
	
	public final void printStackTrace(Exception e) {
		printStackTrace(e, false);
	}
	
	public final void printStackTrace(Exception e, boolean debugOnly) {
		if (!silent) {
			if (!debugOnly || (debugOnly && enabledLevels.contains(LogLevel.DEBUG))) {
				e.printStackTrace();
			}
		}
	}
	
	public void setSilent(boolean silent) {
		this.silent = silent;
	}
	
	public void setLevelEnabled(LogLevel level, boolean enabled) {
		if (enabled) {
			if (!enabledLevels.contains(level)) {
				enabledLevels.add(level);
			}
		} else {
			enabledLevels.remove(level);
		}
	}
	
	public boolean isLevelEnabled(LogLevel level) {
		return enabledLevels.contains(level);
	}
	
	public void debug(String message) {
		if (!silent && enabledLevels.contains(LogLevel.DEBUG)) {
			logger.info("[DEBUG] " + message);
		}
	}
	
	public void severe(String message) {
		if (!silent && enabledLevels.contains(LogLevel.SEVERE)) {
			logger.severe(message);
		}
	}
	
	public void warning(String message) {
		if (!silent && enabledLevels.contains(LogLevel.WARNING)) {
			logger.warning(message);
		}
	}
	
	public void info(String message) {
		if (!silent && enabledLevels.contains(LogLevel.INFO)) {
			logger.info(message);
		}
	}
	
	public void config(String message) {
		if (!silent && enabledLevels.contains(LogLevel.CONFIG)) {
			logger.config(message);
		}
	}
	
	public void fine(String message) {
		if (!silent && enabledLevels.contains(LogLevel.FINE)) {
			logger.fine(message);
		}
	}
	
	public void finer(String message) {
		if (!silent && enabledLevels.contains(LogLevel.FINER)) {
			logger.finer(message);
		}
	}
	
	public void finest(String message) {
		if (!silent && enabledLevels.contains(LogLevel.FINEST)) {
			logger.finest(message);
		}
	}
	
}
