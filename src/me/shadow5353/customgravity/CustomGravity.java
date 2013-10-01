package me.shadow5353.customgravity;

import java.io.IOException;

import me.shadow5353.customgravity.listeners.BlockWorlds;
import me.shadow5353.customgravity.listeners.SignBreak;
import me.shadow5353.customgravity.listeners.Signs;
import me.shadow5353.customgravity.listeners.Worlds;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomGravity extends JavaPlugin{
	
	@Override
	public void onEnable() {
		if(!(getServer().getOnlineMode())){
			this.setEnabled(false);
		}
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}
		SettingsManager.getInstance().setup(this);
		CommandManager cm = new CommandManager();
		cm.setup();
		getCommand("customgravity").setExecutor(cm);
		Bukkit.getServer().getPluginManager().registerEvents(new SignBreak(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BlockWorlds(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Signs(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Worlds(), this);
	}

}
