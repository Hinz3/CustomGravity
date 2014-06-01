package me.shadow5353.customgravity.listeners;

import me.shadow5353.customgravity.MessageManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

public class GravityMenu implements Listener{
	
	private static Inventory inv;
    private ItemStack p0, p1, p2, p3, p4, p5, p6, n1, n2, n3, n4, n5;
    MessageManager msg = MessageManager.getInstance();
   
    public GravityMenu() {
    	inv = Bukkit.getServer().createInventory(null, 27, "Change your Gravity!");
    	p0 = createItem(DyeColor.WHITE, ChatColor.GRAY + "Level 0");
    	n1 = createItem(DyeColor.LIME, ChatColor.GREEN + "Level 1");
    	n2 = createItem(DyeColor.LIME, ChatColor.GREEN + "Level 2");
    	n3 = createItem(DyeColor.LIME, ChatColor.GREEN + "Level 3");
    	n4 = createItem(DyeColor.LIME, ChatColor.GREEN + "Level 4");
    	n5 = createItem(DyeColor.LIME, ChatColor.GREEN + "Level 5");
    	p1 = createItem(DyeColor.RED, ChatColor.RED + "Level -1");
    	p2 = createItem(DyeColor.RED, ChatColor.RED + "Level -2");
    	p3 = createItem(DyeColor.RED, ChatColor.RED + "Level -3");
    	p4 = createItem(DyeColor.RED, ChatColor.RED + "Level -4");
    	p5 = createItem(DyeColor.RED, ChatColor.RED + "Level -5");
    	p6 = createItem(DyeColor.RED, ChatColor.RED + "Level -6");
           
        
        }
   
    private ItemStack createItem(DyeColor dc, String name) {
        ItemStack i = new Wool(dc).toItemStack(1);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(name);
        i.setItemMeta(im);
        return i;
    }
   
    public static void show(Player p) {
        p.openInventory(inv);
    }
   
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
    	Player p = (Player) e.getWhoClicked();
    	if (!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
    	if (e.getCurrentItem().getItemMeta() == null) return;
    	if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Yes")) {
    		e.setCancelled(true);
    		e.getWhoClicked().closeInventory();
    		}
    	if (e.getCurrentItem().getItemMeta().getDisplayName().contains("No")) {
    		e.setCancelled(true);
    		e.getWhoClicked().closeInventory();
    		}
    	}

}
