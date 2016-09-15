package dk.jacobhinze.CustomGravity.commands;

import dk.jacobhinze.CustomGravity.Main;
import dk.jacobhinze.CustomGravity.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

/**
 * Created by Jacob Hinze on 14-09-2016.
 */
public class Set {

    private static HashMap<Player, Integer> cooldownTime = new HashMap<>();
    private static HashMap<Player, BukkitRunnable> cooldownTask = new HashMap<>();


    /**
     * Set gravity for a player
     * @param player the player that will get changed gravity effects
     * @param level the gravity level
     */
    public static void setGravity(Player player, String level) {
        if(isInCooldown(player)) {
            Message.errorMessage(player, "You have to wait " + getCooldown(player) + " seconds before you can use this command!");
            return;
        }
        gravityLevels(player, level, player);
    }

    /**
     * Sets another players gravity
     * @param sender the sender that sends the command
     * @param target the target that will get changed gravity effects
     * @param level the gravity level
     */
    public static void setGravityTarget(Player sender, Player target, String level) {
        if(isInCooldown(sender)) {
            Message.errorMessage(sender, "You have to wait " + getCooldown(sender) + " seconds before you can use this command!");
            return;
        }

        gravityLevels(target, level, sender);
    }

    /**
     * Set gravity effects after levels
     * @param player the player that will get the effects
     * @param level the level of effects it will add to the player
     * @param sender who send the command and receive error message.
     */
    private static void gravityLevels(Player player, String level, Player sender) {
        String message = "Your gravity level have been changed to level " + level;
        boolean done = false;
        switch (level) {
            case "1":
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 0));
                done = true;
                break;
            case "2":
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 1));
                done = true;
                break;
            case "3":
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 2));
                done = true;
                break;
            case "4":
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 3));
                done = true;
                break;
            case "5":
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 4));
                done = true;
                break;
            case "-1":
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 0));
                done = true;
                break;
            case "-2":
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 1));
                done = true;
                break;
            case "-3":
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 2));
                done = true;
                break;
            case "-4":
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 3));
                done = true;
                break;
            case "-5":
                Remove.removeEffects(player);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 4));
                done = true;
                break;
            default:
                Message.errorMessage(sender, "This gravity effect level does not exists!");
                break;
        }
        if(done) {
            Message.goodMessage(player, message);
            putInCooldown(sender);
        }
    }

    /**
     * Set a player into cooldown
     * @param player the player that will get cooldown
     *
     */
    public static void putInCooldown(Player player) {
        cooldownTime.put(player, Main.getPlugin().getConfig().getInt("cooldown"));
        cooldownTask.put(player, new BukkitRunnable() {
            @Override
            public void run() {
                cooldownTime.put(player, cooldownTime.get(player) -1);
                if(cooldownTime.get(player) == 0) {
                    cooldownTime.remove(player);
                    cooldownTask.remove(player);
                    cancel();
                }
            }
        });

        cooldownTask.get(player).runTaskTimer(Main.getPlugin(), 20, 20);
    }

    /**
     * Get the cooldown for a player
     * @param player the player who have cooldown
     * @return the number of seconds
     */
    public static int getCooldown(Player player) {
        return cooldownTime.get(player);
    }

    /**
     * Check if the player have a cooldown
     * @param player the player that will get checked
     * @return the player is in cooldown or not
     */
    public static boolean isInCooldown(Player player) {
        if(cooldownTime.containsKey(player)) {
            return true;
        }

        return false;
    }
}

