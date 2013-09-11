package me.shadow5353.customgravity.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener{
	
	@EventHandler
	public void onPlyerJoin(PlayerJoinEvent e){
		e.getPlayer().sendMessage("");
	}
}
