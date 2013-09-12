package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.cmds.SubCommand;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class cg5 extends SubCommand{ // /cg 5

	public void onCommand(Player p, String[] args) {
		if(!(p.hasPermission("customgravity.5"))){
			MessageManager.getInstance().severe(p, "You don't have the permission");
		}
		MessageManager.getInstance().good(p, "Gravity set to 5");
		for(PotionEffect po : p.getActivePotionEffects()){
			if(po.getType() == PotionEffectType.SPEED){
				for (PotionEffect effect : p.getActivePotionEffects())
			        p.removePotionEffect(effect.getType());
			}
			if(po.getType() == PotionEffectType.JUMP){
				for (PotionEffect effect : p.getActivePotionEffects())
			        p.removePotionEffect(effect.getType());
			}
			if(po.getType() == PotionEffectType.SLOW){
				for (PotionEffect effect : p.getActivePotionEffects())
			        p.removePotionEffect(effect.getType());
			}
			}
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 4));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
	}

	public String name() {
		return "5";
	}

	public String info() {
		return "Sets the Gravity to 5";
	}

	public String[] aliases() {
		return new String[] { "5" };
	}
}