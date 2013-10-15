package me.shadow5353.customgravity;

import java.io.IOException;

import me.shadow5353.customgravity.listeners.BlockWorlds;
import me.shadow5353.customgravity.listeners.SignBreak;
import me.shadow5353.customgravity.listeners.Signs;
import me.shadow5353.customgravity.listeners.Worlds;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomGravity extends JavaPlugin{
	
	@Override
	public void onEnable() {
		if(!(getServer().getOnlineMode())){
			this.setEnabled(false);
		}
		
		//MCStats
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}
		
		//Setup for settings manager
		SettingsManager.getInstance().setup(this);
		
		//Setup for CommandManager
		CommandManager cm = new CommandManager();
		cm.setup();
		getCommand("customgravity").setExecutor(cm);
		
		//Events
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new SignBreak(), this);
		pm.registerEvents(new BlockWorlds(), this);
		pm.registerEvents(new Signs(), this);
		pm.registerEvents(new Worlds(), this);
	}

}
