package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class Dominator extends MysticItem {

	public Dominator(MysticItemManager instance) {
        
        super(itemek(new ItemStack(Material.DIAMOND_HELMET)), instance, MysticItemType.ATTACKABLE);

}
//based on Dota 2 item ^^

static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§5§lHelm of dominator");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§o For those who necessarily have to steal something.");
    lore.add("§8Lifesteal: §620%");
    meta.setLore(lore);
    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
    meta.addEnchant(Enchantment.DURABILITY, 5, true);
    ItemStack i = metaa;  
    i.setItemMeta(meta);
    return i;
}




@Override
public void onAttackPassive(EntityDamageByEntityEvent e) {
	Damageable p = (Player) e.getDamager();
	
	double d = p.getHealth();
	if(d < (double) p.getMaxHealth() - ((double)e.getDamage() * 0.2 + 1))
	p.setHealth(d + (double)e.getDamage() * 0.2);
	else 
		 p.setHealth(p.getMaxHealth());
	
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
