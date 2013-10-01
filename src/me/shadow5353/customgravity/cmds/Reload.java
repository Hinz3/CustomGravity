package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.SettingsManager;

import org.bukkit.entity.Player;

public class Reload extends SubCommand{
	
	public void onCommand(Player p, String[] args){
		if(p.hasPermission("customgravity.admin")){
			SettingsManager.getInstance().reloadConfig();
			MessageManager.getInstance().good(p, "Configuration has been reloaded!");
		}
		else if(!(p.hasPermission("customgravity.admin"))){
			MessageManager.getInstance().severe(p, "You don't have permission!");
		}
	}
	
	public String name() {
		return "reload";
	}
	
	public String info() {
		return "Reload the config";
	}
	
	public String[] aliases(){
		return new String[] { "r" };
	}

}
