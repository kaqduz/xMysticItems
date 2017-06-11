package com.kaqduz.xMysticItems.Event;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.kaqduz.xMysticItems.Item.Dominator;
import com.kaqduz.xMysticItems.Item.HelmOfMadness;
import com.kaqduz.xMysticItems.Item.Sange;
import com.kaqduz.xMysticItems.Item.SangeAndYasha;
import com.kaqduz.xMysticItems.Item.Yasha;
import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class RecipeCraft implements Listener {
	MysticItemManager m;
	
	public RecipeCraft(MysticItemManager manager){
		
		m = manager;
		
	}
	// From Bukkit.org;
	//Thread: https://bukkit.org/threads/create-crafting-recipe-custom-ingredients.232664/
	
	
    @EventHandler
    public void restrictCrafting(final PrepareItemCraftEvent event) {
 
        String boneMace = new SangeAndYasha(m).getItem().getItemMeta().getDisplayName();
        String bone1 = new Sange(m).getItem().getItemMeta().getDisplayName();
        String bone2 = new Yasha(m).getItem().getItemMeta().getDisplayName();
        short dur1 = 0;
        short dur2 = 0;

      if (event.getRecipe().getResult().hasItemMeta() && boneMace.equals(event.getRecipe().getResult().getItemMeta().getDisplayName())) {
   

        boolean found1 = false, found2 = false;
        for (ItemStack item: event.getInventory().getMatrix()) {
          if (item != null && item.hasItemMeta()) {
            if (bone1.equals(item.getItemMeta().getDisplayName())) {
              found1 = true;
              dur1 = item.getDurability();
            } else if (bone2.equals(item.getItemMeta().getDisplayName())) {
              found2 = true;
              dur2 = item.getDurability();
            } 
          }
        }
        if (!found1 || !found2 ) {
      	new BukkitRunnable(){
      	    @Override
      	    public void run(){
      	    	
      	      event.getInventory().setResult(new ItemStack(Material.AIR));

      	    }
      	    }.runTaskLater(m.getPlugin(), 1);
    	      event.getInventory().setResult(new ItemStack(Material.AIR));
    	      event.getRecipe().getResult().setType(Material.AIR);
        }
        else {
            
            event.getRecipe().getResult().setDurability((short) ((dur1 + dur2) / 2));
    
        }
      }
      boneMace = new HelmOfMadness(m).getItem().getItemMeta().getDisplayName();
      bone1 = new Dominator(m).getItem().getItemMeta().getDisplayName();
      if (event.getRecipe().getResult().hasItemMeta() && event.getRecipe().getResult().getItemMeta().getDisplayName() != null && event.getRecipe().getResult().getItemMeta().getDisplayName().equals(bone1)) {
    	  boolean found1 = false, found2 = false;
          for (ItemStack item: event.getInventory().getMatrix()) {
            if (item != null && item.hasItemMeta()) {
              if (bone1.equals(item.getItemMeta().getDisplayName())) {
                found1 = true;
                
              
              } 
            }
            if(item != null && item.getType() == Material.NETHER_STAR){
            	
            	found2 = true;
            	
            }
          }
          if (!found1 || !found2) {
        	new BukkitRunnable(){
        	    @Override
        	    public void run(){
        	    	
        	      event.getInventory().setResult(new ItemStack(Material.AIR));

        	    }
        	    }.runTaskLater(m.getPlugin(), 1);
        	    
      	      event.getInventory().setResult(new ItemStack(Material.AIR));
      	      event.getRecipe().getResult().setType(Material.AIR);
          }
          else {
        	  new BukkitRunnable(){
          	    @Override
          	    public void run(){
          	    	
          	      event.getInventory().setResult(new HelmOfMadness(m).getItem());

          	    }
          	    }.runTaskLater(m.getPlugin(), 1);
          	    
        	      event.getInventory().setResult(new HelmOfMadness(m).getItem());
        	   
        	  
        	  
        	  
          }
    	  
    	  
      }
      
    }
    
}
