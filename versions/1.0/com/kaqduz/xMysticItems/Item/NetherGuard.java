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

public class NetherGuard extends MysticItem {

public NetherGuard(MysticItemManager instacne) {
        
        super(itemek(new ItemStack(Material.FIREBALL)), instacne, MysticItemType.DEATHACCESSABLE);
        instance = instacne;
        
}


static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§CNether Guard");
    List<String> lore = new ArrayList<String>();
    lore.add("§8§oStrange shield, forged in hell, when owner dies,");
    lore.add("§8§oplayer won't lose items and will reborn him in the same place.");
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
		if((victim.getHealth()-e.getDamage()) <= 0 && !instance.getPlugin().PlayerHasItem(p, instance.getItemByName("§dEnder Guard"))) {
            
            
            e.setCancelled(true);
            victim.setHealth(20.0);
            p.setFoodLevel(20);
            p.getInventory().removeItem(itemstack);
            p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 1f, 0.001F);
            
        }
	}
	
	
	
}


public void removeItem(Player player, ItemStack name, int Amount) {
    ItemStack[] content = player.getInventory().getContents();
    int amounttoremove = Amount;
    for (int i = 0; i <= content.length-1; i++) {
        ItemStack is = content[i];
       
        if (is == null || !is.hasItemMeta() || !is.getItemMeta().getDisplayName().equals(name.getItemMeta().getDisplayName()))
            continue;
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
