package com.shdow5353.listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class SignBreak implements Listener{
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e){
		if(e.getBlock().getState() instanceof Sign){
			Sign s = (Sign) e.getBlock().getState();
			if(s.getLine(0).equalsIgnoreCase(ChatColor.GOLD + "[CG]")){
				if(!(e.getPlayer().hasPermission("customgravity.sign.remove"))){
					e.setCancelled(true);
					e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
				}
				else if(e.getPlayer().hasPermission("customgravity.sign.remove")){
					e.setCancelled(false);
				}
			}
		}
	}
}