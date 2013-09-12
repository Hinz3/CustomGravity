package me.shadow5353.customgravity;

import java.util.ArrayList;
import java.util.Arrays;
import me.shadow5353.customgravity.cmds.cg0;
import me.shadow5353.customgravity.cmds.cg1;
import me.shadow5353.customgravity.cmds.cg2;
import me.shadow5353.customgravity.cmds.cg3;
import me.shadow5353.customgravity.cmds.cg4;
import me.shadow5353.customgravity.cmds.cg5;
import me.shadow5353.customgravity.cmds.cgn1;
import me.shadow5353.customgravity.cmds.cgn2;
import me.shadow5353.customgravity.cmds.cgn3;
import me.shadow5353.customgravity.cmds.cgn4;
import me.shadow5353.customgravity.cmds.cgn5;
import me.shadow5353.customgravity.cmds.SubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {

	private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();

	public void setup() {
		commands.add(new cgn5());
		commands.add(new cgn3());
		commands.add(new cgn2());
		commands.add(new cgn1());
		commands.add(new cgn4());
		commands.add(new cg0());
		commands.add(new cg1());
		commands.add(new cg2());
		commands.add(new cg3());
		commands.add(new cg4());
		commands.add(new cg5());

	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (!(sender instanceof Player)) {
			MessageManager.getInstance().severe(sender, "Only players can use Custom Gravity!");
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("customgravity")) {
			if (args.length == 0) {
				for (SubCommand c : commands) {
					MessageManager.getInstance().info(p, "/cg " + c.name() + " - " + c.info());
				}
				return true;
			}

			SubCommand target = get(args[0]);

			if (target == null) {
				MessageManager.getInstance().severe(p, "/cg " + args[0] + " is not a valid subcommand!");
				return true;
			}

			ArrayList<String> a = new ArrayList<String>();
			a.addAll(Arrays.asList(args));
			a.remove(0);
			args = a.toArray(new String[a.size()]);

			try {
				target.onCommand(p, args);
			}

			catch (Exception e) {
				MessageManager.getInstance().severe(p, "An error has occured: " + e.getCause());
				e.printStackTrace();
			}
			

		}

		return true;
	}

	private SubCommand get(String name) {
		for (SubCommand cmd : commands) {
			if (cmd.name().equalsIgnoreCase(name)) return cmd;
			for (String alias : cmd.aliases()) if (name.equalsIgnoreCase(alias)) return cmd;
		}
		return null;
	}
}