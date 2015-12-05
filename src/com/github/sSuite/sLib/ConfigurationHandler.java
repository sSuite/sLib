package com.github.sSuite.sLib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigurationHandler {
	private final String CONFIGURATION_EXTENSION = ".yml";
	private final String COMMENT_FILE = "_comments";

	private final JavaPlugin plugin;
	private static FileConfiguration configuration;
	private String fileName;
	private File configurationFile;
	private String pluginVersion;

	public ConfigurationHandler(JavaPlugin plugin) {
		this(plugin, "config");
	}

	public ConfigurationHandler(JavaPlugin plugin, String fileName) {
		this.plugin = plugin;
		this.fileName = fileName;
		File dataFolder = plugin.getDataFolder();
		configurationFile = new File(dataFolder, fileName + CONFIGURATION_EXTENSION);
		try {
			// Check and create the plugin data folder
			if (!dataFolder.exists()) {
				dataFolder.mkdirs();
			}

			// Check and create the configuration file
			if (!configurationFile.exists()) {
				configurationFile.createNewFile();
			}

			// Write the default configuration file, if available
			load();
		} catch (Exception e) {
			// TODO
		}
	}

	public final void load() throws FileNotFoundException, IOException, InvalidConfigurationException {
		// Load the configuration
		configuration = YamlConfiguration.loadConfiguration(configurationFile);

		// Write the default configuration file, if available
		InputStream defaultConfigurationStream = plugin.getResource(fileName + CONFIGURATION_EXTENSION);
		if (defaultConfigurationStream != null) {
			Reader defaultConfigurationReader = new InputStreamReader(defaultConfigurationStream, "UTF8");
			YamlConfiguration defaultConfiguration = YamlConfiguration.loadConfiguration(defaultConfigurationReader);
			configuration.setDefaults(defaultConfiguration);
		}
	}

	public final void save() {
		try {
			configuration.save(configurationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// try {
		// PrintWriter printWriter = new PrintWriter(new
		// FileWriter(configurationFile));
		//
		// printWriter.println("#" + plugin.getName() + " config file.\n");
		// printWriter.println("#Plugin version.");
		// printWriter.print("pluginVersion: \"" + pluginVersion + "\"");
		//
		// printWriter.close();
		// } catch (IOException e) {
		// // plugin.PST(e);
		// // plugin.warn("Error adding comments to config.yml!");
		// }
	}

	@SuppressWarnings("unused")
	private final void restore() {
		try {
			PrintWriter printWriter = new PrintWriter(new FileWriter(configurationFile));

			printWriter.println("pluginVersion: \"" + pluginVersion + "\"");

			printWriter.close();
		} catch (IOException e) {
			// plugin.PST(e);
			// plugin.warn("Error adding comments to config.yml!");
		}
	}

	private void addComments() throws UnsupportedEncodingException {
		// Load the comment configuration
		configuration = new YamlConfiguration();

		// Write the default configuration file, if available
		InputStream defaultConfigurationStream = plugin.getResource(fileName + COMMENT_FILE + CONFIGURATION_EXTENSION);
		if (defaultConfigurationStream != null) {
			Reader defaultConfigurationReader = new InputStreamReader(defaultConfigurationStream, "UTF8");
			YamlConfiguration defaultConfiguration = YamlConfiguration.loadConfiguration(defaultConfigurationReader);
			configuration.setDefaults(defaultConfiguration);
		}
	}

	public Configuration getConfig() {
		return configuration;
	}
}
