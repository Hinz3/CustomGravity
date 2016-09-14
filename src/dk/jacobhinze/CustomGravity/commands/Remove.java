package dk.jacobhinze.CustomGravity.commands;

import dk.jacobhinze.CustomGravity.Message;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Jacob Hinze on 14-09-2016.
 */
public class Remove {

    /**
     * Remove gravity effects for a player
     * @param player the sender that will
     */
    public static void removeEffects(Player player) {
        if(!player.hasPermission("customgravity.remove")) {
            Message.noPermissionMessage(player);
            return;
        }

        player.removePotionEffect(PotionEffectType.SPEED);
        player.removePotionEffect(PotionEffectType.JUMP);
        player.removePotionEffect(PotionEffectType.SLOW);
        player.setFlying(false);
        return;
    }

    public static void removeEffectsForTarget(Player player, Player target) {
        if(!player.hasPermission("customgravity.remove.other")) {
            Message.noPermissionMessage(player);
            return;
        }

        if(target.equals(null)) {
            Message.errorMessage(player, target + " this player do not exist!");
            return;
        }

        target.removePotionEffect(PotionEffectType.SPEED);
        target.removePotionEffect(PotionEffectType.SLOW);
        target.removePotionEffect(PotionEffectType.JUMP);
        target.setFlying(false);
        return;
    }
}
