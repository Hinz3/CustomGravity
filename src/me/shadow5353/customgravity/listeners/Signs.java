package me.shadow5353.customgravity.listeners;


import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Signs implements Listener{
	
//Sign color format "§"
	
/*
 * To-Do:
 * Add permission
 * Test the signs
 */
	 
    @EventHandler
    public void onSignChange(SignChangeEvent e) {
            if (e.getLine(0).equalsIgnoreCase("[cg]")) {
                    e.setLine(0, "§6[CustomGravity]");
                    e.setLine(1, "§2Set");
            }
            else if (e.getLine(2).equalsIgnoreCase("[-5]")) {
            	e.setLine(2, "§2Gravity -5");
            }
            else if (e.getLine(2).equalsIgnoreCase("[-4]")) {
            	e.setLine(2, "§2Gravity -4");
            }
            else if (e.getLine(2).equalsIgnoreCase("[-3]")) {
            	e.setLine(2, "§2Gravity -3");
            }
            else if (e.getLine(2).equalsIgnoreCase("[-2]")) {
            	e.setLine(2, "§2Gravity -2");
            }
            else if (e.getLine(2).equalsIgnoreCase("[-1]")) {
            	e.setLine(2, "§2Gravity -1");
            }
            else if (e.getLine(2).equalsIgnoreCase("[0]")) {
            	e.setLine(2, "§2Gravity 0");
            }
            else if (e.getLine(2).equalsIgnoreCase("[1]")) {
            	e.setLine(2, "§2Gravity 1");
            }
            else if (e.getLine(2).equalsIgnoreCase("[2]")) {
            	e.setLine(2, "§2Gravity 2");
            }
            else if (e.getLine(2).equalsIgnoreCase("[3]")) {
            	e.setLine(2, "§2Gravity 3");
            }
            else if (e.getLine(2).equalsIgnoreCase("[4]")) {
            	e.setLine(2, "§2Gravity 4");
            }
            else if (e.getLine(2).equalsIgnoreCase("[5]")) {
            	e.setLine(2, "§2Gravity 5");
            }
    }
   
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
            if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
            if (e.getClickedBlock().getState() instanceof Sign) {
                    Sign s = (Sign) e.getClickedBlock().getState();
                    if(s.getLine(0).equalsIgnoreCase("§6[CustomGravity]")){
                    	if (s.getLine(2).equalsIgnoreCase("§2Gravity -5")){
                    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 4));
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
                    		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Gravity set to -5");
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2Gravity -4")){
                    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 3));
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
                    		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Gravity set to -4");
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2Gravity -3")){
                    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 2));
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
                    		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Gravity set to -3");
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2Gravity -2")){
                    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 1));
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
                    		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Gravity set to -2");
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2Gravity -1")){
                    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 0));
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
                    		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Gravity set to -1");
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2Gravity 0")){
                    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                    		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Gravity set to 0");
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2Gravity 1")){
                    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 0));
                    		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Gravity set to 1");
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2Gravity 2")){
                    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 1));
                    		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Gravity set to 2");
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2Gravity 3")){
                    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 2));
                    		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Gravity set to 3");
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2Gravity 4")){
                    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 3));
                    		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Gravity set to 4");
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2Gravity 5")){
                    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 4));
                    		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + "Gravity set to 5");
                    		
                    	}
                    }
            }
    }
}
