package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class LifeSplitter extends MysticItem {

	public LifeSplitter(MysticItemManager instance) {
        
        super(itemek(new ItemStack(Material.STONE_HOE)), instance, MysticItemType.USABLE);

}


static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§4§CLIFE SPLITTER");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§oOnce upon a time, the titans had to personally distribute the life of mortals.");
    lore.add("§8§oToday, however, this has a different use...");
    lore.add("§8Life swap - minimal health: §620%");
    meta.addEnchant(Enchantment.DURABILITY, 10, true);
    meta.setLore(lore);
    ItemStack i = metaa;
    i.setItemMeta(meta);
    return i;
}




@Override
public void onAttack(EntityDamageByEntityEvent e) {

	
	
}


@Override
public void onDefend(EntityDamageEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void onDeath(PlayerDeathEvent e) {
	// TODO Auto-generated method stub
	
}
	
public HashMap<String, Long> SunderCooldowns = new HashMap<String, Long>();
public boolean CanUseSunder(Player p){
	if(!p.isOp())
		return true;
int cooldownTime = 150; // The number of seconds the player has to wait
if(SunderCooldowns.containsKey(p.getName())) {

long secondsLeft = ((SunderCooldowns.get(p.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);

if(secondsLeft>0) {
	  p.sendMessage("§8# §cU have to wait §6" + secondsLeft + " second(s)§c, to use this again!");
return false;
}
}
SunderCooldowns.put(p.getName(), System.currentTimeMillis());
return true;
}

@Override
public void onUse(PlayerInteractEvent e) {
	if(CanUseSunder(e.getPlayer())){
	
	 
     Arrow arrow = e.getPlayer().launchProjectile(Arrow.class);
     arrow.setVelocity(arrow.getVelocity().multiply(10));
     
	}
		   
		  
		   
	
	 
}
@EventHandler
public void onEntityDamage ( EntityDamageByEntityEvent event ){
	
	
	if(event.getDamager() instanceof Arrow && ((Arrow) event.getDamager()).getShooter() instanceof Player){
		
		
	Damageable shooter = (Player) ((Arrow) event.getDamager()).getShooter();
	if(((Player)shooter).getItemInHand().hasItemMeta() && ((Player)shooter).getItemInHand().getItemMeta().getDisplayName() != null && ((Player)shooter).getItemInHand().getItemMeta().getDisplayName().contains("§4§CLIFE SPLITTER")){
		
	double Tar = 0;
	event.setCancelled(true);
	
	double sho = 0;
	double tar1= 0;
	double sho2 = 0;
	if(event.getEntity() instanceof LivingEntity){
		
		Damageable target = (LivingEntity) event.getEntity();
	Tar = (double)(target.getHealth() / target.getMaxHealth());
	sho = (double)(shooter.getHealth() / shooter.getMaxHealth());
		if(Tar < 0.20 || sho < 0.20){
			if (Tar < 0.20){
				shooter.setHealth(((Damageable)shooter).getMaxHealth() * 0.2);
				tar1 = 1;
			}
			if (sho < 0.20){
				target.setHealth(target.getMaxHealth() * 0.2);
				sho2 = 1;
			}
				
			
			
			
			
		}
		if(tar1 == 0)
			shooter.setHealth(((Damageable)shooter).getMaxHealth() * Tar);
		if (sho2 == 0)
			target.setHealth(target.getMaxHealth() * sho);
		
		
	}
		((Player) shooter).playSound(shooter.getLocation(), Sound.ANVIL_LAND, 1F, 5F);
		
		
		}
	
	}
	
}
@EventHandler
public void Hit(final ProjectileHitEvent e){
	
	if(e.getEntity() instanceof Arrow && e.getEntity().getShooter() instanceof Player){
		
		Player shooter = (Player) e.getEntity().getShooter();
		if(((Player)shooter).getItemInHand().hasItemMeta() && ((Player)shooter).getItemInHand().getItemMeta().getDisplayName() != null && ((Player)shooter).getItemInHand().getItemMeta().getDisplayName().contains("§4§CLIFE SPLITTER")){
			Bukkit.getScheduler().scheduleSyncDelayedTask(instance.getPlugin(), new Runnable() {
				    public void run() {
				    	((Arrow)e.getEntity()).remove();
				    }
			}, 2);
			
		}
	
	
	
}
}
	
}
