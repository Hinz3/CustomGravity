package dk.jacobhinze.CustomGravity.commands;

import dk.jacobhinze.CustomGravity.Message;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Jacob Hinze on 14-09-2016.
 */
public class set {

    public static void setGravity(Player player, int level) {
        if(!(player.hasPermission("customgravity.set"))) {
            Message.noPermissionMessage(player);
            return;
        }

        gravityLevels(player, level);
    }

    public static void setGravityTarget(Player player, Player target, int level) {
        if(!(player.hasPermission("customgravity.set.others"))) {
            Message.noPermissionMessage(player);
            return;
        }

        gravityLevels(target, level);
        Message.goodMessage(player, "You have changed " + target.getName() + " gravity!");
        Message.infoMessage(target, "");
    }

    private static void gravityLevels(Player player, int level) {
        Remove.removeEffects(player);
        String message = "Your gravity level have been changed to level ";
        switch (level) {
            case 1:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 0));
                message += "1";
                break;
            case 2:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 1));
                message += "2";
                break;
            case 3:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 2));
                message += "3";
                break;
            case 4:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 3));
                message += "4";
                break;
            case 5:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 4));
                message += "5";
                break;
            case -1:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 0));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 0));
                message += "-1";
                break;
            case -2:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 1));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 1));
                message += "-2";
                break;
            case -3:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 2));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 2));
                message += "-3";
                break;
            case -4:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 3));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 3));
                message += "-4";
                break;
            case -5:
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000, 4));
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000, 4));
                message += "-5";
                break;
            case -6:
                player.setFlying(true);
                message += "-6";
                break;
            default:
                Remove.removeEffects(player);
                break;
        }

        Message.goodMessage(player, message);
    }
}
