package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class HornOfPlenty extends MysticItem {

public HornOfPlenty(MysticItemManager instacne) {
        
        super(itemek(new ItemStack(Material.WHEAT)), instacne, MysticItemType.USABLE);
        instance = instacne;
     

}


static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§eHorn Of Plenty");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§oHorn Of Plenty is useful thing in survival.");
    lore.add("§8§oOnce the gods used it to fill their hunger.");
    lore.add("§8Returned food points per HP : §63/3");
    meta.setLore(lore);
    ItemStack i = metaa;
    i.setItemMeta(meta);
    return i;
}


@Override
public void onUse(PlayerInteractEvent e) {
	Player p =  e.getPlayer();
	
	
	
	if(p.getFoodLevel() < 17){
	p.setFoodLevel(p.getFoodLevel() + 6);
	e.getPlayer().damage(6D);
	}
	else{
		
		e.getPlayer().damage((double)20 - p.getFoodLevel());		
		p.setFoodLevel(20);
		
	}
	 p.playSound(p.getLocation(), Sound.CREEPER_HISS, 2, new Random().nextFloat());
	
 
}
	
	
}
