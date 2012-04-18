package tk.nekotech.sSuiteLib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class ErrorHandling{

	JavaPlugin p;
	public static Configuration cfg;
	private final String silent;
	private final String debug;

	ErrorHandling(JavaPlugin p, Configuration cfg, String debug, String silent){
		this.p = p;
		this.debug = debug;
		this.silent = silent;
		ErrorHandling.cfg = cfg;
	}

	public final void PST(IOException e){
		if (!debug.equals("")){
			if (cfg.getBoolean(debug, true))
				if (!silent.equals("")){
					if (cfg.getBoolean(silent, false))
						e.printStackTrace();
				}else
					e.printStackTrace();
		}else if (!silent.equals("")){
			if (cfg.getBoolean(silent, false))
				e.printStackTrace();
		}else
			e.printStackTrace();
	}

	public final void PST(MalformedURLException e){
		if (!debug.equals("")){
			if (cfg.getBoolean(debug, true))
				if (!silent.equals("")){
					if (cfg.getBoolean(silent, false))
						e.printStackTrace();
				}else
					e.printStackTrace();
		}else if (!silent.equals("")){
			if (cfg.getBoolean(silent, false))
				e.printStackTrace();
		}else
			e.printStackTrace();
	}

	public final void PST(FileNotFoundException e){
		if (!debug.equals("")){
			if (cfg.getBoolean(debug, true))
				if (!silent.equals("")){
					if (cfg.getBoolean(silent, false))
						e.printStackTrace();
				}else
					e.printStackTrace();
		}else if (!silent.equals("")){
			if (cfg.getBoolean(silent, false))
				e.printStackTrace();
		}else
			e.printStackTrace();
	}
}
