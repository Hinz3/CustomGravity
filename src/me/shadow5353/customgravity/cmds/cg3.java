package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.SettingsManager;
import me.shadow5353.customgravity.cmds.SubCommand;
import me.shadow5353.customgravity.lib.GravityEffect;

import org.bukkit.entity.Player;

public class cg3 extends SubCommand{

	public void onCommand(Player p, String[] args) {
		if(SettingsManager.getInstance().getConfig().getStringList("commands.gravity-levels.-3").contains(p.getWorld().getName())){
			if(!(p.hasPermission("customgravity.-3"))){
				MessageManager.getInstance().severe(p, "You don't have the permission");
			}
			else if(p.hasPermission("customgravity.-3")){
				GravityEffect ge = new GravityEffect();
				ge.Level0(p);
				ge.Levelp3(p);
				MessageManager.getInstance().good(p, "Gravity set to -3");
			    }
			}else if (!(SettingsManager.getInstance().getConfig().getStringList("commands.gravity-levels.-3").contains(p.getWorld().getName()))){
				MessageManager.getInstance().severe(p, "This command is disabled in this world!");
			}
		}

	public String name() {
		return "-3";
	}

	public String info() {
		return "Sets the Gravity to -3";
	}

	public String[] aliases() {
		return new String[] { "-3" };
	}
}