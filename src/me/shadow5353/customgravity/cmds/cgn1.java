package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.cmds.SubCommand;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class cgn1 extends SubCommand{

	public void onCommand(Player p, String[] args) {
		if(!(p.hasPermission("customgravity.1"))){
			MessageManager.getInstance().severe(p, "You don't have the permission");
		}else if(p.hasPermission("customgravity.1")){
			p.removePotionEffect(PotionEffectType.SPEED);
			p.removePotionEffect(PotionEffectType.JUMP);
			p.removePotionEffect(PotionEffectType.SLOW);
			MessageManager.getInstance().good(p, "Gravity set to 1");
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 0));
		}
	}

	public String name() {
		return "1";
	}

	public String info() {
		return "Sets the Gravity to 1";
	}

	public String[] aliases() {
		return new String[] { "1" };
	}
}