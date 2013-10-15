package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.SettingsManager;
import me.shadow5353.customgravity.cmds.SubCommand;
import me.shadow5353.customgravity.lib.GravityEffect;

import org.bukkit.entity.Player;

public class cg1 extends SubCommand{

	public void onCommand(Player p, String[] args) {
		if(SettingsManager.getInstance().getConfig().getStringList("commands.gravity-levels.-1").contains(p.getWorld().getName())){
		if(!(p.hasPermission("customgravity.-1"))){
			MessageManager.getInstance().severe(p, "You don't have the permission");
		}
		else if(p.hasPermission("customgravity.-1")){
			GravityEffect ge = new GravityEffect();
			ge.Level0(p);
			ge.Levelp1(p);
			MessageManager.getInstance().good(p, "Gravity set to -1");
		    }
		}else if (!(SettingsManager.getInstance().getConfig().getStringList("commands.gravity-levels.-1").contains(p.getWorld().getName()))){
			MessageManager.getInstance().severe(p, "This command is disabled in this world!");
		}
	}

	public String name() {
		return "-1";
	}

	public String info() {
		return "Sets the Gravity to -1";
	}

	public String[] aliases() {
		return new String[] { "-1" };
	}
}