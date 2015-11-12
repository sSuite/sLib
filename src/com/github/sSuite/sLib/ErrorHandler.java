package com.github.sSuite.sLib;

import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.WriteAbortedException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public class ErrorHandler{

	JavaPlugin p;
	public static Configuration cfg;
	private final String silent;
	private final String debug;

	public ErrorHandler(JavaPlugin p, Configuration cfg, String debug, String silent){
		this.p = p;
		if (debug.equals(""))
			this.debug = null;
		else
			this.debug = debug;
		if (silent.equals(""))
			this.silent = null;
		else
			this.silent = silent;
		ErrorHandler.cfg = cfg;
	}

	public final void PST(NullPointerException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(IOException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(MalformedURLException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(FileNotFoundException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(CharConversionException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(InvalidClassException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(InvalidObjectException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(NotSerializableException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(WriteAbortedException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(ClassNotFoundException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(IllegalAccessException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(IllegalArgumentException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(IndexOutOfBoundsException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(NoRouteToHostException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(UnknownHostException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(SecurityException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}

	public final void PST(NoSuchMethodException e){
		if (!cfg.equals(null))
			if (!debug.equals(null)){
				if (cfg.getBoolean(debug, true))
					if (!silent.equals(null)){
						if (cfg.getBoolean(silent, false))
							e.printStackTrace();
					}else
						e.printStackTrace();
			}else if (!silent.equals(null)){
				if (cfg.getBoolean(silent, false))
					e.printStackTrace();
			}else
				e.printStackTrace();
	}
}
