package me.shadow5353.customgravity.listeners;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.SettingsManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Worlds implements Listener{
	
	@EventHandler
	public void onPlayerChangedWorld(PlayerChangedWorldEvent e){
		if (SettingsManager.getInstance().getConfig().getStringList("gravity.0").contains(e.getPlayer().getWorld().getName())){
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			MessageManager.getInstance().good(e.getPlayer(), "You are on a Normal Gravity world");
		}
		else if (!(SettingsManager.getInstance().getConfig().getStringList("gravity.0").contains(e.getPlayer().getWorld().getName()))){
			
		}
		if (SettingsManager.getInstance().getConfig().getStringList("gravity.1").contains(e.getPlayer().getWorld().getName())){
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 0));
			MessageManager.getInstance().good(e.getPlayer(), "You are on a High Gravity world");
		}
		else if (!(SettingsManager.getInstance().getConfig().getStringList("gravity.1").contains(e.getPlayer().getWorld().getName()))){
			
		}
		if (SettingsManager.getInstance().getConfig().getStringList("gravity.2").contains(e.getPlayer().getWorld().getName())){
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 1));
			MessageManager.getInstance().good(e.getPlayer(), "You are on a High Gravity world");
		}
        else if (!(SettingsManager.getInstance().getConfig().getStringList("gravity.2").contains(e.getPlayer().getWorld().getName()))){
			
		}
		if (SettingsManager.getInstance().getConfig().getStringList("gravity.3").contains(e.getPlayer().getWorld().getName())){
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 2));
			MessageManager.getInstance().good(e.getPlayer(), "You are on a High Gravity world");
		}
        else if (!(SettingsManager.getInstance().getConfig().getStringList("gravity.3").contains(e.getPlayer().getWorld().getName()))){
			
		}
		if (SettingsManager.getInstance().getConfig().getStringList("gravity.4").contains(e.getPlayer().getWorld().getName())){
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 3));
			MessageManager.getInstance().good(e.getPlayer(), "You are on a High Gravity world");
		}
        else if (!(SettingsManager.getInstance().getConfig().getStringList("gravity.4").contains(e.getPlayer().getWorld().getName()))){
			
		}
		if (SettingsManager.getInstance().getConfig().getStringList("gravity.5").contains(e.getPlayer().getWorld().getName())){
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 4));
			MessageManager.getInstance().good(e.getPlayer(), "You are on a High Gravity world");
		}
        else if (!(SettingsManager.getInstance().getConfig().getStringList("gravity.5").contains(e.getPlayer().getWorld().getName()))){
			
		}
		if (SettingsManager.getInstance().getConfig().getStringList("gravity.-1").contains(e.getPlayer().getWorld().getName())){
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 0));
			MessageManager.getInstance().good(e.getPlayer(), "You are on a Low Gravity world");
		}
        else if (!(SettingsManager.getInstance().getConfig().getStringList("gravity.-1").contains(e.getPlayer().getWorld().getName()))){
			
		}
		if (SettingsManager.getInstance().getConfig().getStringList("gravity.-2").contains(e.getPlayer().getWorld().getName())){
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 1));
			MessageManager.getInstance().good(e.getPlayer(), "You are on a Low Gravity world");
		}
        else if (!(SettingsManager.getInstance().getConfig().getStringList("gravity.-2").contains(e.getPlayer().getWorld().getName()))){
			
		}
		if (SettingsManager.getInstance().getConfig().getStringList("gravity.-3").contains(e.getPlayer().getWorld().getName())){
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 2));
			MessageManager.getInstance().good(e.getPlayer(), "You are on a Low Gravity world");
		}
        else if (!(SettingsManager.getInstance().getConfig().getStringList("gravity.-3").contains(e.getPlayer().getWorld().getName()))){
			
		}
		if (SettingsManager.getInstance().getConfig().getStringList("gravity.-4").contains(e.getPlayer().getWorld().getName())){
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 3));
			MessageManager.getInstance().good(e.getPlayer(), "You are on a Low Gravity world");
		}
        else if (!(SettingsManager.getInstance().getConfig().getStringList("gravity.-4").contains(e.getPlayer().getWorld().getName()))){
			
		}
		if (SettingsManager.getInstance().getConfig().getStringList("gravity.-5").contains(e.getPlayer().getWorld().getName())){
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 4));
			MessageManager.getInstance().good(e.getPlayer(), "You are on a Low Gravity world");
		}
        else if (!(SettingsManager.getInstance().getConfig().getStringList("gravity.-5").contains(e.getPlayer().getWorld().getName()))){
			
		}
		
		
	}

}
