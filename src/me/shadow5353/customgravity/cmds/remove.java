package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class remove extends SubCommand{

	public void onCommand(Player p, String[] args) {
		if(!(p.hasPermission("customgravity.gravity"))){
			MessageManager.getInstance().severe(p, "You don't have the permission");
		}
		MessageManager.getInstance().good(p, "Removed all potion effects");
		for (PotionEffect effect : p.getActivePotionEffects())
	        p.removePotionEffect(effect.getType());
	}

	public String name() {
		return "remove";
	}

	public String info() {
		return "Remove all potion effects";
	}

	public String[] aliases() {
		return new String[] { "remove" };
	}
}
