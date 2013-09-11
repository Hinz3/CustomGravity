package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;
import me.shadow5353.shadowpack.cmd.SubCommand;

import org.bukkit.entity.Player;

public class cg1 extends SubCommand{ // /cg 1

	public void onCommand(Player p, String[] args) {
		if(!(p.hasPermission("customgravity.1"))){
			MessageManager.getInstance().severe(p, "You don't have the permission");
		}
		MessageManager.getInstance().good(p, "Gravity set to 1");
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