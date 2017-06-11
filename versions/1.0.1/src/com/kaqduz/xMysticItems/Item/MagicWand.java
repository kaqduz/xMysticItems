package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class MagicWand extends MysticItem{
	public MagicWand(MysticItemManager instance) {
        
        super(itemek(new ItemStack(Material.BLAZE_ROD)), instance, MysticItemType.USABLE);

}


static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§7Magic Wand");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§oA magic stick mixed with extract from golden applaes");
    lore.add("§8Restored health: §62 Hearts");
    lore.add("§8Restored food: §62 FoodPoints");
    lore.add("§8Golden apple effect - duration:§6 10 seconds");

    meta.setLore(lore);
    ItemStack i = metaa;
    i.setItemMeta(meta);
    return i;
}


@Override
public void onUse(PlayerInteractEvent e) {
	double d = ((Damageable)e.getPlayer()).getHealth();
	if(d < 17)
	e.getPlayer().setHealth(d + 4);
	else 
		e.getPlayer().setHealth(((Damageable)e.getPlayer()).getMaxHealth());

	if(e.getPlayer().getFoodLevel() < 17)
	e.getPlayer().setFoodLevel(e.getPlayer().getFoodLevel() + 4);
	else
		e.getPlayer().setFoodLevel(20);
	 ItemStack is = e.getPlayer().getItemInHand();
	 if(is.getAmount() > 1)
	    is.setAmount(is.getAmount() - 1);
	else e.getPlayer().setItemInHand(null);
	
	 e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 60, new Random().nextFloat());
	 e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 2));
	 e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 200, 1));

	 
	
}


@Override
public void onAttack(EntityDamageByEntityEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void onDefend(EntityDamageEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void onDeath(PlayerDeathEvent e) {
	// TODO Auto-generated method stub
	
}

}
