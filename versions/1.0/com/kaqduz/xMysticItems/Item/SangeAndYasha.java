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

public class SangeAndYasha extends MysticItem {

	public SangeAndYasha( MysticItemManager Instance) {
		super(itemek(new ItemStack(Material.DIAMOND_SWORD, 1)), Instance, MysticItemType.ATTACKABLE);

	}
	
	static ItemStack itemek(ItemStack metaa){
		ItemMeta meta = metaa.getItemMeta();
		meta.setDisplayName("§d Sange And Yasha");
	    List<String> lore = new ArrayList<String>();
	    lore.add("§8§oThe killer combination of the two largest blades. ");
	    lore.add("§8Instant damage - level: §62");
	    lore.add("§8Instant heal - level: §62");
	    lore.add("§8Efects - chance: §612%");
	    lore.add("§a§oCan be crafted: Yasha §6+ §4Sange");

	    meta.setLore(lore);
	    ItemStack i = metaa;
	    i.setItemMeta(meta);
	    i.addEnchantment(Enchantment.DAMAGE_ALL, 4);
	    i.addEnchantment(Enchantment.DURABILITY, 3);

	    return i;
	}
	@Override
	public void onAttackPassive(EntityDamageByEntityEvent e){	
		if(e.getDamager() instanceof Player){
			Player attacker = (Player) e.getDamager();
	double d = Math.random();

    if (d < 0.12){
    	LivingEntity ent = (LivingEntity) e.getEntity();

    	 ent.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1 , 2));   	  	
    	attacker.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1 , 2));   	
    	attacker.playSound(attacker.getLocation(), Sound.LAVA_POP, 1f, 1F);
    	attacker.playSound(ent.getLocation(), Sound.SPLASH, 1f, 1F);
    }
	
    
		}
	
	}
	
}
