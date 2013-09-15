package me.shadow5353.customgravity;


import me.shadow5353.customgravity.listeners.Signs;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomGravity extends JavaPlugin{
	
	@Override
	public void onEnable() {
		CommandManager cm = new CommandManager();
		cm.setup();
		getCommand("customgravity").setExecutor(cm);
		Bukkit.getServer().getPluginManager().registerEvents(new Signs(), this);
	}

}
