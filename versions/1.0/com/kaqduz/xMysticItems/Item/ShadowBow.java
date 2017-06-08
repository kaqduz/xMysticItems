package com.kaqduz.xMysticItems.Item;

import java.util.ArrayList;
import java.util.Collection;
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
    lore.add("§8Slow per shoot - level: §61");
    lore.add("§8Slow per shoot - duration: §64 seconds");
    lore.add("§aSlow effect increases every accurate shoot.");
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
		        	int amplifier = 0;
		        	Collection<PotionEffect> effects = victim.getActivePotionEffects();
		        	for (PotionEffect effect : effects){
		        		
		        		if(effect.getType() == PotionEffectType.SLOW){
		        			amplifier = effect.getAmplifier();
		        			victim.removePotionEffect(PotionEffectType.SLOW);
		        			victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, amplifier + 1, false));
		        			
		        			
		        		}
		        		
		        		
		        	
		        	}
		        	if(amplifier == 0){
		        		
		        		victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 1, false));
		        		
		        	}
		        	
		        }
		    }
		}
	}
}
}
