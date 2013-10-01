package me.shadow5353.customgravity.listeners;

import me.shadow5353.customgravity.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;


public class BlockWorlds implements Listener{
	
	@EventHandler
	public void onPlayerChangedWorld(PlayerChangedWorldEvent e){
	        if(SettingsManager.getInstance().getConfig().getString("per-world-remove").contains("true")){
	        	
	           e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
	           e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
	           e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
	        	
	        }     
	        else if(SettingsManager.getInstance().getConfig().getString("per-world-remove").contains("false")) return;
	        }
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		if(e.getPlayer().hasPermission("customgravity.admin")){
			if (SettingsManager.getInstance().getConfig().getString("per-world-remove").contains("false")){
				e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "] " + ChatColor.RED + "Per world remove effect is disabled!");
			}
		}
	}
}		
