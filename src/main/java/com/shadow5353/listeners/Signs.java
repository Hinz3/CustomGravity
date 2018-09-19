package com.shdow5353.listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Signs implements Listener{
	 
    @EventHandler
    public void onSignChange(SignChangeEvent e) {
    	if(e.getPlayer().hasPermission("customgravity.sign.create")) {
    		if(e.getLine(0).equalsIgnoreCase("[0]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "0");
    		}
    		else if(e.getLine(0).equalsIgnoreCase("[1]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "1");
    		}
    		else if(e.getLine(0).equalsIgnoreCase("[2]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "2");
    		}
    		else if(e.getLine(0).equalsIgnoreCase("[3]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "3");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[4]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "4");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[5]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "5");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[-1]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "-1");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[-2]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "-2");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[-3]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "-3");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[-4]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "-4");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[-5]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "-5");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[-6]")){
    			e.setLine(0, "[CG]");
    			e.setLine(1, "Set Gravity");
    			e.setLine(2, "-6");
    		}
    	    if(e.getLine(0).equalsIgnoreCase("[remove]")){
			    e.setLine(0, "[CG]");
			    e.setLine(1, "Remove");
			    e.setLine(2, "Gravity");
		}
    	}else if (!(e.getPlayer().hasPermission("customgravity.sign.create"))){
    		
    	}
    }
   
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
    	
            if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
            if (e.getClickedBlock().getState() instanceof Sign) {
                    Sign s = (Sign) e.getClickedBlock().getState();
                    if(s.getLine(0).equalsIgnoreCase("[CG]")){
                    	if (s.getLine(2).equalsIgnoreCase("-5")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.-5")){
                    			e.getPlayer().performCommand("cg -5");
                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.-5"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("-4")){
                    	    if(e.getPlayer().hasPermission("customgravity.sign.use.-4")){
                    			e.getPlayer().performCommand("cg -4");
                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.-4"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("-3")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.-3")){
                    			e.getPlayer().performCommand("cg -3");
                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.-3"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                                     		
                    	}else if(s.getLine(2).equalsIgnoreCase("-2")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.-2")){
                    			e.getPlayer().performCommand("cg -2");
                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.-2"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("-1")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.-1")){
                    			e.getPlayer().performCommand("cg -1");
                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.-1"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("0")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.0")){
                    			e.getPlayer().performCommand("cg 0");
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 0");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.0"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("1")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.1")){
                    			e.getPlayer().performCommand("cg 1");
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 1");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.1"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("2")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.2")){
                    			e.getPlayer().performCommand("cg 2");
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 2");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.2"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("3")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.3")){
                    			e.getPlayer().performCommand("cg 3");
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 3");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.2"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("4")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.4")){
                    			e.getPlayer().performCommand("cg 4");
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 4");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.1"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("5")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.5")){
                    			e.getPlayer().performCommand("cg 5");
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 5");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.5"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    		else if(s.getLine(2).equalsIgnoreCase("6")){
                        		if(e.getPlayer().hasPermission("customgravity.sign.use.6")){
                        			e.getPlayer().performCommand("cg 6");
                            		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 5");

                        		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.5"))){
                        			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                        		}
                    	}else if(s.getLine(1).equalsIgnoreCase("Remove gravity")){
                    		if (e.getPlayer().hasPermission("customgravity.sign.use.remove")){
                    			e.getPlayer().performCommand("cg remove");
                    		}else if(!(e.getPlayer().hasPermission("customgravity.sign.use.remove"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}
                        		
                     }
                }
         }
    }
}