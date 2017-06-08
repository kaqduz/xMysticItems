package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class Dagger extends MysticItem {

	public Dagger(MysticItemManager instance) {
        
        super(itemek(new ItemStack(Material.WOOD_SWORD)), instance, MysticItemType.ATTACKABLE);

}


static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§7Dagger");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§oDagger ideal for trimming the throat. ");
    lore.add("§8Poison I effect - duration: §63 seconds");
    lore.add("§8Fire effect - duration: §63 seconds");
    meta.setLore(lore);
    ItemStack i = metaa;
    i.setItemMeta(meta);
    return i;
}




@Override
public void onAttack(EntityDamageByEntityEvent e) {

	LivingEntity ent = (LivingEntity) e.getEntity();
	ent.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 60, 1));
	ent.setFireTicks(60);
	
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
