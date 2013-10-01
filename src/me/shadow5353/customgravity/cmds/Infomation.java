package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class Infomation extends SubCommand{
	
	PluginDescriptionFile pdf = Bukkit.getPluginManager().getPlugin("Custom Gravity").getDescription();

	
	public void onCommand(Player p, String[] args) {
		
		if(SettingsManager.getInstance().getConfig().getStringList("commands.info").contains(p.getWorld().getName())){
		MessageManager.getInstance().info(p, "BukkitDev: " + ChatColor.GOLD + "http://bit.ly/Custom-gravity");
		MessageManager.getInstance().info(p, "Github: " + ChatColor.GOLD + "http://bit.ly/custom-gravity-github");
		MessageManager.getInstance().info(p, "Version: " + ChatColor.GOLD + pdf.getVersion());
		MessageManager.getInstance().info(p, "Made by: " + ChatColor.GOLD + "shadow5353");
		MessageManager.getInstance().info(p, "Twitter: " + ChatColor.GOLD + "http://bit.ly/devcustom-gravity");
		MessageManager.getInstance().info(p, "Request by: " + ChatColor.GOLD + "Baker_san");
		
		}
		
		else if(!(SettingsManager.getInstance().getConfig().getStringList("commands.info").contains(p.getWorld().getName()))){
			MessageManager.getInstance().severe(p, "This command is disabled in this world!");
		}
	}
	
	public String name() {
		return "info";
	}
	
	public String info() {
		return "Info about the plugin";
	}
	
	public String[] aliases(){
		return new String[] { "info"};
	}

}
