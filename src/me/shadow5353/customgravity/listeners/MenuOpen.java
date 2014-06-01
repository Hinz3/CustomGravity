package me.shadow5353.customgravity.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuOpen implements Listener{
	
	public void onPlayerInteract (PlayerInteractEvent e){
		ItemStack stick = new ItemStack(Material.STICK, 1);
        ItemMeta stickmeta = stick.getItemMeta();
        stickmeta.setDisplayName(ChatColor.DARK_PURPLE + "Gravity Chooser");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Right click to change your gravity");
        stickmeta.setLore(lore);
        stick.setItemMeta(stickmeta);
		if(!(e.getAction() == Action.RIGHT_CLICK_AIR)) return;
		if(!(e.getItem().equals(stick))) return;
		final Player p = e.getPlayer();
		
		GravityMenu.show(p);
		
	}

}
