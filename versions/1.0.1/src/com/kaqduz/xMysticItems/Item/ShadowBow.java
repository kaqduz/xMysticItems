package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.kaqduz.xMysticItems.Util.MysticItemManager;

public class ShadowBow extends MysticItem {

	
public ShadowBow(MysticItemManager instance) {
        
        super(itemek(new ItemStack(Material.BOW)), instance, MysticItemType.CUSTOM);

}


static ItemStack itemek(ItemStack metaa){
	ItemMeta meta = metaa.getItemMeta();
	meta.setDisplayName("§9Shadow Bow");
    List<String> lore = new ArrayList<String>();
    lore.add("§9§oDark bow used by the Great Horde of Undead");
    lore.add("§8§oEach accurate shot drains the victim's hope for survival.");
    lore.add("§8Slow effect - level: §62");
    lore.add("§8Slow-digging effect - level: §61");
    lore.add("§8Effects - duration: §63 seconds");
    meta.setLore(lore);
    meta.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
    meta.addEnchant(Enchantment.ARROW_FIRE, 3, true);
    meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
    ItemStack i = metaa;
    i.setItemMeta(meta);
    return i;
}
@EventHandler
public void onDefend(EntityDamageEvent e) {
	if(e instanceof EntityDamageByEntityEvent){
		if(((EntityDamageByEntityEvent) e).getDamager() instanceof Arrow) {
			
		    Arrow a = (Arrow) ((EntityDamageByEntityEvent) e).getDamager();
	       

		    if(a.getShooter() instanceof Player && e.getEntity() instanceof LivingEntity) {
		    	 LivingEntity victim =  (LivingEntity) e.getEntity();
		        Player player = (Player) a.getShooter();
		        if(player.getItemInHand() != null && player.getItemInHand().hasItemMeta() && player.getItemInHand().getItemMeta().getDisplayName().equals("§9Shadow Bow")){		        	
		        	
		        		
		        		victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 1, false));
		        		victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 60, 1, false));
		        		
		        	
		        	
		        }
		    }
		}
	}
}
}
