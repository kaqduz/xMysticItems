package com.kaqduz.xMysticItems.Util;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import com.kaqduz.xMysticItems.xMysticItems;
import com.kaqduz.xMysticItems.Item.MysticItem;

public class MysticItemManager {

	ArrayList<MysticItem> mitems = new ArrayList<MysticItem>();
	xMysticItems instance;
	
	public MysticItemManager(xMysticItems plugin){
		if(plugin != null){
			instance = plugin;
			
			
			
			
		}
	}
	
    
	public void registerItem(MysticItem ... a){
		
		for(MysticItem b : a){
			mitems.add(b);
			Bukkit.getServer().getPluginManager().registerEvents(b, instance);
		}
		instance.getLogger().info("[Manager]" + a.length +  " Mystic Items registered!");
	}
	public void unregisterItem(MysticItem a){
		
		if(mitems.contains(a)){
			
			mitems.remove(a);
		}
		else throw new NullPointerException("This MysticItem isn't registered!");
		
	}
	public void unregisterAll(){
		
		mitems.clear();
	}

	public ArrayList<MysticItem> getMysticItems(){
		
		return  mitems;
	}
	public MysticItem[] getMysticItemsArray(){
		return (MysticItem[]) mitems.toArray();
		
	}
	public xMysticItems getPlugin(){
		
		return this.instance;
		
	}
	public ItemStack getItemByName(String name){
		
		if(getMysticItems().size() != 0){
			for (MysticItem a : mitems){
				if(a.getItem().hasItemMeta()){
					if(a.getItem().getItemMeta().getDisplayName().equals(name))
						return a.getItem();
						
				}
				
			}
			
				return null;
			
		}
		else
			return null;
	}
	
	
	
}
