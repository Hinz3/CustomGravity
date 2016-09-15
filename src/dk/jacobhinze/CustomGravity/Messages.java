package dk.jacobhinze.CustomGravity;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Jacob Hinze on 15-09-2016.
 */
public class Messages {

    /**
     * Shows a list of commands with use of the commandConstructor method.
     * @param player the player that will receive the list
     */
    public static void commandList(Player player) {
        player.sendMessage(ChatColor.GOLD + "------------------------------");
        commandConstructor(player, "cg", "Show a list of commandConstructor");
        commandConstructor(player, "cg set [Gravity Level] (Player)", "Change your gravity on you or a player");
        commandConstructor(player, "cg remove", "Remove all the gravity effects");
        commandConstructor(player, "cg level", "Show a list of gravity levels");
        commandConstructor(player, "cg info", "Show information about the plugin");

        if(player.hasPermission("customgravity.admin")) {
            commandConstructor(player, "cg reload", "Reload the plugins config");
        }

        player.sendMessage(ChatColor.GOLD + "------------------------------");
    }

    /**
     * Show a commandConstructor
     * @param player the sender that will receive messages
     * @param command the commandConstructor
     * @param description the description to the commandConstructor
     */
    private static void commandConstructor(Player player, String command, String description) {
        player.sendMessage(ChatColor.GOLD + "/" + command + ChatColor.BLACK + " : " + ChatColor.YELLOW + description);
    }

    public static void informationMessage(Player player) {
        player.sendMessage(ChatColor.GOLD + "------------------------------");
        player.sendMessage(ChatColor.GOLD + "Plugin Name: " + ChatColor.YELLOW + Main.getPlugin().getDescription().getName());
        player.sendMessage(ChatColor.GOLD + "Plugin version: " + ChatColor.YELLOW + Main.getPlugin().getDescription().getVersion());
        player.sendMessage(ChatColor.GOLD + "Plugin author: shadow5353");
        player.sendMessage(ChatColor.GOLD + "Plugin Website: " + ChatColor.YELLOW + Main.getPlugin().getDescription().getWebsite());
        player.sendMessage(ChatColor.GOLD + "------------------------------");
    }

    public static void levelListMessage(Player player) {
        player.sendMessage(ChatColor.GOLD + "------------------------------");
        levelListConstructor(player, "0", "Remove all effects");
        levelListConstructor(player, "1", "Add slow 1");
        levelListConstructor(player, "2", "Add slow 2");
        levelListConstructor(player, "3", "Add slow 3");
        levelListConstructor(player, "4", "Add slow 4");
        levelListConstructor(player, "5", "Add slow 5");
        levelListConstructor(player, "-1", "Add speed 1 & jump 1");
        levelListConstructor(player, "-2", "Add speed 1 & jump 2");
        levelListConstructor(player, "-3", "Add speed 1 & jump 3");
        levelListConstructor(player, "-4", "Add speed 1 & jump 4");
        levelListConstructor(player, "-5", "Add speed 1 & jump 5");
        player.sendMessage(ChatColor.GOLD + "------------------------------");
    }

    private static void levelListConstructor(Player player, String level, String description) {
        player.sendMessage(ChatColor.GOLD + "Level: " + level + ChatColor.BLACK + " : " + ChatColor.YELLOW + description);
    }
}
