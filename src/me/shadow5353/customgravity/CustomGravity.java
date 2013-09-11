package me.shadow5353.customgravity;

import me.shadow5353.customgravity.listener.JoinMessage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomGravity extends JavaPlugin{
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		SettingsManager.getInstance().setup(this);
		CommandManager cm = new CommandManager();
		cm.setup();
		getCommand("customgravity").setExecutor(cm);
		Bukkit.getServer().getPluginManager().registerEvents(new JoinMessage(), this);
		this.saveConfig();
	}

}
