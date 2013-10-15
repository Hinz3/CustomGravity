package me.shadow5353.customgravity.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEvent;
import org.bukkit.potion.PotionEffectType;

public class BlockMilk implements Listener{
	
	@EventHandler
	public void onPlayerBucket(PlayerBucketEvent e){
		if(e.getPlayer().hasPotionEffect(PotionEffectType.SPEED)){
			
		}
	}
}
