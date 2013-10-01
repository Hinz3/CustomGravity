package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.SettingsManager;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class remove extends SubCommand{

	public void onCommand(Player p, String[] args) {
		if(SettingsManager.getInstance().getConfig().getStringList("commands.remove").contains(p.getWorld().getName())){
		if(!(p.hasPermission("customgravity.remove"))){
			MessageManager.getInstance().severe(p, "You don't have the permission");
		}
		else if(p.hasPermission("customgravity.remove")){
			p.removePotionEffect(PotionEffectType.SPEED);
			p.removePotionEffect(PotionEffectType.JUMP);
			p.removePotionEffect(PotionEffectType.SLOW);
			MessageManager.getInstance().good(p, "Removed all gravity effects!");
		}
		}

		else if(!(SettingsManager.getInstance().getConfig().getStringList("commands.remove").contains(p.getWorld().getName()))){
			MessageManager.getInstance().severe(p, "This command is disabled in this world!");
		}
	}

	public String name() {
		return "remove";
	}

	public String info() {
		return "Remove all gravity effects";
	}

	public String[] aliases() {
		return new String[] { "remove" };
	}
}
