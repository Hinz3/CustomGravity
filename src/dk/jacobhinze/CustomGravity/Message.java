package dk.jacobhinze.CustomGravity;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Created by Jacob Hinze on 14-09-2016.
 */
public class Message {

    private static String prefix = ChatColor.BLACK + "[" + ChatColor.DARK_RED + "CG" + ChatColor.BLACK + "] ";

    private static void msg(CommandSender s, ChatColor color, String msg) {
        s.sendMessage(prefix + color + msg);
    }

    /**
     * Send a info message to the sender
     * @param sender the sender the message will be sent to
     * @param message the message the sender will receive
     */

    public static void infoMessage(CommandSender sender, String message) {
        msg(sender, ChatColor.YELLOW, message);
    }

    /**
     * Send a good message to the sender
     * @param sender the sender the message will be sent to
     * @param message the message the sender will receive
     */

    public static void goodMessage(CommandSender sender, String message) {
        msg(sender, ChatColor.GREEN, message);
    }

    /**
     * Send a error message to the sender
     * @param sender the sender the message will be sent to
     * @param message the message the sender will receive
     */

    public static void errorMessage(CommandSender sender, String message) {
        msg(sender, ChatColor.DARK_RED, message);
    }

    /**
     * Send a specified message when the user got no permission
     * @param sender the sender the message will be sent to
     */

    public static void noPermissionMessage(CommandSender sender) {
        msg(sender, ChatColor.DARK_RED, "You do not have permission!");
    }
}
