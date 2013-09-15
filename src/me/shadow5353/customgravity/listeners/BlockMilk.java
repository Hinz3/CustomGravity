package me.shadow5353.customgravity.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEvent;

public class BlockMilk implements Listener{
	
	@EventHandler
	public void onPlayerBucket(PlayerBucketEvent e){
		e.getBucket().compareTo(Material.MILK_BUCKET);
	}

}
