package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class MithirilArmor extends MysticItem {
	
public MithirilArmor(MysticItemManager instacne) {
        
        super(itemek(new ItemStack(Material.DIAMOND_BOOTS)), instacne, MysticItemType.DEFENDABLE);
        instance = instacne;

}



static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§bMithiril Boots");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§oPowerful mithril boots that are immune to any damage,");
    lore.add("§8§othat does not come from other entities.");
    meta.setLore(lore);
    ItemStack i = metaa;
    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
    meta.addEnchant(Enchantment.DURABILITY, 5, true);

    i.setItemMeta(meta);
    return i;
}


	@Override
	public void onDeffendPassive(EntityDamageEvent e ){
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(p.getInventory().getBoots() != null && p.getInventory().getBoots().hasItemMeta() && p.getInventory().getBoots().getItemMeta().getDisplayName().equals(itemstack.getItemMeta().getDisplayName())){
				if(e instanceof EntityDamageByEntityEvent){
					
				}
				else {
					e.setDamage(0.0);
					
				}
				
			}
		}
		
	}
	@Override
	public  void onUse(PlayerInteractEvent e) {
		if(e.getPlayer().getInventory().getBoots() == null){
		e.getPlayer().getInventory().setBoots(e.getPlayer().getItemInHand());
		e.getPlayer().setItemInHand(new ItemStack(Material.AIR));

		}
		
	}
}
