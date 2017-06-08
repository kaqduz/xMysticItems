package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class HelmOfMadness extends MysticItem {

	public HelmOfMadness(MysticItemManager instance) {
        
        super(itemek(new ItemStack(Material.DIAMOND_HELMET)), instance, MysticItemType.CUSTOM);

}


static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§6§l§kab§r§4§l HELM OF MADNESS §6§k§lab");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§oNo one was able to survive the day in eternal jail");
    lore.add("§8§oImmediately after being sent to the dungeon, your mind was possessed by the chaos and disorder.");
    lore.add("§8§oEvery second, minute, hour approached you to your end.");
    lore.add("§8§oOver time, the magician cursed prison in this helmet - Helm of Madness");
    lore.add("§8Life steal: 7.5% actual target's health");
    lore.add("§aWorks only when equipped");
    meta.setLore(lore);
    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true);
    meta.addEnchant(Enchantment.DURABILITY, 10, true);
    ItemStack i = metaa;  
    i.setItemMeta(meta);
    return i;
}




@EventHandler
public void onAttackHelmet(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player){
	if(((Player) e.getDamager()).getInventory().getHelmet() != null && ((Player) e.getDamager()).getInventory().getHelmet().hasItemMeta() && ((Player) e.getDamager()).getInventory().getHelmet().getItemMeta().getDisplayName() != null && ((Player) e.getDamager()).getInventory().getHelmet().getItemMeta().getDisplayName().equals(this.itemstack.getItemMeta().getDisplayName())){
	Damageable v = (Damageable) e.getEntity();
	Damageable p = (Player) e.getDamager();
	double d = v.getHealth();
	if(p.getHealth() < (double) p.getMaxHealth() - ((double)d * 0.075 + 1))
	p.setHealth(p.getHealth() + ((double)d * 0.075));
	else 
		 p.setHealth(p.getMaxHealth());
	
	v.damage(((double)d * 0.075));
	}
		}
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
