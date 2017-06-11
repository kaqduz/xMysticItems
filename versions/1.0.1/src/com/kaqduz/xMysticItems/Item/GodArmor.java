package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class GodArmor extends MysticItem {

	public GodArmor(MysticItemManager instance) {
        
        super(itemek(new ItemStack(Material.DIAMOND_CHESTPLATE)), instance, MysticItemType.DEFENDABLE);
        

}


static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§4GOD §6ARMOR");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§oDivine armor, which protected the lives of many mortals.");
    lore.add("§8§oPart of damage is blocked, and relfected to damager.");
    lore.add("§8§oIf you get lucky, you can block all damage and reflect them all!");
    lore.add("§8Reflected damage : §630%");
    lore.add("§8Greater reflect - chance: §615%");
    lore.add("§8Gteater reflect - amount: §6125%");

    meta.setLore(lore);
    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
    meta.addEnchant(Enchantment.DURABILITY, 10, true);
    
    ItemStack i = metaa;
    i.setItemMeta(meta);
   

    return i;
}


	@Override
	public void onDefend(EntityDamageEvent e){
		

		if(e instanceof EntityDamageByEntityEvent ){
			

		EntityDamageByEntityEvent event = (EntityDamageByEntityEvent) e;
		Entity damager = null;
		
		if(e.getEntity() instanceof Player &&
				((Player)e.getEntity()).getInventory().getChestplate() != null &&
				((Player)e.getEntity()).getInventory().getChestplate().hasItemMeta() &&
				((Player)e.getEntity()).getInventory().getChestplate().getItemMeta().getDisplayName() != null &&
				((Player)e.getEntity()).getInventory().getChestplate().getItemMeta().getDisplayName().equals(itemstack.getItemMeta().getDisplayName())){
		double d = Math.random();
		if(event.getDamager() instanceof LivingEntity)
		damager = event.getDamager();
		if(event.getDamager() instanceof Arrow)
			damager = ((Arrow) event.getDamager()).getShooter();
		if(d < 0.15){
			
			
			((Damageable) damager).damage(e.getDamage() * 1.25);
			e.setDamage(0.0);
			
			
		}
		else {
			
			((Damageable) damager).damage(e.getDamage() * 0.3);
			e.setDamage(e.getDamage() * 0.3);
			
		}
		}
		}
	}
	

}
