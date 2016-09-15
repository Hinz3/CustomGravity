package dk.jacobhinze.CustomGravity;

import dk.jacobhinze.CustomGravity.commands.Remove;
import dk.jacobhinze.CustomGravity.commands.Set;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Jacob Hinze on 14-09-2016.
 */
public class Main extends JavaPlugin {

    private static Main instance;

    public void onEnable() {
        // config
        saveDefaultConfig();

        instance = this;
    }

    public void onDisable() {

        //instance = null;
    }

    public static Main getPlugin() {
        return instance;
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
                Messages.commandList(player);
                return true;
            }

            if(args[0].equalsIgnoreCase("remove")){
                // Remove gravity effects
                if(args.length == 2) {
                    if(!player.hasPermission("customgravity.remove.other")) {
                        Message.noPermissionMessage(player);
                        return true;
                    }

                    Player target = Bukkit.getPlayer(args[1]);
                    Remove.removeEffectsForTarget(player, target);

                    Message.goodMessage(player, "You have changed the gravity effects for " + target.getName() + "!");
                    Message.infoMessage(target, player.getName() + " have removed your gravity effects!");
                    return true;
                }

                if(!player.hasPermission("customgravity.remove")) {
                    Message.noPermissionMessage(player);
                    return true;
                }
                Message.goodMessage(player, "All gravity effects have been removed!");
                Remove.removeEffects(player);
                return true;
            }

            if(args[0].equalsIgnoreCase("set")) {
                // set gravity effects

                if(!(args.length == 2)) {
                    Message.errorMessage(player, "You have to specify a gravity level!");
                    return true;
                }


                String gravityLevel = args[1];

                if(args.length == 3) {
                    if(!(player.hasPermission("customgravity.set.others"))) {
                        Message.noPermissionMessage(player);
                        return true;
                    }
                    Player target = Bukkit.getPlayer(args[2]);

                    Set.setGravityTarget(player, target, gravityLevel);

                    return true;
                }

                if(!(player.hasPermission("customgravity.set"))) {
                    Message.noPermissionMessage(player);
                    return true;
                }

                Set.setGravity(player, gravityLevel);
                return true;
            }

            if(args[0].equalsIgnoreCase("level")) {
                // show a list over levels
                if(!(player.hasPermission("customgravity.level"))) {
                    Message.noPermissionMessage(player);
                    return true;
                }

                Messages.levelListMessage(player);
                return true;
            }
            if(args[0].equalsIgnoreCase("info")) {
                // show information about the plugin
                if(!(player.hasPermission("customgravity.info"))) {
                    Message.noPermissionMessage(player);
                    return true;
                }

                Messages.informationMessage(player);
                return true;
            }

            if(args[0].equalsIgnoreCase("reload")) {
                // reload the plugin config
                if(!(player.hasPermission("customgravity.reload"))) {
                    Message.noPermissionMessage(player);
                    return true;
                }

                reloadConfig();
                Message.goodMessage(player, "The config.yml have been reloaded");
                return true;
            }

            Message.errorMessage(player, "That command does not exist!");
            return true;
        }

        return true;
    }
}
