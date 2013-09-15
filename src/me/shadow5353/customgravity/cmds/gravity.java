package me.shadow5353.customgravity.cmds;

import me.shadow5353.customgravity.MessageManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class gravity extends SubCommand{

	public void onCommand(Player p, String[] args) {
		if(!(p.hasPermission("customgravity.gravity"))){
			MessageManager.getInstance().severe(p, "You don't have the permission");
		}
		else if(p.hasPermission("customgravity.0")){
			/*Inventory pi = p.getInventory(); 
			ItemStack Gravity = new ItemStack(Material.COMPASS, 1);
			ItemMeta GCMeta = Gravity.getItemMeta();
			GCMeta.setDisplayName(ChatColor.GOLD + "Gravity Selector");
			Gravity.setItemMeta(GCMeta);
			pi.addItem(Gravity);
			MessageManager.getInstance().info(p, "You can also use the Gravity Selector to change you gravity");
			
			This will be added in 0.4
			 */
			MessageManager.getInstance().g(p, "Level 0" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level works like /gc remove.");
			MessageManager.getInstance().g(p, "Level 1" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed and jump.");
			MessageManager.getInstance().g(p, "Level 2" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 2.");
			MessageManager.getInstance().g(p, "Level 3" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 3.");
			MessageManager.getInstance().g(p, "Level 4" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 4.");
			MessageManager.getInstance().g(p, "Level 5" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 5.");
			MessageManager.getInstance().g(p, "Level -1" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow.");
			MessageManager.getInstance().g(p, "Level -2" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 2.");
			MessageManager.getInstance().g(p, "Level -3" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 3.");
			MessageManager.getInstance().g(p, "Level -4" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 4.");
			MessageManager.getInstance().g(p, "Level -5" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 5.");
			MessageManager.getInstance().info(p, "To get a gravity level use " + ChatColor.GOLD + "/cg [gravity level]");
		}
	}

	public String name() {
		return "gravity";
	}

	public String info() {
		return "This command shows all gravity levels";
	}

	public String[] aliases() {
		return new String[] { "g" };
	}

}
