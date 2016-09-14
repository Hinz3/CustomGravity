package dk.jacobhinze.CustomGravity.commands;
/**
 * Created by Jacob on 14-09-2016.
 */

import dk.jacobhinze.CustomGravity.Main;
import dk.jacobhinze.CustomGravity.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;

/**
 * Created by Jacob Hinze on 14-09-2016.
 */
public class Set {

    public static ArrayList<Player> cooldown = new ArrayList<Player>();

    public static void setGravity(Player player, int level) {
        if(cooldown.contains(player)) {
            Message.errorMessage(player, "");
        }

        gravityLevels(player, level, player);
    }

    public static void setGravityTarget(Player player, Player target, int level) {
        if(!(player.hasPermission("customgravity.set.others"))) {
            Message.noPermissionMessage(player);
            return;
        }

        gravityLevels(target, level, player);
        Message.goodMessage(player, "You have changed " + target.getName() + " gravity!");
        Message.infoMessage(target, "Your gravity was changed by " + target.getName());
    }

    /**
     * Set gravity effects after levels
     * @param player the player that will get the effects
     * @param level the level of effects it will add to the player
     * @param sender who send the command and receive error message.
     */
    private static void gravityLevels(Player player, int level, Player sender) {
        String message = "Your gravity level have been changed to level ";
        boolean done = false;
        switch (level) {
            case 1:
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 0));
                message += "1";
                done = true;
                break;
            case 2:
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 1));
                message += "2";
                done = true;
                break;
            case 3:
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 2));
                message += "3";
                done = true;
                break;
            case 4:
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 3));
                message += "4";
                done = true;
                break;
            case 5:
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 4));
                message += "5";
                done = true;
                break;
            case -1:
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 0));
                message += "-1";
                done = true;
                break;
            case -2:
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 1));
                message += "-2";
                done = true;
                break;
            case -3:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 2));
                message += "-3";
                done = true;
                break;
            case -4:
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 3));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 3));
                message += "-4";
                done = true;
                break;
            case -5:
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 4));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 4));
                message += "-5";
                done = true;
                break;
            case -6:
                Remove.removeEffects(player);
                player.setFlying(true);
                message += "-6";
                done = true;
                break;
            default:
                Message.errorMessage(sender, "This gravity effect level does not exists!");
                break;
        }
        if(done == true) {
            Message.goodMessage(player, message);
        }

        return;

    }

    public static void setCooldown(Player player) {
        cooldown.add(player);

        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable(){
            public void run(){
                cooldown.remove(player);
            }
        }, 10);
    }
}
