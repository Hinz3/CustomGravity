package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class remove extends SubCommand{

	public void onCommand(Player p, String[] args) {
		if(!(p.hasPermission("customgravity.remove"))){
			MessageManager.getInstance().severe(p, "You don't have the permission");
		}
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.removePotionEffect(PotionEffectType.SLOW);
		MessageManager.getInstance().good(p, "Removed all gravity effects!");
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
