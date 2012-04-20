package tk.nekotech.sSuiteLib;

import java.util.logging.Logger;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class Logging{

	private JavaPlugin p;
	private static Configuration cfg;
	private Logger log;
	private String silent;
	private String debug;

	//	private boolean in = false;

	public Logging(JavaPlugin p, Configuration cfg, String debug, String silent){
		this.p = p;
		if (debug.equals(""))
			this.debug = null;
		else
			this.debug = debug;
		if (silent.equals(""))
			this.silent = null;
		else
			this.silent = silent;
		Logging.cfg = cfg;
		this.log = p.getLogger();
	}

	/*
	public Logging(JavaPlugin p){
		this.p = p;
		this.debug = null;
		this.silent = null;
		this.log = null;
		Logging.cfg = null;
	}

	public void init(Configuration cfg, String debug, String silent){
		this.debug = debug;
		this.silent = silent;
		Logging.cfg = cfg;
		@SuppressWarnings("unused")
		Logger log = p.getLogger();
		in = true;
	}
	*/

	private boolean checkInit(){
		if (!p.equals(null))
			return true;
		return false;
	}

	public void debug(String i){
		if (checkInit()){
			if (!cfg.equals(null)){
				if (!debug.equals(null)){
					if (cfg.getBoolean(debug, true))
						if (!silent.equals(null)){
							if (cfg.getBoolean(silent, false))
								log.info("[Debug] " + i);
						}else
							log.info("[Debug] " + i);
				}else if (!silent.equals(null)){
					if (cfg.getBoolean(silent, false))
						log.info("[Debug] " + i);
				}else
					log.info("[Debug] " + i);
			}else
				log.info("[Debug] " + i);
		}else
			log.warning("[sSuiteLib] Class 'Logging' was not initialized properly.");
	}

	public void info(String i){
		if (checkInit()){
			if (!cfg.equals(null)){
				if (!silent.equals(null)){
					if (cfg.getBoolean(silent, false))
						log.info(i);
				}else
					log.info(i);
			}else
				log.info(i);
		}else
			log.warning("[sSuiteLib] Class 'Logging' was not initialized properly.");
	}

	public void warning(String i){
		if (checkInit()){
			if (!cfg.equals(null)){
				if (!silent.equals(null)){
					if (cfg.getBoolean(silent, false))
						log.warning(i);
				}else
					log.warning(i);
			}else
				log.warning(i);
		}else
			log.warning("[sSuiteLib] Class 'Logging' was not initialized properly.");
	}

	public void severe(String i){
		if (checkInit())
			if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					log.severe(i);
			}else
				log.severe(i);
		else
			log.warning("[sSuiteLib] Class 'Logging' was not initialized properly.");
	}

	public void fine(String i){
		if (checkInit())
			if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					log.fine(i);
			}else
				log.fine(i);
		else
			log.warning("[sSuiteLib] Class 'Logging' was not initialized properly.");
	}

	public void finer(String i){
		if (checkInit())
			if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					log.finer(i);
			}else
				log.finer(i);
		else
			log.warning("[sSuiteLib] Class 'Logging' was not initialized properly.");
	}

	public void finest(String i){
		if (checkInit())
			if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					log.finest(i);
			}else
				log.finest(i);
		else
			log.warning("[sSuiteLib] Class 'Logging' was not initialized properly.");
	}

	public void config(String i){
		if (checkInit())
			if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					log.config(i);
			}else
				log.config(i);
		else
			log.warning("[sSuiteLib] Class 'Logging' was not initialized properly.");
	}
}
