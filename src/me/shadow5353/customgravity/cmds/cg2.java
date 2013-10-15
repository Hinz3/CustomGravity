package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.customgravity.SettingsManager;
import me.shadow5353.customgravity.cmds.SubCommand;
import me.shadow5353.customgravity.lib.GravityEffect;

import org.bukkit.entity.Player;

public class cg2 extends SubCommand{

	public void onCommand(Player p, String[] args) {
		if(SettingsManager.getInstance().getConfig().getStringList("commands.gravity-levels.-2").contains(p.getWorld().getName())){
			if(!(p.hasPermission("customgravity.-2"))){
				MessageManager.getInstance().severe(p, "You don't have the permission");
			}
			else if(p.hasPermission("customgravity.-2")){
				GravityEffect ge = new GravityEffect();
				MessageManager.getInstance().good(p, "Gravity set to -2");
				ge.Level0(p);
				ge.Levelp2(p);
			    }
			}else if (!(SettingsManager.getInstance().getConfig().getStringList("commands.gravity-levels.-2").contains(p.getWorld().getName()))){
				MessageManager.getInstance().severe(p, "This command is disabled in this world!");
			}
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