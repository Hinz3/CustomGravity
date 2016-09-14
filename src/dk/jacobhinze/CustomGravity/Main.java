package dk.jacobhinze.CustomGravity;

import dk.jacobhinze.CustomGravity.commands.Remove;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Jacob Hinze on 14-09-2016.
 */
public class Main extends JavaPlugin {

    public void onEnable() {
        // todo config
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            Message.errorMessage(sender, "Only a player can use Custom Gravity");
            return false;
        }

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("customgravity")) {
            if(args.length == 0) {
                commandList(player);
                return true;
            }

            if(args[0].equalsIgnoreCase("remove")){

                if(args.length == 2) {
                    Player target = Bukkit.getPlayer(args[1]);
                    Remove.removeEffectsForTarget(player, target);

                    Message.goodMessage(player, "You have changed the gravity effects for " + target.getName() + "!");
                    Message.infoMessage(target, player.getName() + " have removed your gravity effects!");
                    return true;
                }

                Remove.removeEffects(player);
                Message.goodMessage(player, "All gravity effects have been removed!");
                return true;
            }

            if(args[0].equalsIgnoreCase("set")) {
                // todo gravity effects

                if(args.length == 2) {
                    Player target = Bukkit.getPlayer(args[1]);

                    return true;
                }
            }

            if(args[0].equalsIgnoreCase("level")) {
                // todo show a list over levels
            }

            if(args[0].equalsIgnoreCase("info")) {
                // todo show information about the plugin
            }

            if(args[0].equalsIgnoreCase("reload")) {
                // todo reload the plugin config
            }
        }

        return true;
    }

    private static void commandList(CommandSender sender) {
        sender.sendMessage(ChatColor.GOLD + "------------------------------");
        command(sender, "cg", "Show a list of command");
        command(sender, "cg set [Gravity Level] (Player)", "Change your gravity on you or a player");
        command(sender, "cg remove", "Remove all the gravity effects");
        command(sender, "cg level", "Show a list of gravity levels");
        command(sender, "cg info", "Show information about the plugin");

        if(sender.hasPermission("customgravity.admin")) {
            command(sender, "cg reload", "Reload the plugins config");
        }

        sender.sendMessage(ChatColor.GOLD + "------------------------------");
    }

    private static void command(CommandSender sender, String command, String description) {
        sender.sendMessage(ChatColor.GOLD + "/" + command + ChatColor.BLACK + " : " + ChatColor.YELLOW + description);
    }
}
