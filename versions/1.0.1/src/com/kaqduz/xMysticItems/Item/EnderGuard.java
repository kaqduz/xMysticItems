package com.kaqduz.xMysticItems.Item;


	

	import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

	public class EnderGuard extends MysticItem {

	public EnderGuard(MysticItemManager instacne) {
	        
	        super(itemek(new ItemStack(Material.EYE_OF_ENDER)), instacne, MysticItemType.DEATHACCESSABLE);
	        instance = instacne;

	}


	static ItemStack itemek(ItemStack metaa){
		ItemMeta meta = metaa.getItemMeta();
		meta.setDisplayName("§dEnder Guard");
	    List<String> lore = new ArrayList<String>();
	    lore.add("§8§oChaotic shield, all that is known is that, it was forged somewhere, beetwen our world ");
	    lore.add("§8§oand End, which makes that player will not die, and will respawn at the spawn of the world.");
	    lore.add("§a§oIn concrast to Nether Guard, it respawns at the spawnpoint.");
	    lore.add("§aAfter death it turns into Nether Guard.");
	    lore.add("§aWorks only when you will be killed by other entity.");

	    meta.setLore(lore);
	    ItemStack i = metaa;
	    i.setItemMeta(meta);
	    return i;
	}
	@Override
	public void onDeffendPassive(EntityDamageEvent e){
		if(e.getEntity() instanceof Player){

			Damageable victim = (Player) e.getEntity();
			Player p = (Player) e.getEntity();
			if((victim.getHealth()- e.getDamage()) <= 0) {

	            
	            e.setCancelled(true);
	            victim.setHealth(20.0);
	            p.setFoodLevel(20);
	            p.getInventory().removeItem(itemstack);
	            p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1f, 0.001F);
	            victim.teleport(victim.getWorld().getSpawnLocation());
	            victim.getWorld().dropItem(victim.getLocation(), instance.getItemByName("§CNether Guard"));
	            
	        }
		}
		
	}


	

	public void removeItem(Player player, ItemStack name, int Amount) {
	    ItemStack[] content = player.getInventory().getContents();
	    int amounttoremove = Amount;
    	System.out.println("tes6t 11");

	    for (int i = 0; i < content.length; i++) {
	        ItemStack is = content[i];
	       
	        if (is == null || !is.hasItemMeta() || !is.getItemMeta().getDisplayName().equals(name.getItemMeta().getDisplayName())){
	        	if(is != null && is.hasItemMeta()){
	        	System.out.println(is.hasItemMeta());
	        	System.out.println(is.getItemMeta().getDisplayName().equals(name));
	        	System.out.println(is.getItemMeta().getDisplayName());
	        	}
	            continue;
	        }
	        if (is.getAmount() == amounttoremove){
	        	
	            content[i] = new ItemStack(Material.AIR);
	            return;
	        }
        	

	        content[i].setAmount(content[i].getAmount()-amounttoremove);
	        return;
	    }
	}

	public void removeItem(Player player, String name, int Amount) {
	    ItemStack[] content = player.getInventory().getContents();
	    int amounttoremove = Amount;
	    for (int i = 0; i <= content.length-1; i++) {
	        ItemStack is = content[i];
	       
	        if (is == null || !is.hasItemMeta() || !is.getItemMeta().getDisplayName().equals(name))
	            continue;
	        if (is.getAmount() == amounttoremove){
	            content[i] = new ItemStack(Material.AIR);
	            return;
	        }
	        content[i].setAmount(content[i].getAmount()-amounttoremove);
	        return;
	    }
	}
	}

	
	
	
	

