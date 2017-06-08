package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class MagicStick extends MysticItem {

	public MagicStick(MysticItemManager instance) {
	        
	        super(itemek(new ItemStack(Material.STICK)), instance, MysticItemType.USABLE);
	      

	}

	
	static ItemStack itemek(ItemStack metaa){
		ItemMeta meta = metaa.getItemMeta();
		meta.setDisplayName("§7Magic stick");
        List<String> lore = new ArrayList<String>();
        lore.add("§8§oA magic stick that restores the vital energy to the owner.");
        lore.add("§8Restored health: §61 Heart");
        lore.add("§8Restored food: §61 FoodPoint");
        meta.setLore(lore);
        ItemStack i = metaa;
        
        i.setItemMeta(meta);
        return i;
	}


	@Override
	public void onUse(PlayerInteractEvent e) {
		double d = ((Damageable) e.getPlayer()).getHealth();
		if(d < 19)
		e.getPlayer().setHealth(d + 2);
		else 
			e.getPlayer().setHealth(((Damageable)e.getPlayer()).getMaxHealth());

		if(e.getPlayer().getFoodLevel() < 19)
		e.getPlayer().setFoodLevel(e.getPlayer().getFoodLevel() + 2);
		else
			e.getPlayer().setFoodLevel(20);
		 ItemStack is = e.getPlayer().getItemInHand();
		 if(is.getAmount() > 1)
		    is.setAmount(is.getAmount() - 1);
		else e.getPlayer().setItemInHand(null);
		 
		 e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ORB_PICKUP, 60, new Random().nextFloat());
         
	}

	
   
    }
	

