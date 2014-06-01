package tk.shadowdev.customgravity.lib;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GravityEffect {
	
	public void Level0(Player p){
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.JUMP);
	}
	
	public void Leveln1(Player p){
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 0));
	}
	
	public void Leveln2(Player p){
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 1));
	}
	
	public void Leveln3(Player p){
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 2));
	}
	
	public void Leveln4(Player p){
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 2));
	}
	
	public void Leveln5(Player p){
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 3));
	}
	
	public void Levelp1(Player p){
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 0));
	}
	
	public void Levelp2(Player p){
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 1));
	}
	
	public void Levelp3(Player p){
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 2));
	}
	
	public void Levelp4(Player p){
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 3));
	}
	
	public void Levelp5(Player p){
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.SLOW);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100000, 4));
	}

}
