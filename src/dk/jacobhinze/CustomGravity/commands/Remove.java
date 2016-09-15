package dk.jacobhinze.CustomGravity.commands;

import dk.jacobhinze.CustomGravity.Message;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Jacob Hinze on 14-09-2016.
 */
public class Remove {

    /**
     * Remove gravity effects for a player
     * @param player the sender
     */
    public static void removeEffects(Player player) {

        player.removePotionEffect(PotionEffectType.SPEED);
        player.removePotionEffect(PotionEffectType.JUMP);
        player.removePotionEffect(PotionEffectType.SLOW);
        return;
    }

    /**
     * Remove gravity effects for another player
     * @param player the player that send the command
     * @param target the target that will get removed effects
     */
    public static void removeEffectsForTarget(Player player, Player target) {

        if(target.equals(null)) {
            Message.errorMessage(player, target + " this player do not exist!");
            return;
        }

        target.removePotionEffect(PotionEffectType.SPEED);
        target.removePotionEffect(PotionEffectType.SLOW);
        target.removePotionEffect(PotionEffectType.JUMP);
        return;
    }
}
