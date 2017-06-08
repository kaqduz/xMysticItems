package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.kaqduz.xMysticItems.Util.MysticItemManager;
public class Refresher extends MysticItem {

	public Refresher(MysticItemManager instacne) {
        
        super(itemek(new ItemStack(Material.REDSTONE)), instacne, MysticItemType.USABLE);
        instance = instacne;

}


static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§9Refresher");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§oA mythical dye that refreshes and repairs all items owned by the owner.");
    lore.add("§aWill not repair armor. U have to take off your armor if u want to repair it.");
    meta.setLore(lore);
    ItemStack i = metaa;
    i.setItemMeta(meta);
    return i;
}


@Override
public void onUse(PlayerInteractEvent e) {
	
	Player p =  e.getPlayer();	
	p.setHealth(((Damageable)p).getMaxHealth());
	p.setFoodLevel(20);
	repair(e.getPlayer());
	ItemStack is = e.getPlayer().getItemInHand();
	 if(is.getAmount() > 1)
		    is.setAmount(is.getAmount() - 1);
		else e.getPlayer().setItemInHand(null);
	 p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 2, new Random().nextFloat());
	 p.updateInventory();
 
}
public void repair(Player p)
{
  for (int i = 0; i <= 36; i++) {
    try
    {
      ItemStack w = p.getInventory().getItem(i);
      if (itemCheck(w)) {
        p.getInventory().getItem(i).setDurability((short)0);
      }
    }
    catch (Exception localException) {
    	localException.printStackTrace();
    }
  }
}

@SuppressWarnings("deprecation")
private boolean itemCheck(ItemStack w)
{
	if(w == null)
		return false;
  if ((w.getType().getId() == 256) || (w.getType().getId() == 257) || 
    (w.getType().getId() == 258) || (w.getType().getId() == 259) || 
    (w.getType().getId() == 261) || (w.getType().getId() == 267) || 
    (w.getType().getId() == 268) || (w.getType().getId() == 269) || 
    (w.getType().getId() == 270) || (w.getType().getId() == 271) || 
    (w.getType().getId() == 272) || (w.getType().getId() == 273) || 
    (w.getType().getId() == 274) || (w.getType().getId() == 275) || 
    (w.getType().getId() == 276) || (w.getType().getId() == 277) || 
    (w.getType().getId() == 278) || (w.getType().getId() == 279) || 
    (w.getType().getId() == 283) || (w.getType().getId() == 284) || 
    (w.getType().getId() == 285) || (w.getType().getId() == 286) || 
    (w.getType().getId() == 290) || (w.getType().getId() == 291) || 
    (w.getType().getId() == 292) || (w.getType().getId() == 293) || 
    (w.getType().getId() == 294) || (w.getType().getId() == 298) || 
    (w.getType().getId() == 299) || (w.getType().getId() == 300) || 
    (w.getType().getId() == 301) || (w.getType().getId() == 302) || 
    (w.getType().getId() == 303) || (w.getType().getId() == 304) || 
    (w.getType().getId() == 305) || (w.getType().getId() == 306) || 
    (w.getType().getId() == 307) || (w.getType().getId() == 308) || 
    (w.getType().getId() == 309) || (w.getType().getId() == 310) || 
    (w.getType().getId() == 311) || (w.getType().getId() == 312) || 
    (w.getType().getId() == 313) || (w.getType().getId() == 314) || 
    (w.getType().getId() == 315) || (w.getType().getId() == 316) || 
    (w.getType().getId() == 317) || (w.getType().getId() == 346) || 
    (w.getType().getId() == 359)) {
    return true;
  }
  return false;
}


}
