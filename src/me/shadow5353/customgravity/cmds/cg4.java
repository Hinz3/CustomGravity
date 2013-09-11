package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.shadowpack.cmd.SubCommand;

import org.bukkit.entity.Player;

public class cg4 extends SubCommand{ // /cg 4

	public void onCommand(Player p, String[] args) {
		if(!(p.hasPermission("customgravity.4"))){
			MessageManager.getInstance().severe(p, "You don't have the permission");
		}
		MessageManager.getInstance().good(p, "Gravity set to 4");
	}

	public String name() {
		return "4";
	}

	public String info() {
		return "Sets the Gravity to 4";
	}

	public String[] aliases() {
		return new String[] { "4" };
	}
}