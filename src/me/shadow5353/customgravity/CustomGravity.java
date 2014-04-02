package me.shadow5353.customgravity;

import java.io.File;
import java.io.IOException;

import me.shadow5353.customgravity.lib.GravityEffect;
import me.shadow5353.customgravity.listeners.SignBreak;
import me.shadow5353.customgravity.listeners.Signs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomGravity extends JavaPlugin implements Listener{
	FileConfiguration config;
    File cfile;
	
	@Override
	public void onEnable() {
		config = getConfig();
        config.options().copyDefaults(true);
        saveDefaultConfig();
        cfile = new File(getDataFolder(), "config.yml");
        
		if(!(getServer().getOnlineMode())){
			this.setEnabled(false);
		}
		
		//events
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		pm.registerEvents(new Signs(), this);
		pm.registerEvents(new SignBreak(), this);
		
		//MCStats
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
			}
        }
	
	
public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	if(!(sender instanceof Player)){
		mm.getInstance().severe(sender, "Only players can use Custom Gravity");
	}
	final Player p = (Player) sender;
	if (cmd.getName().equalsIgnoreCase("customgravity")) {
		if (args.length == 0) {
			mm.getInstance().cmd(p, "/cg [gravity level]" + ChatColor.BLACK + " : " + ChatColor.YELLOW + "This command set your gravity");
			mm.getInstance().cmd(p, "/cg remove" + ChatColor.BLACK + " : " + ChatColor.YELLOW + "This command remove all gravity effects");
			mm.getInstance().cmd(p, "/cg level" + ChatColor.BLACK + " : " + ChatColor.YELLOW + "This command shows all gravity levels");
			mm.getInstance().cmd(p, "/cg info" + ChatColor.BLACK + " : " + ChatColor.YELLOW + "This command shows info about the plugin");
			if(p.hasPermission("customgravity.admin")){
				mm.getInstance().cmd(p, "/cg reload" + ChatColor.BLACK + " : " + ChatColor.YELLOW + "This command reload the config.yml");
			}

			return true;
			}
		// /cg remove
		else if (args.length == 1) {
			if (args[0].equalsIgnoreCase("remove")) {
				if (!sender.hasPermission("customgravity.remove")) {
					mm.getInstance().severe(p, "You do not have permission!");
					return true;
					}
				GravityEffect ge = new GravityEffect();
				ge.Level0(p);
				mm.getInstance().good(p, "Removed all gravity effects!");
				return true;
				}
			if (args[0].equalsIgnoreCase("level")) {
				if (!sender.hasPermission("customgravity.level")) {
					mm.getInstance().severe(p, "You do not have permission!");
					return true;
					}
				mm.getInstance().g(p, "Level 0" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level works like /gc remove.");
				mm.getInstance().g(p, "Level 1" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed and jump.");
				mm.getInstance().g(p, "Level 2" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 2.");
				mm.getInstance().g(p, "Level 3" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 3.");
				mm.getInstance().g(p, "Level 4" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 4.");
				mm.getInstance().g(p, "Level 5" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 5.");
				mm.getInstance().g(p, "Level -1" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow.");
				mm.getInstance().g(p, "Level -2" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 2.");
				mm.getInstance().g(p, "Level -3" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 3.");
				mm.getInstance().g(p, "Level -4" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 4.");
				mm.getInstance().g(p, "Level -5" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 5.");
				mm.getInstance().info(p, "To get a gravity level use " + ChatColor.GOLD + "/cg [gravity level]");
				return true;
				}
			
			if (args[0].equalsIgnoreCase("info")) {
				mm.getInstance().info(p, "BukkitDev: " + ChatColor.GOLD + "http://bit.ly/Custom-gravity");
				mm.getInstance().info(p, "Github: " + ChatColor.GOLD + "http://bit.ly/custom-gravity-github");
				mm.getInstance().info(p, "Version: " + ChatColor.GOLD + "0.4");
				mm.getInstance().info(p, "Made by: " + ChatColor.GOLD + "shadow5353");
				mm.getInstance().info(p, "Twitter: " + ChatColor.GOLD + "http://bit.ly/devcustom-gravity");
				mm.getInstance().info(p, "Request by: " + ChatColor.GOLD + "Baker_san");
				return true;
				}
			
			if (args[0].equalsIgnoreCase("reload")) {
				if (!sender.hasPermission("customgravity.admin")) {
					mm.getInstance().severe(p, "You do not have permission!");
					return true;
					}
				config = YamlConfiguration.loadConfiguration(cfile);
				mm.getInstance().good(p, "Reloaded config.yml!");
				return true;
				}
			GravityEffect ge = new GravityEffect();
			if (args[0].equalsIgnoreCase("0")) {
				if (!sender.hasPermission("customgravity.0")) {
					mm.getInstance().severe(p, "You do not have permission!");
					return true;
					}
				ge.Level0(p);
				mm.getInstance().good(p, "Gravity set to 0");
				return true;
					
					}
			if (args[0].equalsIgnoreCase("1")) {
				if (!sender.hasPermission("customgravity.1")) {
					mm.getInstance().severe(p, "You do not have permission!");						
					return true;
					}
				ge.Leveln1(p);
				mm.getInstance().good(p, "Gravity set to 1");
				return true;
				}
			if (args[0].equalsIgnoreCase("2")) {
				if (!sender.hasPermission("customgravity.2")) {
					sender.sendMessage(ChatColor.DARK_RED + "You do not have permission!");
					return true;
					}
				ge.Leveln2(p);
				mm.getInstance().good(p, "Gravity set to 2");
				return true;
				}
			if (args[0].equalsIgnoreCase("3")) {
				if (!sender.hasPermission("customgravity.3")) {
					mm.getInstance().severe(p, "You do not have permission!");
					return true;
					}
				ge.Leveln3(p);
				mm.getInstance().good(p, "Gravity set to 3");
				return true;
				}
			if (args[0].equalsIgnoreCase("4")) {
				if (!sender.hasPermission("customgravity.4")) {
					mm.getInstance().severe(p, "You do not have permission!");
					return true;
					}
				ge.Leveln4(p);
				mm.getInstance().good(p, "Gravity set to 4");
				return true;
				}
			if (args[0].equalsIgnoreCase("5")) {
				if (!sender.hasPermission("customgravity.5")) {
					mm.getInstance().severe(p, "You do not have permission!");
					return true;
					}
				ge.Leveln5(p);
				mm.getInstance().good(p, "Gravity set to 5");
				return true;
				}
			if (args[0].equalsIgnoreCase("-1")) {
				if (!sender.hasPermission("customgravity.-1")) {
					mm.getInstance().severe(p, "You do not have permission!");
					return true;
					}
				ge.Levelp1(p);
				mm.getInstance().good(p, "Gravity set to -1");
				return true;
				}
			if (args[0].equalsIgnoreCase("-2")) {
				if (!sender.hasPermission("customgravity.-2")) {
					mm.getInstance().severe(p, "You do not have permission!");
					return true;
					}
				ge.Levelp2(p);
				mm.getInstance().good(p, "Gravity set to -2");
				return true;
				}
			if (args[0].equalsIgnoreCase("-3")) {
				if (!sender.hasPermission("customgravity.-3")) {
					mm.getInstance().severe(p, "You do not have permission!");
					return true;
					}
				ge.Levelp3(p);
				mm.getInstance().good(p, "Gravity set to -3");
					return true;
					}
			if (args[0].equalsIgnoreCase("-4")) {
				if (!sender.hasPermission("customgravity.-4")) {
					sender.sendMessage(ChatColor.DARK_RED + "You do not have permission!");
					return true;
					}
				ge.Levelp4(p);
				mm.getInstance().good(p, "Gravity set to -4");
				return true;
					}
			if (args[0].equalsIgnoreCase("-5")) {
				if (!sender.hasPermission("customgravity.-5")) {
					mm.getInstance().severe(p, "You do not have permission!");
					return true;
					}
				ge.Levelp5(p);
				mm.getInstance().good(p, "Gravity set to -5");
				return true;
				}
			}
		if(args.length == 3){
			if(args[0].equalsIgnoreCase("set")){
				if(!p.hasPermission("customgravity.set")){
					mm.getInstance().severe(p, "You do not have permission!");
				}
				if(args[1].equalsIgnoreCase("0")){
					Player target = Bukkit.getServer().getPlayer(args[2]);
					if(target == null){
						mm.getInstance().severe(p, "Usage: /cg set [gravity level] [player]");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					ge.Level0(target);
					mm.getInstance().good(target, "Gravity set to 0 by: " + p.getName() + "!");
				}
				if(args[1].equalsIgnoreCase("1")){
					Player target = Bukkit.getServer().getPlayer(args[2]);
					if(target == null){
						mm.getInstance().severe(p, "Usage: /cg set [gravity level] [player]");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					ge.Leveln1(target);
					mm.getInstance().good(target, "Gravity set to 1 by: " + p.getName() + "!");
				}
				if(args[1].equalsIgnoreCase("2")){
					Player target = Bukkit.getServer().getPlayer(args[2]);
					if(target == null){
						mm.getInstance().severe(p, "Usage: /cg set [gravity level] [player]");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					ge.Leveln2(target);
					mm.getInstance().good(target, "Gravity set to 2 by: " + p.getName() + "!");
				}
				if(args[1].equalsIgnoreCase("3")){
					Player target = Bukkit.getServer().getPlayer(args[2]);
					if(target == null){
						mm.getInstance().severe(p, "Usage: /cg set [gravity level] [player]");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					ge.Leveln3(target);
					mm.getInstance().good(target, "Gravity set to 3 by: " + p.getName() + "!");
				}
				if(args[1].equalsIgnoreCase("4")){
					Player target = Bukkit.getServer().getPlayer(args[2]);
					if(target == null){
						mm.getInstance().severe(p, "Usage: /cg set [gravity level] [player]");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					ge.Leveln4(target);
					mm.getInstance().good(target, "Gravity set to 4 by: " + p.getName() + "!");
				}
				if(args[1].equalsIgnoreCase("5")){
					Player target = Bukkit.getServer().getPlayer(args[2]);
					if(target == null){
						mm.getInstance().severe(p, "Usage: /cg set [gravity level] [player]");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					ge.Leveln5(target);
					mm.getInstance().good(target, "Gravity set to 5 by: " + p.getName() + "!");
				}
				if(args[1].equalsIgnoreCase("-1")){
					Player target = Bukkit.getServer().getPlayer(args[2]);
					if(target == null){
						mm.getInstance().severe(p, "Usage: /cg set [gravity level] [player]");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					ge.Levelp1(target);
					mm.getInstance().good(target, "Gravity set to -1 by: " + p.getName() + "!");
				}
				if(args[1].equalsIgnoreCase("-2")){
					Player target = Bukkit.getServer().getPlayer(args[2]);
					if(target == null){
						mm.getInstance().severe(p, "Usage: /cg set [gravity level] [player]");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					ge.Levelp2(target);
					mm.getInstance().good(target, "Gravity set to -2 by: " + p.getName() + "!");
				}
				if(args[1].equalsIgnoreCase("-3")){
					Player target = Bukkit.getServer().getPlayer(args[2]);
					if(target == null){
						mm.getInstance().severe(p, "Usage: /cg set [gravity level] [player]");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					ge.Levelp3(target);
					mm.getInstance().good(target, "Gravity set to -3 by: " + p.getName() + "!");
				}
				if(args[1].equalsIgnoreCase("-4")){
					Player target = Bukkit.getServer().getPlayer(args[2]);
					if(target == null){
						mm.getInstance().severe(p, "Usage: /cg set [gravity level] [player]");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					ge.Levelp4(target);
					mm.getInstance().good(target, "Gravity set to -4 by: " + p.getName() + "!");
				}
				if(args[1].equalsIgnoreCase("-5")){
					Player target = Bukkit.getServer().getPlayer(args[2]);
					if(target == null){
						mm.getInstance().severe(p, "Usage: /cg set [gravity level] [player]");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					ge.Levelp5(target);
					mm.getInstance().good(target, "Gravity set to -5 by: " + p.getName() + "!");
				}
			}
		}
		return true;
		}
	return true;
	}

//events

@EventHandler
public void onPlayerChangedWorld(PlayerChangedWorldEvent e){
        if(getConfig().getString("per-world-remove").contains("true")){
        	
           e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
           e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
           e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
           }
        else if(getConfig().getString("per-world-remove").contains("false")) return;
        

    	if (getConfig().getStringList("gravity.0").contains(e.getPlayer().getWorld().getName())){
    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		MessageManager.getInstance().good(e.getPlayer(), "You are on a Normal Gravity world");
    	}
    	else if (!(getConfig().getStringList("gravity.0").contains(e.getPlayer().getWorld().getName()))){
    		
    	}
    	if (getConfig().getStringList("gravity.1").contains(e.getPlayer().getWorld().getName())){
    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 0));
    		MessageManager.getInstance().good(e.getPlayer(), "You are on a High Gravity world");
    	}
    	else if (!(getConfig().getStringList("gravity.1").contains(e.getPlayer().getWorld().getName()))){
    		
    	}
    	if (getConfig().getStringList("gravity.2").contains(e.getPlayer().getWorld().getName())){
    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 1));
    		MessageManager.getInstance().good(e.getPlayer(), "You are on a High Gravity world");
    	}
        else if (!(getConfig().getStringList("gravity.2").contains(e.getPlayer().getWorld().getName()))){
    		
    	}
    	if (getConfig().getStringList("gravity.3").contains(e.getPlayer().getWorld().getName())){
    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 2));
    		MessageManager.getInstance().good(e.getPlayer(), "You are on a High Gravity world");
    	}
        else if (!(getConfig().getStringList("gravity.3").contains(e.getPlayer().getWorld().getName()))){
    		
    	}
    	if (getConfig().getStringList("gravity.4").contains(e.getPlayer().getWorld().getName())){
    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 3));
    		MessageManager.getInstance().good(e.getPlayer(), "You are on a High Gravity world");
    	}
        else if (!(getConfig().getStringList("gravity.4").contains(e.getPlayer().getWorld().getName()))){
    		
    	}
    	if (getConfig().getStringList("gravity.5").contains(e.getPlayer().getWorld().getName())){
    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 4));
    		MessageManager.getInstance().good(e.getPlayer(), "You are on a High Gravity world");
    	}
        else if (!(getConfig().getStringList("gravity.5").contains(e.getPlayer().getWorld().getName()))){
    		
    	}
    	if (getConfig().getStringList("gravity.-1").contains(e.getPlayer().getWorld().getName())){
    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 0));
    		MessageManager.getInstance().good(e.getPlayer(), "You are on a Low Gravity world");
    	}
        else if (!(getConfig().getStringList("gravity.-1").contains(e.getPlayer().getWorld().getName()))){
    		
    	}
    	if (getConfig().getStringList("gravity.-2").contains(e.getPlayer().getWorld().getName())){
    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 1));
    		MessageManager.getInstance().good(e.getPlayer(), "You are on a Low Gravity world");
    	}
        else if (!(getConfig().getStringList("gravity.-2").contains(e.getPlayer().getWorld().getName()))){
    		
    	}
    	if (getConfig().getStringList("gravity.-3").contains(e.getPlayer().getWorld().getName())){
    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 2));
    		MessageManager.getInstance().good(e.getPlayer(), "You are on a Low Gravity world");
    	}
        else if (!(getConfig().getStringList("gravity.-3").contains(e.getPlayer().getWorld().getName()))){
    		
    	}
    	if (getConfig().getStringList("gravity.-4").contains(e.getPlayer().getWorld().getName())){
    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 3));
    		MessageManager.getInstance().good(e.getPlayer(), "You are on a Low Gravity world");
    	}
        else if (!(getConfig().getStringList("gravity.-4").contains(e.getPlayer().getWorld().getName()))){
    		
    	}
    	if (getConfig().getStringList("gravity.-5").contains(e.getPlayer().getWorld().getName())){
    		e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
    		e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
    		e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
    		e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 4));
    		MessageManager.getInstance().good(e.getPlayer(), "You are on a Low Gravity world");
    	}
        else if (!(getConfig().getStringList("gravity.-5").contains(e.getPlayer().getWorld().getName()))){
        	}
    	}
}
