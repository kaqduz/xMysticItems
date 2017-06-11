package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class Sange extends MysticItem {

	public Sange( MysticItemManager Instance) {
		super(itemek(new ItemStack(Material.GOLD_SWORD)), Instance, MysticItemType.ATTACKABLE);

	}
	
	static ItemStack itemek(ItemStack metaa){
		ItemMeta meta = metaa.getItemMeta();
		meta.setDisplayName("§4 Sange");
	    List<String> lore = new ArrayList<String>();
	    lore.add("§8§oBlade causing enemies to hurt. ");
	    lore.add("§8Instant damage - level: §61");
	    lore.add("§8Instant damage - chance: §610%");
	    meta.setLore(lore);
	    ItemStack i = metaa;
	    i.setItemMeta(meta);
	    i.addEnchantment(Enchantment.DAMAGE_ALL, 2);
	    return i;
	}
	@Override
	public void onAttackPassive(EntityDamageByEntityEvent e){	
	
		if(e.getDamager() instanceof Player){
			
	double d = Math.random();

    if (d < 0.1){
    	LivingEntity ent = (LivingEntity) e.getEntity();

    	 ent.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1 , 1));
    	
    	((Player)e.getDamager()).playSound(ent.getLocation(), Sound.SPLASH, 1f, 1F);
    }
	
    
		}
	
	}
	
}
