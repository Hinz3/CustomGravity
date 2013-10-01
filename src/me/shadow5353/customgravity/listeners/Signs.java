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
	 
    @EventHandler
    public void onSignChange(SignChangeEvent e) {
    	if(e.getPlayer().hasPermission("customgravity.sign.create")) {
    		if(e.getLine(0).equalsIgnoreCase("[0]")){
    			e.setLine(0, "§6[CG]");
    			e.setLine(1, "§2Set Gravity");
    			e.setLine(2, "§20");
    		}
    		else if(e.getLine(0).equalsIgnoreCase("[1]")){
    			e.setLine(0, "§6[CG]");
    			e.setLine(1, "§2Set Gravity");
    			e.setLine(2, "§21");
    		}
    		else if(e.getLine(0).equalsIgnoreCase("[2]")){
    			e.setLine(0, "§6[CG]");
    			e.setLine(1, "§2Set Gravity");
    			e.setLine(2, "§22");
    		}
    		else if(e.getLine(0).equalsIgnoreCase("[3]")){
    			e.setLine(0, "§6[CG]");
    			e.setLine(1, "§2Set Gravity");
    			e.setLine(2, "§23");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[4]")){
    			e.setLine(0, "§6[CG]");
    			e.setLine(1, "§2Set Gravity");
    			e.setLine(2, "§24");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[5]")){
    			e.setLine(0, "§6[CG]");
    			e.setLine(1, "§2Set Gravity");
    			e.setLine(2, "§25");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[-1]")){
    			e.setLine(0, "§6[CG]");
    			e.setLine(1, "§2Set Gravity");
    			e.setLine(2, "§2-1");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[-2]")){
    			e.setLine(0, "§6[CG]");
    			e.setLine(1, "§2Set Gravity");
    			e.setLine(2, "§2-2");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[-3]")){
    			e.setLine(0, "§6[CG]");
    			e.setLine(1, "§2Set Gravity");
    			e.setLine(2, "§2-3");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[-4]")){
    			e.setLine(0, "§6[CG]");
    			e.setLine(1, "§2Set Gravity");
    			e.setLine(2, "§2-4");
    		}
    		if(e.getLine(0).equalsIgnoreCase("[-5]")){
    			e.setLine(0, "§6[CG]");
    			e.setLine(1, "§2Set Gravity");
    			e.setLine(2, "§2-5");
    		}
    	    if(e.getLine(0).equalsIgnoreCase("[remove]")){
			    e.setLine(0, "§6[CG]");
			    e.setLine(1, "§2Remove");
			    e.setLine(2, "§2Gravity");
		}
    	}else if (!(e.getPlayer().hasPermission("customgravity.sign.create"))){
    		
    	}
    }
   
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
    	
            if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
            if (e.getClickedBlock().getState() instanceof Sign) {
                    Sign s = (Sign) e.getClickedBlock().getState();
                    if(s.getLine(0).equalsIgnoreCase("§6[CG]")){
                    	if (s.getLine(2).equalsIgnoreCase("§2-5")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.-5")){
                        		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 4));
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to -5");
                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.-5"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2-4")){
                    	    if(e.getPlayer().hasPermission("customgravity.sign.use.-4")){
                    			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 3));
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to -4");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.-4"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2-3")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.-3")){
                    			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 2));
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to -3");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.-3"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                                     		
                    	}else if(s.getLine(2).equalsIgnoreCase("§2-2")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.-2")){
                    			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 1));
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to -2");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.-2"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("§2-1")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.-1")){
                    			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 1));
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100000, 0));
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to -1");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.-1"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("§20")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.0")){
                    			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 0");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.0"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("§21")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.1")){
                    			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10000, 0));
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 1");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.1"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("§22")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.2")){
                    			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10000, 1));
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 2");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.2"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("§23")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.3")){
                    			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10000, 2));
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 3");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.2"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("§24")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.4")){
                    			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10000, 3));
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 4");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.1"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(2).equalsIgnoreCase("§2Gravity 5")){
                    		if(e.getPlayer().hasPermission("customgravity.sign.use.5")){
                    			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10000, 4));
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Gravity set to 5");

                    		}else if (!(e.getPlayer().hasPermission("customgravity.sign.use.5"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}else if(s.getLine(1).equalsIgnoreCase("§2Remove gravity")){
                    		if (e.getPlayer().hasPermission("customgravity.sign.use.remove")){
                    			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
                        		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
                        		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
                        		e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.GREEN + " Removed all gravity effects!");
                        	
                    		}else if(!(e.getPlayer().hasPermission("customgravity.sign.use.remove"))){
                    			e.getPlayer().sendMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "CG" + ChatColor.GOLD + "]" + ChatColor.RED + " You don't have permission!");
                    		}
                    	}
                        		
                     }
                }
         }
    }