package me.shadow5353.customgravity;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomGravity extends JavaPlugin{
	
	SettingsManager settings = SettingsManager.getInstance();
	
	@Override
	public void onEnable() {
		settings.setup(this);
		saveDefaultConfig();
		CommandManager cm = new CommandManager();
		cm.setup();
		getCommand("customgravity").setExecutor(cm);
	}

}
