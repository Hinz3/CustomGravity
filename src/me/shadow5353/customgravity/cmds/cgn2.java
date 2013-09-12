package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.cmds.SubCommand;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class cgn2 extends SubCommand{ // /cg -2

	public void onCommand(Player p, String[] args) {
		if(!(p.hasPermission("customgravity.-2"))){
			MessageManager.getInstance().severe(p, "You don't have the permission");
		}
		MessageManager.getInstance().good(p, "Gravity set to -2");
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 1));
	}

	public String name() {
		return "-2";
	}

	public String info() {
		return "Sets the Gravity to -2";
	}

	public String[] aliases() {
		return new String[] { "-2" };
	}
}