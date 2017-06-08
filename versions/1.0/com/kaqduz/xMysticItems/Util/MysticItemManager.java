package com.kaqduz.xMysticItems.Util;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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
	public HashMap<String, Long> SunderCooldowns = new HashMap<String, Long>();
    public boolean CanUseSunder(Player p){
    	if(!p.isOp())
    		return true;
   int cooldownTime = 150; // The number of seconds the player has to wait
   if(SunderCooldowns.containsKey(p.getName())) {
    
   long secondsLeft = ((SunderCooldowns.get(p.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
    
   if(secondsLeft>0) {
		  p.sendMessage("§8# §cU have to wait §6" + secondsLeft + " second(s)§c, to use this again!");
   return false;
   }
   }
   SunderCooldowns.put(p.getName(), System.currentTimeMillis());
   return true;
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
