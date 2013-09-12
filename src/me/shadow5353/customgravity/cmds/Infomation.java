package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class Infomation extends SubCommand{
	
	PluginDescriptionFile pdf;
	
	public void onCommand(Player p, String[] args) {
		MessageManager.getInstance().info(p, "BukkitDev: " + ChatColor.GOLD + "http://bit.ly/Custom-gravity");
		MessageManager.getInstance().info(p, "Github: " + ChatColor.GOLD + "http://bit.ly/custom-gravity-github");
		MessageManager.getInstance().info(p, "Version: " + ChatColor.GOLD + "0.3");
		MessageManager.getInstance().info(p, "Made by: " + ChatColor.GOLD + "shadow5353");
		MessageManager.getInstance().info(p, "Request by: " + ChatColor.GOLD + "Baker_san");
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
