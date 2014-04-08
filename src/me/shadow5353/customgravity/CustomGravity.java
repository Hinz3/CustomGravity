package me.shadow5353.customgravity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import me.shadow5353.customgravity.lib.GravityEffect;
import me.shadow5353.customgravity.listeners.SignBreak;
import me.shadow5353.customgravity.listeners.Signs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomGravity extends JavaPlugin implements Listener {
	FileConfiguration config;
	File cfile;
	
	ArrayList<Player> fly = new ArrayList<Player>();
	ArrayList<Player> cooldown = new ArrayList<Player>();
	ArrayList<Player> cooldown_cg = new ArrayList<Player>();
	ArrayList<Player> cooldown_set = new ArrayList<Player>();
	ArrayList<Player> cooldown_info = new ArrayList<Player>();
	ArrayList<Player> cooldown_reload = new ArrayList<Player>();
	ArrayList<Player> cooldown_remove = new ArrayList<Player>();
	ArrayList<Player> cooldown_level = new ArrayList<Player>();
	ArrayList<Player> cooldown_0 = new ArrayList<Player>();
	ArrayList<Player> cooldown_n1 = new ArrayList<Player>();
	ArrayList<Player> cooldown_n2 = new ArrayList<Player>();
	ArrayList<Player> cooldown_n3 = new ArrayList<Player>();
	ArrayList<Player> cooldown_n4 = new ArrayList<Player>();
	ArrayList<Player> cooldown_n5 = new ArrayList<Player>();
	ArrayList<Player> cooldown_n6 = new ArrayList<Player>();
	ArrayList<Player> cooldown_p1 = new ArrayList<Player>();
	ArrayList<Player> cooldown_p2 = new ArrayList<Player>();
	ArrayList<Player> cooldown_p3 = new ArrayList<Player>();
	ArrayList<Player> cooldown_p4 = new ArrayList<Player>();
	ArrayList<Player> cooldown_p5 = new ArrayList<Player>();

	@Override
	public void onEnable() {
		if (getConfig().getString("Auto-update").contains("true")) {
			Updater updater = new Updater(this, 65511, this.getFile(),Updater.UpdateType.DEFAULT, true);
		}
		if (getConfig().getString("Auto-update").contains("false")) {
			Updater updater = new Updater(this, 65511, this.getFile(),Updater.UpdateType.NO_DOWNLOAD, true);
		}
		config = getConfig();
		config.options().copyDefaults(true);
		saveDefaultConfig();
		cfile = new File(getDataFolder(), "config.yml");

		if (!(getServer().getOnlineMode())) {
			this.setEnabled(false);
		}

		// events
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
		pm.registerEvents(new Signs(), this);
		pm.registerEvents(new SignBreak(), this);

		// MCStats
		try {
			Metrics metrics = new Metrics(this);
			metrics.start();
		} catch (IOException e) {
			// Failed to submit the stats :-(
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			mm.getInstance().severe(sender,"Only players can use Custom Gravity");
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("customgravity")) {
			if (args.length == 0) {
				if(cooldown_cg.contains(p)){
					mm.getInstance().severe(p, "Please do not spam this command!");
				}
				mm.getInstance().cmd(p,"/cg [gravity level]" + ChatColor.BLACK + " : " + ChatColor.YELLOW + "Set your gravity");
				if(p.hasPermission("customgravity.set")){
					mm.getInstance().cmd(p, "/cg set [gravity level] [player]" + ChatColor.BLACK + " : " + ChatColor.YELLOW + "Changes others gravity");
				}
				mm.getInstance().cmd(p,"/cg remove" + ChatColor.BLACK + " : " + ChatColor.YELLOW + "Remove all gravity effects");
				mm.getInstance().cmd(p,"/cg level" + ChatColor.BLACK + " : " + ChatColor.YELLOW + "Shows all gravity levels");
				mm.getInstance().cmd(p,"/cg info" + ChatColor.BLACK + " : " + ChatColor.YELLOW + "Shows info about the plugin");
				if (p.hasPermission("customgravity.admin")) {
					mm.getInstance().cmd(p,"/cg reload" + ChatColor.BLACK + " : " + ChatColor.YELLOW + "Reload the config.yml");
				}
				cooldown_cg.add(p);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
					public void run(){
						cooldown_cg.remove(p);
					}
				}, 5);
				return true;
			}
			// /cg remove
			else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("remove")) {
					if(cooldown_remove.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.remove")) {
						mm.getInstance().severe(p, "You do not have permission!");
						return true;
					}
					GravityEffect ge = new GravityEffect();
					cooldown_remove.add(p);
					ge.Level0(p);
					mm.getInstance().good(p, "Removed all gravity effects!");
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_remove.remove(p);
						}
					}, 5);
					return true;
				}
				if (args[0].equalsIgnoreCase("level")) {
					if(cooldown_level.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.level")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					mm.getInstance().g(p,"Level 0" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level works like /gc remove.");
					mm.getInstance().g(p,"Level 1" + ChatColor.DARK_RED + " : "	+ ChatColor.YELLOW + "This level add speed and jump.");
					mm.getInstance().g(p,"Level 2" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 2.");
					mm.getInstance().g(p,"Level 3" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 3.");
					mm.getInstance().g(p,"Level 4" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 4.");
					mm.getInstance().g(p,"Level 5" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This level add speed 1 and jump 5.");
					mm.getInstance().g(p,"Level -1" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow.");
					mm.getInstance().g(p,"Level -2" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 2.");
					mm.getInstance().g(p,"Level -3" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 3.");
					mm.getInstance().g(p,"Level -4" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 4.");
					mm.getInstance().g(p,"Level -5" + ChatColor.DARK_RED + " : " + ChatColor.YELLOW + "This leve add slow 5.");
					mm.getInstance().info(p,"To get a gravity level use " + ChatColor.GOLD + "/cg [gravity level]");
					mm.getInstance().info(p, "To change others gravity use " + ChatColor.GOLD + "/cg set [gravity level] [player]");
					cooldown_level.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_level.remove(p);
						}
					}, 5);
					return true;
				}

				if (args[0].equalsIgnoreCase("info")) {
					if(cooldown_info.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					mm.getInstance().info(p,"BukkitDev: " + ChatColor.GOLD + "http://bit.ly/Custom-gravity");
					mm.getInstance().info(p,"Github: " + ChatColor.GOLD + "http://bit.ly/custom-gravity-github");
					mm.getInstance().info(p,"Version: " + ChatColor.GOLD + "0.4.1");
					mm.getInstance().info(p,"Made by: " + ChatColor.GOLD + "shadow5353");
					mm.getInstance().info(p,"Twitter: " + ChatColor.GOLD + "http://bit.ly/devcustom-gravity");
					mm.getInstance().info(p,"Request by: " + ChatColor.GOLD + "Baker_san");
					cooldown_info.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_info.remove(p);
						}
					}, 5);
					return true;
				}

				if (args[0].equalsIgnoreCase("reload")) {
					if(cooldown_reload.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.admin")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					config = YamlConfiguration.loadConfiguration(cfile);
					mm.getInstance().good(p, "Reloaded config.yml!");
					cooldown_reload.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_reload.remove(p);
						}
					}, 5);
					return true;
				}
				GravityEffect ge = new GravityEffect();
				if (args[0].equalsIgnoreCase("0")) {
					if (!sender.hasPermission("customgravity.0")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					ge.Level0(p);
					mm.getInstance().good(p, "Gravity set to 0");
					cooldown_0.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_0.remove(p);
						}
					}, 5);
					return true;

				}
				if (args[0].equalsIgnoreCase("1")) {
					if(cooldown_p1.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.1")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					ge.Leveln1(p);
					mm.getInstance().good(p, "Gravity set to 1");
					cooldown_p1.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_p1.remove(p);
						}
					}, 5);
					return true;
				}
				if (args[0].equalsIgnoreCase("2")) {
					if(cooldown_p2.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.2")) {
						mm.getInstance().severe(p, "You do not have permission!");
						
						return true;
					}
					ge.Leveln2(p);
					mm.getInstance().good(p, "Gravity set to 2");
					cooldown_p2.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_p2.remove(p);
						}
					}, 5);
					return true;
				}
				if (args[0].equalsIgnoreCase("3")) {
					if(cooldown_p3.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.3")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					ge.Leveln3(p);
					mm.getInstance().good(p, "Gravity set to 3");
					cooldown_p3.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_p3.remove(p);
						}
					}, 5);
					return true;
				}
				if (args[0].equalsIgnoreCase("4")) {
					if(cooldown_p4.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.4")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					ge.Leveln4(p);
					mm.getInstance().good(p, "Gravity set to 4");
					cooldown_p4.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_p4.remove(p);
						}
					}, 5);
					return true;
				}
				if (args[0].equalsIgnoreCase("5")) {
					if(cooldown_p5.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.5")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					ge.Leveln5(p);
					mm.getInstance().good(p, "Gravity set to 5");
					cooldown_p5.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_p5.remove(p);
						}
					}, 5);
					return true;
				}
				if (args[0].equalsIgnoreCase("-1")) {
					if(cooldown_n1.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.-1")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					ge.Levelp1(p);
					mm.getInstance().good(p, "Gravity set to -1");
					cooldown_n1.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_n1.remove(p);
						}
					}, 5);
					return true;
				}
				if (args[0].equalsIgnoreCase("-2")) {
					if(cooldown_n2.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.-2")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					ge.Levelp2(p);
					mm.getInstance().good(p, "Gravity set to -2");
					cooldown_n2.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_n2.remove(p);
						}
					}, 5);
					return true;
				}
				if (args[0].equalsIgnoreCase("-3")) {
					if(cooldown_n3.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.-3")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					ge.Levelp3(p);
					mm.getInstance().good(p, "Gravity set to -3");
					cooldown_n3.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_n3.remove(p);
						}
					}, 5);
					return true;
				}
				if (args[0].equalsIgnoreCase("-4")) {
					if(cooldown_n4.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.-4")) {
						mm.getInstance().severe(p, "You do not have permission!");
						return true;
					}
					ge.Levelp4(p);
					mm.getInstance().good(p, "Gravity set to -4");
					cooldown_n4.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_n4.remove(p);
						}
					}, 5);
					return true;
				}
				if (args[0].equalsIgnoreCase("-5")) {
					if(cooldown_n5.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					if (!sender.hasPermission("customgravity.-5")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					ge.Levelp5(p);
					mm.getInstance().good(p, "Gravity set to -5");
					cooldown_n5.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_n5.remove(p);
						}
					}, 5);
					return true;
				}
				if (args[0].equalsIgnoreCase("-6")) {

					if(cooldown_n6.contains(p)){
						mm.getInstance().severe(p, "Please do not spam this command!");
					}
					
					if (!sender.hasPermission("customgravity.-6")) {
						mm.getInstance().severe(p,"You do not have permission!");
						return true;
					}
					fly.add(p);
					cooldown_n6.add(p);
					p.setFlying(true);
					mm.getInstance().good(p, "Gravity set to -6");
					mm.getInstance().info(p, "You can now fly in 5 minutes");
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
						public void run(){
							fly.remove(p);
							p.setFlying(false);
							mm.getInstance().severe(p, "Gravity changed to 0");
						}
					}, 300);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldown_n6.remove(p);
						}
					}, 5);
				}
			}
			if (args.length == 3) {
				if (args[0].equalsIgnoreCase("set")) {
					if (!p.hasPermission("customgravity.set")) {
						mm.getInstance().severe(p,"You do not have permission!");
					}
					if (args[1].equalsIgnoreCase("0")) {
						Player target = Bukkit.getServer().getPlayer(args[2]);
						if (target == null) {
							mm.getInstance().severe(p,"Error: Cannot find " + ChatColor.DARK_RED + args[2] + ChatColor.RED + "!");
							return true;
						}
						GravityEffect ge = new GravityEffect();
						ge.Level0(target);
						mm.getInstance().good(target,"Gravity set to 0 by: " + ChatColor.YELLOW + p.getName() + ChatColor.GREEN + "!");
					}
					if (args[1].equalsIgnoreCase("1")) {
						if(cooldown_set.contains(p)){
							mm.getInstance().severe(p, "Please do not spam this command!");
						}
						Player target = Bukkit.getServer().getPlayer(args[2]);
						if (target == null) {
							mm.getInstance().severe(p,"Error: Cannot find " + ChatColor.DARK_RED + args[2] + ChatColor.RED + "!");
							return true;
						}
						GravityEffect ge = new GravityEffect();
						ge.Leveln1(target);
						mm.getInstance().good(target,"Gravity set to 1 by: " + p.getName() +  ChatColor.YELLOW + p.getName() + ChatColor.GREEN + "!");
						cooldown_set.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
							public void run(){
								cooldown_set.remove(p);
							}
						}, 5);
					}
					if (args[1].equalsIgnoreCase("2")) {
						if(cooldown_set.contains(p)){
							mm.getInstance().severe(p, "Please do not spam this command!");
						}
						Player target = Bukkit.getServer().getPlayer(args[2]);
						if (target == null) {
							mm.getInstance().severe(p,"Error: Cannot find " + ChatColor.DARK_RED + args[2] + ChatColor.RED + "!");
							return true;
						}
						GravityEffect ge = new GravityEffect();
						ge.Leveln2(target);
						mm.getInstance().good(target,"Gravity set to 2 by: " + ChatColor.YELLOW + p.getName() + ChatColor.GREEN + "!");
						cooldown_set.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
							public void run(){
								cooldown_set.remove(p);
							}
						}, 5);
					}
					if (args[1].equalsIgnoreCase("3")) {
						if(cooldown_set.contains(p)){
							mm.getInstance().severe(p, "Please do not spam this command!");
						}
						Player target = Bukkit.getServer().getPlayer(args[2]);
						if (target == null) {
							mm.getInstance().severe(p,"Error: Cannot find " + ChatColor.DARK_RED + args[2] + ChatColor.RED + "!");
							return true;
						}
						GravityEffect ge = new GravityEffect();
						ge.Leveln3(target);
						mm.getInstance().good(target,"Gravity set to 3 by: " + ChatColor.YELLOW + p.getName() + ChatColor.GREEN + "!");
						cooldown_set.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
							public void run(){
								cooldown_set.remove(p);
							}
						}, 5);
					}
					if (args[1].equalsIgnoreCase("4")) {
						if(cooldown_set.contains(p)){
							mm.getInstance().severe(p, "Please do not spam this command!");
						}
						Player target = Bukkit.getServer().getPlayer(args[2]);
						if (target == null) {
							mm.getInstance().severe(p,"Error: Cannot find " + ChatColor.DARK_RED + args[2] + ChatColor.RED + "!");
							return true;
						}
						GravityEffect ge = new GravityEffect();
						ge.Leveln4(target);
						mm.getInstance().good(target,"Gravity set to 4 by: " + ChatColor.YELLOW + p.getName() + ChatColor.GREEN + "!");
						cooldown_set.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
							public void run(){
								cooldown_set.remove(p);
							}
						}, 5);
					}
					if (args[1].equalsIgnoreCase("5")) {
						if(cooldown_set.contains(p)){
							mm.getInstance().severe(p, "Please do not spam this command!");
						}
						Player target = Bukkit.getServer().getPlayer(args[2]);
						if (target == null) {
							mm.getInstance().severe(p,"Error: Cannot find " + ChatColor.DARK_RED + args[2] + ChatColor.RED + "!");
							return true;
						}
						GravityEffect ge = new GravityEffect();
						ge.Leveln5(target);
						mm.getInstance().good(target,"Gravity set to 5 by: " + ChatColor.YELLOW + p.getName() + ChatColor.GREEN + "!");
						cooldown_set.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
							public void run(){
								cooldown_set.remove(p);
							}
						}, 5);
					}
					if (args[1].equalsIgnoreCase("-1")) {
						if(cooldown_set.contains(p)){
							mm.getInstance().severe(p, "Please do not spam this command!");
						}
						Player target = Bukkit.getServer().getPlayer(args[2]);
						if (target == null) {
							mm.getInstance().severe(p,"Error: Cannot find " + ChatColor.DARK_RED + args[2] + ChatColor.RED + "!");
							return true;
						}
						GravityEffect ge = new GravityEffect();
						ge.Levelp1(target);
						mm.getInstance().good(target,"Gravity set to -1 by: " + ChatColor.YELLOW + p.getName() + ChatColor.GREEN + "!");
						cooldown_set.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
							public void run(){
								cooldown_set.remove(p);
							}
						}, 5);
					}
					if (args[1].equalsIgnoreCase("-2")) {
						if(cooldown_set.contains(p)){
							mm.getInstance().severe(p, "Please do not spam this command!");
						}
						Player target = Bukkit.getServer().getPlayer(args[2]);
						if (target == null) {
							mm.getInstance().severe(p,"Error: Cannot find " + ChatColor.DARK_RED + args[2] + ChatColor.RED + "!");
							return true;
						}
						GravityEffect ge = new GravityEffect();
						ge.Levelp2(target);
						mm.getInstance().good(target,"Gravity set to -2 by: " + ChatColor.YELLOW + p.getName() + ChatColor.GREEN + "!");
						cooldown_set.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
							public void run(){
								cooldown_set.remove(p);
							}
						}, 5);
					}
					if (args[1].equalsIgnoreCase("-3")) {
						if(cooldown_set.contains(p)){
							mm.getInstance().severe(p, "Please do not spam this command!");
						}
						Player target = Bukkit.getServer().getPlayer(args[2]);
						if (target == null) {
							mm.getInstance().severe(p,"Error: Cannot find " + ChatColor.DARK_RED + args[2] + ChatColor.RED + "!");
							return true;
						}
						GravityEffect ge = new GravityEffect();
						ge.Levelp3(target);
						mm.getInstance().good(target, "Gravity set to -3 by: " + ChatColor.YELLOW + p.getName() + ChatColor.GREEN + "!");
						cooldown_set.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
							public void run(){
								cooldown_set.remove(p);
							}
						}, 5);
					}
					if (args[1].equalsIgnoreCase("-4")) {
						if(cooldown_set.contains(p)){
							mm.getInstance().severe(p, "Please do not spam this command!");
						}
						
						Player target = Bukkit.getServer().getPlayer(args[2]);
						if (target == null) {
							mm.getInstance().severe(p,"Error: Cannot find " + ChatColor.DARK_RED + args[2] + ChatColor.RED + "!");		
							return true;
						}
						GravityEffect ge = new GravityEffect();
						ge.Levelp4(target);
						mm.getInstance().good(target,"Gravity set to -4 by: " + ChatColor.YELLOW + p.getName() + ChatColor.GREEN + "!");
						cooldown_set.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
							public void run(){
								cooldown_set.remove(p);
							}
						}, 5);
					}
					if (args[1].equalsIgnoreCase("-5")) {
						if(cooldown_set.contains(p)){
							mm.getInstance().severe(p, "Please do not spam this command!");
						}
						Player target = Bukkit.getServer().getPlayer(args[2]);
						if (target == null) {
							mm.getInstance().severe(p,"Error: Cannot find " + ChatColor.DARK_RED + args[2] + ChatColor.RED + "!");
							return true;
						}
						GravityEffect ge = new GravityEffect();
						ge.Levelp5(target);
						mm.getInstance().good(target,"Gravity set to -5 by: " + ChatColor.YELLOW + p.getName() + ChatColor.GREEN + "!");
						cooldown_set.add(p);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
							public void run(){
								cooldown_set.remove(p);
							}
						}, 5);
					}
				}
			}
			return true;
		}
		return true;
	}

	// events

	@EventHandler
	public void onPlayerChangedWorld(PlayerChangedWorldEvent e) {
		if (getConfig().getString("per-world-remove").contains("true")) {

			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
		} else if (getConfig().getString("per-world-remove").contains("false"))
			return;

		if (getConfig().getStringList("gravity.0").contains(
				e.getPlayer().getWorld().getName())) {
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			MessageManager.getInstance().good(e.getPlayer(),
					"You are on a Normal Gravity world");
		} else if (!(getConfig().getStringList("gravity.0").contains(e
				.getPlayer().getWorld().getName()))) {

		}
		if (getConfig().getStringList("gravity.1").contains(
				e.getPlayer().getWorld().getName())) {
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(
					new PotionEffect(PotionEffectType.SLOW, 100000, 0));
			MessageManager.getInstance().good(e.getPlayer(),
					"You are on a High Gravity world");
		} else if (!(getConfig().getStringList("gravity.1").contains(e
				.getPlayer().getWorld().getName()))) {

		}
		if (getConfig().getStringList("gravity.2").contains(
				e.getPlayer().getWorld().getName())) {
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(
					new PotionEffect(PotionEffectType.SLOW, 100000, 1));
			MessageManager.getInstance().good(e.getPlayer(),
					"You are on a High Gravity world");
		} else if (!(getConfig().getStringList("gravity.2").contains(e
				.getPlayer().getWorld().getName()))) {

		}
		if (getConfig().getStringList("gravity.3").contains(
				e.getPlayer().getWorld().getName())) {
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(
					new PotionEffect(PotionEffectType.SLOW, 100000, 2));
			MessageManager.getInstance().good(e.getPlayer(),
					"You are on a High Gravity world");
		} else if (!(getConfig().getStringList("gravity.3").contains(e
				.getPlayer().getWorld().getName()))) {

		}
		if (getConfig().getStringList("gravity.4").contains(
				e.getPlayer().getWorld().getName())) {
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(
					new PotionEffect(PotionEffectType.SLOW, 100000, 3));
			MessageManager.getInstance().good(e.getPlayer(),
					"You are on a High Gravity world");
		} else if (!(getConfig().getStringList("gravity.4").contains(e
				.getPlayer().getWorld().getName()))) {

		}
		if (getConfig().getStringList("gravity.5").contains(
				e.getPlayer().getWorld().getName())) {
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(
					new PotionEffect(PotionEffectType.SLOW, 100000, 4));
			MessageManager.getInstance().good(e.getPlayer(),
					"You are on a High Gravity world");
		} else if (!(getConfig().getStringList("gravity.5").contains(e
				.getPlayer().getWorld().getName()))) {

		}
		if (getConfig().getStringList("gravity.-1").contains(
				e.getPlayer().getWorld().getName())) {
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(
					new PotionEffect(PotionEffectType.JUMP, 100000, 0));
			MessageManager.getInstance().good(e.getPlayer(),
					"You are on a Low Gravity world");
		} else if (!(getConfig().getStringList("gravity.-1").contains(e
				.getPlayer().getWorld().getName()))) {

		}
		if (getConfig().getStringList("gravity.-2").contains(
				e.getPlayer().getWorld().getName())) {
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(
					new PotionEffect(PotionEffectType.JUMP, 100000, 1));
			MessageManager.getInstance().good(e.getPlayer(),
					"You are on a Low Gravity world");
		} else if (!(getConfig().getStringList("gravity.-2").contains(e
				.getPlayer().getWorld().getName()))) {

		}
		if (getConfig().getStringList("gravity.-3").contains(
				e.getPlayer().getWorld().getName())) {
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(
					new PotionEffect(PotionEffectType.JUMP, 100000, 2));
			MessageManager.getInstance().good(e.getPlayer(),
					"You are on a Low Gravity world");
		} else if (!(getConfig().getStringList("gravity.-3").contains(e
				.getPlayer().getWorld().getName()))) {

		}
		if (getConfig().getStringList("gravity.-4").contains(
				e.getPlayer().getWorld().getName())) {
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 3));
			MessageManager.getInstance().good(e.getPlayer(),"You are on a Low Gravity world");
		} else if (!(getConfig().getStringList("gravity.-4").contains(e.getPlayer().getWorld().getName()))) {

		}
		if (getConfig().getStringList("gravity.-5").contains(
				e.getPlayer().getWorld().getName())) {
			e.getPlayer().removePotionEffect(PotionEffectType.SPEED);
			e.getPlayer().removePotionEffect(PotionEffectType.JUMP);
			e.getPlayer().removePotionEffect(PotionEffectType.SLOW);
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 4));
			MessageManager.getInstance().good(e.getPlayer(),"You are on a Low Gravity world");
		} else if (!(getConfig().getStringList("gravity.-5").contains(e.getPlayer().getWorld().getName()))) {
		}
	}

	public void onPlayerItemConsume(PlayerItemConsumeEvent e) {
		if (getConfig().getString("milk-bucket-remove").contains("true")) {
			if (e.getItem().getType().equals(Material.MILK_BUCKET)) {
				e.setCancelled(true);
				e.getPlayer().removePotionEffect(PotionEffectType.ABSORPTION);
				e.getPlayer().removePotionEffect(PotionEffectType.BLINDNESS);
				e.getPlayer().removePotionEffect(PotionEffectType.CONFUSION);
				e.getPlayer().removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
				e.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				e.getPlayer().removePotionEffect(PotionEffectType.HARM);
				e.getPlayer().removePotionEffect(PotionEffectType.HEAL);
				e.getPlayer().removePotionEffect(PotionEffectType.HEALTH_BOOST);
				e.getPlayer().removePotionEffect(PotionEffectType.HUNGER);
				e.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				e.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
				e.getPlayer().removePotionEffect(PotionEffectType.NIGHT_VISION);
				e.getPlayer().removePotionEffect(PotionEffectType.POISON);
				e.getPlayer().removePotionEffect(PotionEffectType.REGENERATION);
				e.getPlayer().removePotionEffect(PotionEffectType.SATURATION);
				e.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
				e.getPlayer().removePotionEffect(PotionEffectType.WEAKNESS);
				e.getPlayer().removePotionEffect(PotionEffectType.WITHER);
			}
		}
	}
}
