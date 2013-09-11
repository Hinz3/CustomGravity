package me.shadow5353.customgravity;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomGravity extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		this.getConfig().options().copyDefaults(true);
		SettingsManager.getInstance().setup(this);
		CommandManager cm = new CommandManager();
		cm.setup();
		getCommand("customgravity").setExecutor(cm);
		saveConfig();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	@EventHandler
	public void onPlyerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		p.sendMessage(ChatColor.GOLD + getConfig().getString("Join"));
	}

}
