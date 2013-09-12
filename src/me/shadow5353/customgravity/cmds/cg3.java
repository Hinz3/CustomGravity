package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.cmds.SubCommand;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class cg3 extends SubCommand{ // /cg 3

	public void onCommand(Player p, String[] args) {
		if(!(p.hasPermission("customgravity.3"))){
			MessageManager.getInstance().severe(p, "You don't have the permission");
		}
		MessageManager.getInstance().good(p, "Gravity set to 3");
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 2));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
	}

	public String name() {
		return "3";
	}

	public String info() {
		return "Sets the Gravity to 3";
	}

	public String[] aliases() {
		return new String[] { "3" };
	}
}