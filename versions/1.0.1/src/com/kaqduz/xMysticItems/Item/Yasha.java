package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class Yasha extends MysticItem {

	public Yasha(MysticItemManager Instance) {
		super(itemek(new ItemStack(Material.IRON_SWORD)), Instance,MysticItemType.ATTACKABLE);


	}
	
	static ItemStack itemek(ItemStack metaa){
		ItemMeta meta = metaa.getItemMeta();
		meta.setDisplayName("§a Yasha");//from dota 2 ^^
	    List<String> lore = new ArrayList<String>();
	    lore.add("§8§oBlade increasing the agility of the attacker. ");
	    lore.add("§8Instant heal - level: §61");
	    lore.add("§8Instant heal - chance: §610%");
	    meta.setLore(lore);
	    ItemStack i = metaa;
	    i.setItemMeta(meta);
	    i.addEnchantment(Enchantment.DAMAGE_ALL, 2);
	    return i;
	}
	@Override
	public void onAttackPassive(EntityDamageByEntityEvent e){	
		if(((EntityDamageByEntityEvent) e).getDamager() instanceof Player){
			
	Player attacker = (Player) ((EntityDamageByEntityEvent) e).getDamager();
	double d = Math.random();

    if (d < 0.1){
    	
    	attacker.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1 , 1));
    	attacker.playSound(attacker.getLocation(), Sound.LAVA_POP, 1f, 1F);
    }
	
	
		}
		
	
	}
	
}
