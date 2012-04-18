package tk.nekotech.sSuiteLib;

import java.util.logging.Logger;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class Logging{

	public JavaPlugin p;
	public static Configuration cfg;
	private Logger log;
	private final String silent;
	private final String debug;

	public Logging(JavaPlugin p, Configuration cfg, String debug, String silent){
		this.p = p;
		this.debug = debug;
		this.silent = silent;
		Logging.cfg = cfg;
		Logger log = p.getLogger();
	}

	@SuppressWarnings("unused")
	private final void debug(String i){
		if (!debug.equals("")){
			if (cfg.getBoolean(debug, true))
				if (!silent.equals("")){
					if (cfg.getBoolean(silent, false))
						log.info("[Debug] " + i);
				}else
					log.info("[Debug] " + i);
		}else if (!silent.equals("")){
			if (cfg.getBoolean(silent, false))
				log.info("[Debug] " + i);
		}else
			log.info("[Debug] " + i);
	}

	@SuppressWarnings("unused")
	private final void info(String i){
		if (!silent.equals("")){
			if (cfg.getBoolean(silent, false))
				log.info(i);
		}else
			log.info(i);
	}

	@SuppressWarnings("unused")
	private final void warn(String i){
		if (!silent.equals("")){
			if (cfg.getBoolean(silent, false))
				log.warning(i);
		}else
			log.warning(i);
	}

	@SuppressWarnings("unused")
	private final void severe(String i){
		if (!silent.equals("")){
			if (cfg.getBoolean(silent, false))
				log.severe(i);
		}else
			log.severe(i);
	}

	@SuppressWarnings("unused")
	private final void fine(String i){
		if (!silent.equals("")){
			if (cfg.getBoolean(silent, false))
				log.fine(i);
		}else
			log.fine(i);
	}

	@SuppressWarnings("unused")
	private final void finer(String i){
		if (!silent.equals("")){
			if (cfg.getBoolean(silent, false))
				log.finer(i);
		}else
			log.finer(i);
	}

	@SuppressWarnings("unused")
	private final void finest(String i){
		if (!silent.equals("")){
			if (cfg.getBoolean(silent, false))
				log.finest(i);
		}else
			log.finest(i);
	}

	@SuppressWarnings("unused")
	private final void config(String i){
		if (!silent.equals("")){
			if (cfg.getBoolean(silent, false))
				log.config(i);
		}else
			log.config(i);
	}
}
