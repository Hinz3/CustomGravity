package tk.shadowdev.customgravity;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class mm {

	private mm() { }

	private static mm instance = new mm();

	public static mm getInstance() {
		return instance;
	}

	private String prefix = ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "] ";

	public void info(CommandSender s, String msg) {
		msg(s, ChatColor.YELLOW, msg);
	}
	public void cmd(CommandSender s, String msg) {
		msg(s, ChatColor.GOLD, msg);
	}
	public void g(CommandSender s, String msg) {
		msg(s, ChatColor.GOLD, msg);
	}

	public void severe(CommandSender s, String msg) {
		msg(s, ChatColor.RED, msg);
	}

	public void good(CommandSender s, String msg) {
		msg(s, ChatColor.GREEN, msg);
	}

	private void msg(CommandSender s, ChatColor color, String msg) {
		s.sendMessage(prefix + color + msg);
	}
}