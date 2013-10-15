package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.SettingsManager;
import me.shadow5353.customgravity.cmds.SubCommand;
import me.shadow5353.customgravity.lib.GravityEffect;

import org.bukkit.entity.Player;

public class cgn5 extends SubCommand{

	public void onCommand(Player p, String[] args) {
		if(SettingsManager.getInstance().getConfig().getStringList("commands.gravity-levels.5").contains(p.getWorld().getName())){
			if(!(p.hasPermission("customgravity.5"))){
				MessageManager.getInstance().severe(p, "You don't have the permission");
			}
			else if(p.hasPermission("customgravity.5")){
				GravityEffect ge = new GravityEffect();
				ge.Level0(p);
				ge.Leveln5(p);
				MessageManager.getInstance().good(p, "Gravity set to 5");
			    }
			}else if (!(SettingsManager.getInstance().getConfig().getStringList("commands.gravity-levels.5").contains(p.getWorld().getName()))){
				MessageManager.getInstance().severe(p, "This command is disabled in this world!");
			}
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