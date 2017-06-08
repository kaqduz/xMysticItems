package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class RealityBlade extends MysticItem {

	// TO DO
	// ITEM RELEASE DELAYED
	
	
public RealityBlade(MysticItemManager instance) {
        
        super(itemek(new ItemStack(Material.DIAMOND_SWORD)), instance, MysticItemType.ATTACKABLE);

}


static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§c§lREALITY BLADE");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§o'... and when he was bored, one motion of a sword duplicated reality ...'");   
    lore.add("§8Amount of duplicates : §63");
    lore.add("§8Duplicate's damage : §63 per attack");
    lore.add("§8Duplicate's health : §61.5 heart");
    lore.add("§8Critical damage: §6300%");
    lore.add("§8Critical damage - chance : §615%");
    meta.setLore(lore);
    ItemStack i = metaa;
    meta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
    meta.addEnchant(Enchantment.DURABILITY, 5, true);
    i.setItemMeta(meta);
    
    return i;
}



@Override
public void onAttackPassive(EntityDamageByEntityEvent e){	

	if(!e.isCancelled() && e.getDamager() instanceof Player){
	
		
double d = Math.random();

if (d < 0.15){
	
	e.setDamage(e.getDamage() * 4.5f);
	
	
}
	}
}



}
